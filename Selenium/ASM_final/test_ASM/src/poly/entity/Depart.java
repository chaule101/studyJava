package poly.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departs")
public class Depart {
	@Id
	public String id;
	public String name;
	
	@OneToMany(mappedBy="depart", fetch=FetchType.EAGER)
	private Collection<Staff> staffs;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(Collection<Staff> staffs) {
		this.staffs = staffs;
	}
	public Depart(String id, String name, Collection<Staff> staffs) {
		super();
		this.id = id;
		this.name = name;
		this.staffs = staffs;
	}
	public Depart() {
		super();
	}
	
	

}
