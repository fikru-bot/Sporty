package io.ecommerce.galery.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKED_PRODUCT")
public class BookProductEntity extends BaseEntity {

	@Column(name = "PRODUCT_ID")
	private long productId;
	
	@Column(name = "PRODUCT_NAME", length = 225)
	private String productName;
	
	@Column(name = "NAME", length = 225)
	private String name;
	
	@Column(name = "EMAIL_ID", length = 225)
	private String emailId;
	
	@Column(name = "MOBILE_NO", length = 225)
	private String mobileNo;
	
	@Column(name = "COUNTRY", length = 225)
	private String country;

	@Column(name = "STATE", length = 225)
	private String state;

	@Column(name = "DISTRICT", length = 225)
	private String district;
	
	@Column(name = "PINCODE", length = 225)
	private String pincode;
	
	@Column(name = "ADDRESS", length = 225)
	private String address;
	
	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "QUANTITY", length = 225)
	private String quantity;
	
	@Column(name = "AMOUNT", length = 225)
	private String anmount;
	
	@Column(name = "DATE", columnDefinition = "DATE")
	private Date date;

	@Column(name="PRODUCT_SIZE",length = 225)
	private String pSize;
	
	public BookProductEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "BookProductEntity [productId=" + productId + ", productName=" + productName + ", name=" + name
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", country=" + country + ", state=" + state
				+ ", district=" + district + ", pincode=" + pincode + ", address=" + address + ", userId=" + userId
				+ ", quantity=" + quantity + ", anmount=" + anmount + ", date=" + date + ", pSize=" + pSize + ", id="
				+ id + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDateTime="
				+ createdDateTime + ", modifiedDateTime=" + modifiedDateTime + "]";
	}

	

	
	

	public String getpSize() {
		return pSize;
	}



	public void setpSize(String pSize) {
		this.pSize = pSize;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAnmount() {
		return anmount;
	}

	public void setAnmount(String anmount) {
		this.anmount = anmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
