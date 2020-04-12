package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.persistencia.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jorge Luis
 *
 */
public class FavoritosVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7088010887859302756L;

	public List<Long> favoriteCollection;

	/**
	 * @return the favoriteCollection
	 */
	public List<Long> getFavoriteCollection() {
		return favoriteCollection;
	}

	/**
	 * @param favoriteCollection the favoriteCollection to set
	 */
	public void setFavoriteCollection(List<Long> favoriteCollection) {
		this.favoriteCollection = favoriteCollection;
	}

}
