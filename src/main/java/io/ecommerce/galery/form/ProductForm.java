package io.ecommerce.galery.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import io.ecommerce.galery.entity.BaseEntity;
import io.ecommerce.galery.entity.ProductEntity;





public class ProductForm extends BaseForm {

	@NotEmpty(message="Name is required")
	private String name;

	@NotEmpty(message="Price is required")
	private String price;
	
	@NotEmpty(message="Description is required")
	private String description;
	
	@Min(value = 1, message = "Category Name required")
	private long categoryId;
	
	private MultipartFile image;
	
	
	
	
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public BaseEntity getBean() {
		ProductEntity bean=new ProductEntity();
		bean.setId(id);
		bean.setCategoryId(categoryId);
		bean.setName(name);
		bean.setPrice(price);
		bean.setDescription(description);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDateTime(createdDateTime);
		bean.setModifiedDateTime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseEntity baseBean) {
		ProductEntity bean=(ProductEntity)baseBean;
		id=bean.getId();
		categoryId=bean.getCategoryId();
		name=bean.getName();
		price=bean.getPrice();
		description=bean.getDescription();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDateTime();
		modifiedDateTime=bean.getModifiedDateTime();
	}

}
