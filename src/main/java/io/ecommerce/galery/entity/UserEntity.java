package io.ecommerce.galery.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity extends BaseEntity{
	
	@Column(name="FIRST_NAME" ,length = 225)
	private String firstName;
	
	@Column(name="LAST_NAME" ,length = 225)
	private String lastName;
	
	@Column(name="LOGIN" ,length = 225)
	private String loginId;
	
	@Column(name="PASSWORD" ,length = 225)
	private String password;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="MOBILE_NO" ,length = 225)
	private String mobileNo;
	
	@Column(name="gender" ,length = 225)
	private String gender;
	
	@Column(name="ROLE_ID")
	private long roleId;
	
	
	
	
	public UserEntity() {
	
	}

	
	
	
	public Date getDob() {
		return dob;
	}




	public void setDob(Date dob) {
		this.dob = dob;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}


	@Override
	public String toString() {
		return "UserEntity [firstName=" + firstName + ", lastName=" + lastName + ", loginId=" + loginId + ", password="
				+ password + ", dob=" + dob + ", mobileNo=" + mobileNo + ", gender=" + gender + ", roleId=" + roleId
				+ "]";
	}

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return firstName+" "+lastName;
	}

}
