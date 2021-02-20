package io.ecommerce.galery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class CartEntity extends BaseEntity{

	@Column(name="USER_ID")
	private long userId;
	@Column(name="PRODUCT_ID")
	private long productId;
	@Column(name="PRODUCT_NAME", length = 225)
	private String productName;
	@Column(name="PRICE", length = 225)
	private String price;
	@Column(name="DESCRIPTION", length = 225)
	private String description;
	
	@Column(name="QUANTITY", length = 225)
	private String quantity;
	@Column(name="SIZE", length = 225)
	private String size;
	
	
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public CartEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "CartEntity [userId=" + userId + ", productId=" + productId + ", productName=" + productName + ", price="
				+ price + ", description=" + description + ", id=" + id + ", createdBy=" + createdBy + ", modifiedBy="
				+ modifiedBy + ", createdDateTime=" + createdDateTime + ", modifiedDateTime=" + modifiedDateTime + "]";
	}



	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
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
