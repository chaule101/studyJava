package poly.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;





@Entity
@Table(name="Users")

public class User {
	@Id
	@NotBlank(message="Không để trống tên đăng nhập")
	public String username;
	@NotBlank(message="Không được để trong password")
	@Size(min=6,message="Password ít nhất 6 kí tự")
	public String password;
	@NotBlank(message="Không được để trong FullName")
	public String fullname;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public User(String username, String password, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}
	public User() {
		super();
	}
	
	
	
}
