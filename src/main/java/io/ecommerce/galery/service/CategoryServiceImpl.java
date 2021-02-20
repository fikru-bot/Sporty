package io.ecommerce.galery.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ecommerce.galery.dao.CategoryDAOInt;
import io.ecommerce.galery.entity.CategoryEntity;
import io.ecommerce.galery.exception.DuplicateRecordException;



@Service
public class CategoryServiceImpl implements CategoryServiceInt {

	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private CategoryDAOInt dao;
	
	@Override
	@Transactional
	public long add(CategoryEntity bean) throws DuplicateRecordException {
		log.info("CategoryServiceImpl  add method start");
		CategoryEntity existEntity = dao.findByName(bean.getName());
		if (existEntity != null) {
			throw new DuplicateRecordException("Category is already Exist");
		}
		long pk = dao.add(bean);
		log.info("CategoryServiceImpl add method end");
		return pk;
	}
	
	@Override
	@Transactional
	public void update(CategoryEntity bean) throws DuplicateRecordException {
		log.info("CategoryServiceImpl  update method start");
		CategoryEntity existEntity = dao.findByName(bean.getName());
		if (existEntity != null && existEntity.getId() != bean.getId()) {
			throw new DuplicateRecordException("Category is already Exist");
		}
		dao.update(bean);
		log.info("CategoryServiceImpl update method end");

	}

	@Override
	@Transactional
	public void delete(CategoryEntity bean) {
		log.info("CategoryServiceImpl  delete method start");
		dao.delete(bean);
		log.info("CategoryServiceImpl delete method end");
	}

	@Override
	@Transactional
	public CategoryEntity findByName(String name) {
		log.info("CategoryServiceImpl  findByLogin method start");
		CategoryEntity bean = dao.findByName(name);
		log.info("CategoryServiceImpl findByLogin method end");
		return bean;
	}

	@Override
	@Transactional
	public CategoryEntity findByPk(long id) {
		log.info("CategoryServiceImpl  findByPk method start");
		CategoryEntity bean = dao.findByPk(id);
		log.info("CategoryServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public List<CategoryEntity> search(CategoryEntity bean, long pageNo, int pageSize) {
		log.info("CategoryServiceImpl  search method start");
		List<CategoryEntity> list = dao.search(bean, pageNo, pageSize);
		log.info("CategoryServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<CategoryEntity> search(CategoryEntity bean) {
		log.info("CategoryServiceImpl  search method start");
		List<CategoryEntity> list = dao.search(bean);
		log.info("CategoryServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public Blob getImageById(long id) throws SerialException, SQLException {
		log.info("CategoryServiceImpl  getImageById method start");
		log.info("CategoryServiceImpl  getImageById method end");
		return dao.getImageById(id);
	}

	

}
