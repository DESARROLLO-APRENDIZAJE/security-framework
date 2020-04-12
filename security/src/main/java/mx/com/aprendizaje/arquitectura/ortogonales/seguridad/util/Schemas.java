package mx.com.aprendizaje.arquitectura.ortogonales.seguridad.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Schemas {
	@Value("${mybatis.configuration.variables.schemaX}")
    public String schemaX;

	public String getSchemaX() {
		return schemaX;
	}

	public void setSchemaX(String schemaX) {
		this.schemaX = schemaX;
	}
	
	
}
