package io.ecommerce.galery.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ecommerce.galery.dao.ProductDAOInt;
import io.ecommerce.galery.entity.ProductEntity;
import io.ecommerce.galery.exception.DuplicateRecordException;





@Service
public class ProductServiceImpl implements ProductServiceInt {
	
	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private ProductDAOInt dao;
	
	@Override
	@Transactional
	public long add(ProductEntity bean) throws DuplicateRecordException {
		log.info("ProductServiceImpl  add method start");
		ProductEntity existEntity = dao.findByName(bean.getName());
		if (existEntity != null) {
			throw new DuplicateRecordException("Product Name already Exist");
		}
		long pk = dao.add(bean);
		log.info("ProductServiceImpl add method end");
		return pk;
	}

	@Override
	@Transactional
	public void update(ProductEntity bean) throws DuplicateRecordException {
		log.info("ProductServiceImpl  update method start");
		ProductEntity existEntity = dao.findByName(bean.getName());
		if (existEntity != null && existEntity.getId() != bean.getId()) {
			throw new DuplicateRecordException("Product Name already Exist");
		}
		dao.update(bean);
		log.info("ProductServiceImpl update method end");
		
	}

	@Override
	@Transactional
	public void delete(ProductEntity bean) {
		log.info("ProductServiceImpl  delete method start");
		dao.delete(bean);
		log.info("ProductServiceImpl delete method end");
		
	}

	@Override
	@Transactional
	public ProductEntity findByName(String name) {
		log.info("ProductServiceImpl  findByLogin method start");
		ProductEntity bean = dao.findByName(name);
		log.info("ProductServiceImpl findByLogin method end");
		return bean;
	}

	

	@Override
	@Transactional
	public ProductEntity findByPk(long id) {
		log.info("ProductServiceImpl  findByPk method start");
		ProductEntity bean = dao.findByPk(id);
		log.info("ProductServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public List<ProductEntity> search(ProductEntity bean, long pageNo, int pageSize) {
		log.info("ProductServiceImpl  search method start");
		List<ProductEntity> list = dao.search(bean, pageNo, pageSize);
		log.info("ProductServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<ProductEntity> search(ProductEntity bean) {
		log.info("ProductServiceImpl  search method start");
		List<ProductEntity> list = dao.search(bean);
		log.info("ProductServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public Blob getImageById(long id) throws SerialException, SQLException {
		return dao.getImageById(id);
	}

}
