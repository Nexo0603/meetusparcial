package pe.edu.upc.meetusparcial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.meetusparcial.business.crud.LocalService;
import pe.edu.upc.meetusparcial.models.entities.Local;
import pe.edu.upc.meetusparcial.models.entities.LocalOwner;

import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("originalView")
@ViewScoped
public class OriginalView implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private List<Local> entities;
	private Local entitySelected;
	private List<Local> entitiesSelected;
	private Local entitySearch;
	
	@Inject
	private LocalService entityService;
	
	@PostConstruct
	public void init() {
		entitiesSelected = new ArrayList<>();
		entitySearch = new Local();
		getAllEntities();
	}
	
	public boolean hasEntitiesSelected() {
		if (entitiesSelected.isEmpty()) {
			return false;
		}
		return true;
	}
	public boolean hasEntitySelected() {
		if (entitiesSelected.size() == 1) {
			return true;
		}
		return false;
	}
	public void createNew() {
		entitySelected = new Local();
		entitySelected.setLocalowner(new LocalOwner());
	}
	public void editEntitySelected() {
		entitySelected = entitiesSelected.get(0);
	}
	public void saveEntity() {
		try {
			if (entitySelected.getId() == null) {
				entityService.create(entitySelected);
				entities.add(entitySelected);
			} 
			else {
				entityService.update(entitySelected);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('entityDialog').hide()");
        PrimeFaces.current().ajax().update("entityDataTable");
	}
	public void deleteEntity() {
		try {
			this.entities.remove(entitySelected);
			entityService.deleteById(this.entitySelected.getId());
			this.entitySelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		PrimeFaces.current().ajax().update("form:messages", "entityDataTable");
	}
	public void searchEntity() {
		try {	// MOdificar de acuerdo al Entity
			entities = entityService.search(entitySearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void getAllEntities() {
		try {
			entities = entityService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public List<Local> getEntities() {
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
