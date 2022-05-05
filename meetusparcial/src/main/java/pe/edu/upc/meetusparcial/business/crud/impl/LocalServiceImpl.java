package pe.edu.upc.meetusparcial.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.meetusparcial.business.crud.LocalService;
import pe.edu.upc.meetusparcial.models.entities.Local;
import pe.edu.upc.meetusparcial.models.repository.LocalRepository;
import pe.edu.upc.meetusparcial.models.repository.JpaRepository;

@Named
@ApplicationScoped
public class LocalServiceImpl implements LocalService {
	
	@Inject
	private LocalRepository localRepository;
	
	@Override
	public JpaRepository<Local, Integer> getJpaRepository() {
		return this.localRepository;
	}
	
	@Override
	public List<Local> findByName(String name) throws Exception {
		return this.localRepository.findByName(name);
	}

}
