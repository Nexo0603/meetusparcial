package pe.edu.upc.meetusparcial.business.crud;

import java.util.List;

import pe.edu.upc.meetusparcial.models.entities.Local;

public interface LocalService extends CrudService<Local, Integer>{
	List<Local> findByName(String name) throws Exception;
}
