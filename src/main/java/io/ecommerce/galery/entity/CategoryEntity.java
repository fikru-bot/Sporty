package io.ecommerce.galery.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class CategoryEntity extends BaseEntity {

	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Lob
    @Column(name = "IMAGE", columnDefinition="BLOB")
	private byte[] image;
	
	
	public CategoryEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "CategoryEntity [name=" + name + ", description=" + description + ", image=" + Arrays.toString(image)
				+ ", id=" + id + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDateTime="
				+ createdDateTime + ", modifiedDateTime=" + modifiedDateTime + "]";
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
		// TODO Auto-generated method stub
		return name;
	}

}
