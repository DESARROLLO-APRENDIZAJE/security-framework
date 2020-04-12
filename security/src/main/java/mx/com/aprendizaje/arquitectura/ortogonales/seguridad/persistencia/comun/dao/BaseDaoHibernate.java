package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.comun.dao;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.jdbc.Work;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("hiding")
@Repository
public abstract class BaseDaoHibernate<T extends Serializable> implements BaseDao<T> {

	protected static final Logger log = Logger.getLogger(BaseDaoHibernate.class);
	protected Class<? extends T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseDaoHibernate() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clazz = (Class) pt.getActualTypeArguments()[0];
    }

	@SuppressWarnings("unchecked")
	public T findOne(final Serializable id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName())
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(final String login) {
		return getCurrentSession().createQuery(
				"from " + clazz.getName() + " u where u.login='" + login + "'")
				.list();
	}

	
//	public void save(final T entity) {
//		getCurrentSession().persist(entity);
//	}

//	@SuppressWarnings("unchecked")
//	public T update(final T entity) {
//		return (T) getCurrentSession().merge(entity);
//	}

	public void delete(final T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(final Serializable id) {
		final T entity = findOne(id);
		delete(entity);
	}

	// / AQUI EMPIEZAN METODOS PARA EL USO DEL FRAMEWORK DE AUDITORIA

	public void rollback() {
		getSession().getTransaction().rollback();
	}

	public void commit() {
		getSession().getTransaction().commit();
	}

	public void beginTransaction() {
		if (getSession().getTransaction() != null) {
			getSession().getTransaction();
		} else {
			getSession().beginTransaction();
		}
	}

	protected Query getNamedQuery(String queryName) {
		return getSession().getNamedQuery(queryName);
	}

	public void clear() {
		getSession().clear();
	}

	public void flush() {
		getSession().flush();
	}

	public void closeSession() {
		try {
			getSession().close();
		} catch (Exception e) {

		}
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	protected Page<T> findPage(Query aQuery, int firstRecord, int aPageSize,
			int totalElements) throws HibernateException {
		int pageSize = aPageSize;
		int total = totalElements;
		if (pageSize <= 0)
			pageSize = 15;
		if (log.isDebugEnabled())
			log.debug(aQuery.getQueryString());
		Query query = aQuery.setFirstResult(firstRecord);
		query = query.setMaxResults(pageSize + 1);
		List<T> elements = (List<T>) query.list();
		boolean hasNextPage = false;
		if (elements.size() > pageSize) {
			elements.remove(pageSize);
			hasNextPage = true;
		}
		if (!hasNextPage)
			total = firstRecord + elements.size();
		if (total < 0)
			total = firstRecord + pageSize + 1;
		Page<T> page = new Page<T>(elements, firstRecord, pageSize, total);
		page.setHasNextPage(hasNextPage);
		return page;
	}

	protected Page<T> findPage(Query aQuery, int firstRecord, int aPageSize) {
		return findPage(aQuery, firstRecord, aPageSize, -1);
	}

	protected Page<T> findPage(Criteria aCriteria, int firstRecord,
			int aPageSize) throws HibernateException {
		return findPage(aCriteria, ((Order) (null)), firstRecord, aPageSize);
	}

	@SuppressWarnings("unchecked")
	protected Page<T> findPage(Criteria aCriteria, Order order,
			int firstRecord, int aPageSize) throws HibernateException {
		int totalElements = -1;
		boolean hasNextPage = false;
		int pageSize = aPageSize;
		if (pageSize <= 0) {
			pageSize = 15;
			log.debug((new StringBuilder(
					"No se especific\363 tama\361o de la p\341gina... usando por default: "))
					.append(pageSize).toString());
		}
		if (order != null)
			aCriteria.addOrder(order);
		Criteria criteria = aCriteria.setFirstResult(firstRecord);
		criteria = criteria.setMaxResults(pageSize + 1);
		List<T> elements = (List<T>) criteria.list();
		if (elements.size() > pageSize) {
			elements.remove(pageSize);
			hasNextPage = true;
		}
		if (hasNextPage) {
			Criteria cImpl = (Criteria) aCriteria;
			cImpl.setFirstResult(0);
			totalElements = ((Integer) aCriteria.setProjection(
					Projections.rowCount()).uniqueResult()).intValue();
		} else {
			totalElements = firstRecord + elements.size();
		}
		Page<T> page = new Page<T>(elements, firstRecord, pageSize,
				totalElements);
		page.setHasNextPage(hasNextPage);
		return page;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected ClassMetadata getClassMetadata() {
		return getSessionFactory().getClassMetadata(getPersistentClass());
	}

	public T findById(Serializable id) {
		return findById(id, false);
	}

	@SuppressWarnings("unchecked")
	public T findById(Serializable id, boolean lock) {
		T entity;
		if (lock)
			entity = (T) getSession().load(getPersistentClass(), id,
					LockOptions.UPGRADE);
		else
			entity = (T) getSession().load(getPersistentClass(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public T getById(Serializable id) {
		return (T) getSession().get(getPersistentClass(), id);
	}

	public Page<T> findAll(int firstRecord) {
		return findAll(firstRecord, -1);
	}

	public Page<T> findAll(int firstRecord, int pageSize) {
		return findByCriteria(firstRecord, pageSize, new Criterion[0]);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Page<T> findByCriteria(int firstRecord, int pageSize,
			Criterion criterion[]) {
		List order = new ArrayList(1);
		String identityProperty = getClassMetadata()
				.getIdentifierPropertyName();
		order.add(Order.asc(identityProperty));
		return findByCriteria(firstRecord, pageSize, order, criterion);
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion criterion[]) {
		Criteria criteria = createCriteria();
		Criterion acriterion[];
		int j = (acriterion = criterion).length;
		for (int i = 0; i < j; i++) {
			Criterion c = acriterion[i];
			if (c != null)
				criteria.add(c);
		}

		return (List<T>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion criterion[], List<Order> orders) {
		Criteria criteria = createCriteria();
		Criterion acriterion[];
		int j = (acriterion = criterion).length;
		for (int i = 0; i < j; i++) {
			Criterion c = acriterion[i];
			if (c != null)
				criteria.add(c);
		}

		for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();) {
			Order o = iterator.next();
			if (o != null)
				criteria.addOrder(o);
		}

		return (List<T>) criteria.list();
	}

	protected Page<T> findByCriteria(int firstRecord, int pageSize,
			List<Order> order, Criterion criterion[]) {
		Criteria criteria = createCriteria();
		Criterion acriterion[];
		int j = (acriterion = criterion).length;
		for (int i = 0; i < j; i++) {
			Criterion c = acriterion[i];
			if (c != null)
				criteria.add(c);
		}

		for (Iterator<Order> iterator = order.iterator(); iterator.hasNext();) {
			Order o = (Order) iterator.next();
			if (o != null)
				criteria.addOrder(o);
		}

		return (Page<T>) findPage(criteria, firstRecord, pageSize);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String excludeProperty[]) {
		Criteria criteria = createCriteria();
		Example example = Example.create(exampleInstance);
		String as[];
		int j = (as = excludeProperty).length;
		for (int i = 0; i < j; i++) {
			String exclude = as[i];
			example.excludeProperty(exclude);
		}

		criteria.add(example);
		return (List<T>) criteria.list();
	}

	public Page<T> findByExample(int firstRecord, int pageSize,
			T exampleInstance, String excludeProperty[]) {
		Criteria criteria = createCriteria();
		Example example = Example.create(exampleInstance);
		String as[];
		int j = (as = excludeProperty).length;
		for (int i = 0; i < j; i++) {
			String exclude = as[i];
			example.excludeProperty(exclude);
		}

		criteria.add(example);
		return findPage(criteria, firstRecord, pageSize);
	}

	public Class<T> getPersistentClass() {
		return getPersistentClass();
	}

	public T saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	public T merge(T entity) {
		getSession().merge(entity);
		return entity;
	}

	public Criteria createCriteria() {
		return getSession().createCriteria(getPersistentClass());
	}

	////////////////////////////////////////////////////////////
	// IMPLEMENTACION DE SAVE Y UPDATE
	////////////////////////////////////////////////////////////
	
	public T saveOrUpdateLastId(T entity) {
		String id = null;
		Long idLast = null;
		Field fields[] = entity.getClass().getDeclaredFields();
	       for( Field field : fields ) {
	           Annotation annotations[] = field.getDeclaredAnnotations();
	           for( Annotation annotation : annotations ) {
	               if( annotation instanceof javax.persistence.Id ){
	                   id = field.getName();
	                   idLast = (Long) getCurrentSession().createQuery("select u."+id+" from " + clazz.getName()+ " u where ROWNUM = 1 order by u."+id+" DESC").uniqueResult();
	                   if(idLast == null){
		           			idLast = 1l;
		           		}else{
		           			idLast = idLast + 1;
		           		}
						try {
							if(entity.getClass().getDeclaredMethod("get" + id.substring(0, 1).toUpperCase() + id.substring(1)).invoke(entity) == null){
								Method met = entity.getClass().getDeclaredMethod("set" + id.substring(0, 1).toUpperCase() + id.substring(1) , Long.class);
								met.invoke(entity, idLast);
							}
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	               }
	           }	           
	       }
	       return entity;
	}
	
	public Serializable save(final T entity) 
	{
		return getCurrentSession().save(entity);
	}
	
	public T update(final T entity) 
	{
		getCurrentSession().update(entity);
		
		return entity;
	}
	
	public Long getSequenceNextVal(final String sequenceName)
		{
		    return 0L;
	    }
	public String encriptarCampo(final String valorCampo) 
	{
		final StringBuilder sb = new StringBuilder();
		this.getCurrentSession().doWork(new Work()
		{
			public void execute(Connection connection) throws SQLException 
			{
				CallableStatement call = connection.prepareCall("{ ? = call pkg_encripcion.encripta(?) }");
				call.registerOutParameter( 1, Types.NVARCHAR ); // or whatever it is
				call.setString(2, valorCampo);
				call.execute();
				sb.append(call.getString(1)); // propagate this back to enclosing class				
			}
		});
		
		return sb.toString();
    }

	public String desencriptarCampo(final String valorCampo) 
	{
		final StringBuilder sb = new StringBuilder();
		
		if (valorCampo != null && !valorCampo.toUpperCase().trim().equals("NULL")){	
			
			this.getCurrentSession().doWork(new Work()
			{
				public void execute(Connection connection) throws SQLException 
				{
					CallableStatement call = connection.prepareCall("{ ? = call pkg_encripcion.desencripta(?) }");
					call.registerOutParameter( 1, Types.NVARCHAR ); // or whatever it is
					call.setString(2, valorCampo);
					call.execute();
					sb.append(call.getString(1)); // propagate this back to enclosing class				
				}
			});
		
		}
		
		return sb.toString();
	}
}