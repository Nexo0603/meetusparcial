package pe.edu.upc.meetusparcial.models.repository;

import java.util.List; 

import pe.edu.upc.meetusparcial.models.entities.Local;

public interface LocalRepository extends JpaRepository<Local, Integer> {
	
	List<Local> findByName(String name) throws Exception;

}
