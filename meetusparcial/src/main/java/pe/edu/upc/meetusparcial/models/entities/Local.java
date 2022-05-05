package pe.edu.upc.meetusparcial.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locals", indexes = {@Index(columnList = "l_name", name = "locals_index_l_name" )})
public class Local {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "l_name", length = 30, nullable = false)
	private String name;
	
	@Column(name = "l_district", length = 30, nullable = false)
	private String district;
	
	@Column(name = "l_description", length = 100, nullable = false)
	private String description;
	
	@Column(name = "l_cost", nullable = false)
	private float cost;
	
	@ManyToOne
	@JoinColumn(name = "localowner_id")
	private LocalOwner localowner;	//local_owner id

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public LocalOwner getLocalowner() {
		return localowner;
	}

	public void setLocalowner(LocalOwner localowner) {
		this.localowner = localowner;
	}
	
	
}
