package pe.edu.upc.meetusparcial.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.meetusparcial.models.entities.LocalOwner;
import pe.edu.upc.meetusparcial.models.repository.LocalOwnerRepository;

@Named
@ApplicationScoped
public class LocalOwnerRepositoryImpl implements LocalOwnerRepository{

	@PersistenceContext(unitName = "meetusparcialPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@Override
	public Optional<LocalOwner> findById(Integer id) throws Exception {
		return this.findById(id, LocalOwner.class);
	}
	
	@Override
	public List<LocalOwner> findAll() throws Exception {
		String jpql = "SELECT localowner FROM LocalOwner localowner";
		return this.findByQuery(LocalOwner.class, jpql);
	}
	
	@Override
	public List<LocalOwner> findByData(String data) throws Exception {
		String jpql = "SELECT localowner FROM LocalOwner localowner WHERE localowner.name LIKE '" + data + "'";
		return this.findByQuery(LocalOwner.class, jpql);
	}
}
