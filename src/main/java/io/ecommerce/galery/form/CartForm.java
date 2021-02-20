package io.ecommerce.galery.form;

import io.ecommerce.galery.entity.BaseEntity;
import io.ecommerce.galery.entity.CartEntity;

public class CartForm extends BaseForm {

	private long userId;
	private long productId;
	private String productName;
	private String quantity;
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

	@Override
	public BaseEntity getBean() {
		CartEntity bean=new CartEntity();
		bean.setId(productId);
		bean.setUserId(userId);
		bean.setProductId(productId);
		bean.setProductName(productName);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDateTime(createdDateTime);
		bean.setModifiedDateTime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseEntity baseBean) {
		CartEntity bean=(CartEntity)baseBean;
		id=bean.getId();
		userId=bean.getUserId();
		productId=bean.getProductId();
		productName=bean.getProductName();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDateTime();
		modifiedDateTime=bean.getModifiedDateTime();
	}

	
}
