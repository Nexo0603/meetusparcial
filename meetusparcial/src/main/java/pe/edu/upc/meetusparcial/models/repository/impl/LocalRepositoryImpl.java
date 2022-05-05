package pe.edu.upc.meetusparcial.models.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.meetusparcial.models.entities.Local;
import pe.edu.upc.meetusparcial.models.repository.LocalRepository;

@Named
@ApplicationScoped
public class LocalRepositoryImpl implements LocalRepository {
	
	@PersistenceContext(unitName = "meetusparcialPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@Override
	public Optional<Local> findById(Integer id) throws Exception {
		return this.findById(id, Local.class);
	}
	
	@Override
	public List<Local> findAll() throws Exception {
		String jpql = "SELECT local FROM Local local";
		return this.findByQuery(Local.class, jpql);
	}
	
	@Override
	public List<Local> findByName(String name) throws Exception {
		String jpql = "SELECT local FROM Local local WHERE local.name = '" + name + "'";
		return this.findByQuery(Local.class, jpql);
	}
	
	@Override
	public List<Local> findByData(String data) throws Exception {
		String jpql = "SELECT local FROM Local local WHERE local.name LIKE '" + data + "'";
		return this.findByQuery(Local.class, jpql);
	}
}
