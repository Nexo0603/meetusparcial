package pe.edu.upc.meetusparcial.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.meetusparcial.business.crud.CrudService;
import pe.edu.upc.meetusparcial.business.crud.LocalService;
import pe.edu.upc.meetusparcial.models.entities.Local;
import pe.edu.upc.meetusparcial.models.entities.LocalOwner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("localView")
@ViewScoped
public class LocalView implements Serializable, EntityView<Local, Integer> {
	
	private static final long serialVersionUID = 1L;
	
	private List<Local> entities;
	private Local entitySelected;
	private List<Local> entitiesSelected;
	private Local entitySearch;
	
	@Inject
	private LocalService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Local();
		getAllEntities();
	}
	
	@Override
	public CrudService<Local, Integer> getCrudService() {
		return this.entityService;
	}
	
	@Override
	public void createNew() {
		this.entitySelected = new Local();		
		this.entitySelected.setLocalowner(new LocalOwner());
	}
	
	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getId();
	}

	@Override
	public void searchEntity() {
		try {	// Modificar de acuerdo al atributo a buscar
			this.entities = this.entityService.search(this.entitySearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	@Override
	public List<Local> getEntities() {
		// TODO Auto-generated method stub
		return entities;
	}

	public void setEntities(List<Local> entities) {
		this.entities = entities;
	}

	public Local getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Local entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Local> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Local> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Local getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Local entitySearch) {
		this.entitySearch = entitySearch;
	}

	public LocalService getEntityService() {
		return entityService;
	}

	public void setEntityService(LocalService entityService) {
		this.entityService = entityService;
	}
	
		
	
}
