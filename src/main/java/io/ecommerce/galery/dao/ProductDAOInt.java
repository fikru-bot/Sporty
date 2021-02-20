package io.ecommerce.galery.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import io.ecommerce.galery.entity.ProductEntity;




public interface ProductDAOInt {

	public long add(ProductEntity bean);
	
	public void update(ProductEntity bean);
	
	public void delete(ProductEntity bean);
	
	public ProductEntity findByName(String name);
	
	
	public ProductEntity findByPk(long id);
	
	public List<ProductEntity> search(ProductEntity bean, long pageNo, int pageSize);
	
	public List<ProductEntity> search(ProductEntity bean);
	
	public Blob getImageById(long id) throws SerialException, SQLException;
	
}
