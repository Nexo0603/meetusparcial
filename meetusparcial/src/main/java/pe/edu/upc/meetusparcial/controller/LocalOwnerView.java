package pe.edu.upc.meetusparcial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.meetusparcial.business.crud.CrudService;
import pe.edu.upc.meetusparcial.business.crud.LocalOwnerService;
import pe.edu.upc.meetusparcial.models.entities.LocalOwner;

@Named("localOwnerView")
@ViewScoped
public class LocalOwnerView implements Serializable, EntityView<LocalOwner, Integer> {
	
	private static final long serialVersionUID = 1L;
	
	private List<LocalOwner> entities;
	private LocalOwner entitySelected;
	private List<LocalOwner> entitiesSelected;
	private LocalOwner entitySearch;
	
	@Inject
	private LocalOwnerService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new LocalOwner();
		getAllEntities();
	}
	
	@Override
	public CrudService<LocalOwner, Integer> getCrudService() {
		return this.entityService;
	}
	
	@Override
	public void createNew() {
		this.entitySelected = new LocalOwner();		
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
	
	public List<LocalOwner> getEntities() {
		return entities;
	}

	public void setEntities(List<LocalOwner> entities) {
		this.entities = entities;
	}

	public LocalOwner getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(LocalOwner entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<LocalOwner> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<LocalOwner> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public LocalOwner getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(LocalOwner entitySearch) {
		this.entitySearch = entitySearch;
	}

	public LocalOwnerService getEntityService() {
		return entityService;
	}

	public void setEntityService(LocalOwnerService entityService) {
		this.entityService = entityService;
	}
}
