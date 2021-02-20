package io.ecommerce.galery.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import io.ecommerce.galery.entity.CategoryEntity;



public interface CategoryDAOInt {

	public long add(CategoryEntity bean);
	
	public void update(CategoryEntity bean);
	
	public void delete(CategoryEntity bean);
	
	public CategoryEntity findByName(String name);
	
	public CategoryEntity findByPk(long id);
	
	public List<CategoryEntity> search(CategoryEntity bean, long pageNo, int pageSize);
	
	public List<CategoryEntity> search(CategoryEntity bean);
	
	public Blob getImageById(long id) throws SerialException, SQLException;
	
}
