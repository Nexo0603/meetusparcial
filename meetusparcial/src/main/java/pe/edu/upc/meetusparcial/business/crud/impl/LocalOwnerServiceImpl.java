package pe.edu.upc.meetusparcial.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.meetusparcial.business.crud.LocalOwnerService;
import pe.edu.upc.meetusparcial.models.entities.LocalOwner;
import pe.edu.upc.meetusparcial.models.repository.LocalOwnerRepository;
import pe.edu.upc.meetusparcial.models.repository.JpaRepository;

@Named
@ApplicationScoped
public class LocalOwnerServiceImpl implements LocalOwnerService {
	
	@Inject
	private LocalOwnerRepository localownerRepository;
	
	@Override
	public JpaRepository<LocalOwner, Integer> getJpaRepository() {
		return this.localownerRepository;
	}
}
