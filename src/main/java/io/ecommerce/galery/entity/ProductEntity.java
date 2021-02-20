package io.ecommerce.galery.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="PRODUCT")
public class ProductEntity extends  BaseEntity {
	
	@Column(name="CATEGORY_ID")
	private long categoryId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRICE")
	private String price;
	
	@Lob
    @Column(name = "IMAGE", columnDefinition="MEDIUMBLOB")
	private byte[] image;
	
	public ProductEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ProductEntity [categoryId=" + categoryId + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", image=" + Arrays.toString(image) + ", id=" + id + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", createdDateTime=" + createdDateTime + ", modifiedDateTime="
				+ modifiedDateTime + "]";
	}



	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}
	@Override
	public String getValue() {
		return name;
	}
	

}
