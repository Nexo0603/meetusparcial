package pe.edu.upc.meetusparcial.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "localowner", indexes = {@Index(columnList = "lo_lastname, lo_name", name = "localowner_index_lo_lastname_lo_name" )},
		uniqueConstraints = {@UniqueConstraint(columnNames = {"lo_email"})})
public class LocalOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "lo_name", length = 30, nullable = false)
	private String name;
	
	@Column(name = "lo_lastname", length = 30, nullable = false)
	private String lastName;
	
	@Column(name = "lo_phone", length = 9, nullable = false)
	private String phone;
	
	@Column(name = "lo_dni", length = 8, nullable = false)
	private String dni;
	
	@Column(name = "lo_address", length = 30, nullable = false)
	private String address;
	
	@Column(name = "lo_email", length = 30, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "localowner")
	private List<Local> locals;
	
	public LocalOwner() {
		locals = new ArrayList<Local>();
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Local> getLocals() {
		return locals;
	}

	public void setLocals(List<Local> locals) {
		this.locals = locals;
	}
	
}
