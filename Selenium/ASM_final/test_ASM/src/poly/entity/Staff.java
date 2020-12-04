package poly.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "Staffs")
public class Staff {
	@Id
	@Column(name = "Id")
	@NotBlank(message="Không được để trống ID")
	private String id;
	
	@NotBlank(message="Không được để trống Name")
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Gender")
	private boolean gender;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")	
	@Column(name = "Birthday")
	private Date birthday;
	
	@NotBlank(message="Không được để trống Hình ảnh")
	@Column(name = "Photo")
	private String photo;
	
	@NotBlank(message="Không được để trống Email")
	@Column(name = "Email")
	private String email;
	
	@NotBlank(message="Không được để trống Số Điện Thoại")
	@Column(name = "Phone")
	private String phone;
	
//	@Min(value=1000000,message="too low")
	@NotBlank(message="Không được để trống lương")
	@Pattern(regexp="\\d+",message="Chi Duoc Nhap So")
	@Column(name = "Salary")
	private String salary;
	
//	@Column(name = "Salary")
//	private Double salary;
	
	@Column(name = "Notes")
	private String notes;
	@ManyToOne
	@JoinColumn(name = "DepartId")
	private Depart depart;
	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	private Collection<Record> record;
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
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Depart getDepart() {
		return depart;
	}
	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	public Collection<Record> getRecord() {
		return record;
	}
	public void setRecord(Collection<Record> record) {
		this.record = record;
	}
	
	
	
	
	
}
