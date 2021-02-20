package io.ecommerce.galery.service;

import java.util.List;

import io.ecommerce.galery.entity.CartEntity;
import io.ecommerce.galery.exception.DuplicateRecordException;



public interface CartServiceInt {

	public long add(CartEntity bean) throws DuplicateRecordException;
	
	public void update(CartEntity bean) throws DuplicateRecordException;
	
	public void delete(CartEntity bean);
	
	public CartEntity findByName(String name);
	
	public CartEntity findByPk(long id);
	
	public CartEntity findByProductAndUser(long prodId,long uId);
	
	public List<CartEntity> search(CartEntity bean, long pageNo, int pageSize);
	
	public List<CartEntity> search(CartEntity bean);
	
}
