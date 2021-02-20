package io.ecommerce.galery.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ecommerce.galery.dao.BookProductDAOInt;
import io.ecommerce.galery.entity.BookProductEntity;





@Service
public class BookProductServiceImpl implements BookProductServiceInt {

	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private BookProductDAOInt dao;
	
	@Override
	@Transactional
	public long add(BookProductEntity bean) {
		log.info("BookProductServiceImpl  add method start");
		long pk = dao.add(bean);
		log.info("BookProductServiceImpl add method end");
		return pk;
	}

	@Override
	@Transactional
	public void update(BookProductEntity bean) {
		log.info("BookProductServiceImpl  update method start");
		dao.update(bean);
		log.info("BookProductServiceImpl update method end");
		
	}

	@Override
	@Transactional
	public void delete(BookProductEntity bean) {
		log.info("BookProductServiceImpl  delete method start");
		dao.delete(bean);
		log.info("BookProductServiceImpl delete method end");
		
	}

	@Override
	@Transactional
	public BookProductEntity findByName(String name) {
		log.info("BookProductServiceImpl  findByLogin method start");
		BookProductEntity bean = dao.findByName(name);
		log.info("BookProductServiceImpl findByLogin method end");
		return bean;
	}

	

	@Override
	@Transactional
	public BookProductEntity findByPk(long id) {
		log.info("BookProductServiceImpl  findByPk method start");
		BookProductEntity bean = dao.findByPk(id);
		log.info("BookProductServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public List<BookProductEntity> search(BookProductEntity bean, long pageNo, int pageSize) {
		log.info("BookProductServiceImpl  search method start");
		List<BookProductEntity> list = dao.search(bean, pageNo, pageSize);
		log.info("BookProductServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<BookProductEntity> search(BookProductEntity bean) {
		log.info("BookProductServiceImpl  search method start");
		List<BookProductEntity> list = dao.search(bean);
		log.info("BookProductServiceImpl search method end");
		return list;
	}

	

}
