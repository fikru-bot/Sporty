package io.ecommerce.galery.dao;

import java.util.List;

import io.ecommerce.galery.entity.BookProductEntity;




public interface BookProductDAOInt {

public long add(BookProductEntity bean);
	
	public void update(BookProductEntity bean);
	
	public void delete(BookProductEntity bean);
	
	public BookProductEntity findByName(String name);
	
	public BookProductEntity findByPk(long id);
	
	public List<BookProductEntity> search(BookProductEntity bean, long pageNo, int pageSize);
	
	public List<BookProductEntity> search(BookProductEntity bean);
	
	
}
