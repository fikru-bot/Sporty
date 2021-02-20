package io.ecommerce.galery.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ecommerce.galery.dao.CartDAOInt;
import io.ecommerce.galery.entity.CartEntity;
import io.ecommerce.galery.exception.DuplicateRecordException;



@Service
public class CartServiceImpl implements CartServiceInt {

	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private CartDAOInt dao;
	
	@Override
	@Transactional
	public long add(CartEntity bean) throws DuplicateRecordException {
		log.info("CartServiceImpl  add method start");
		/*
		 * CartEntity existEntity = dao.findByName(bean.getName()); if (existEntity !=
		 * null) { throw new DuplicateRecordException("Cart is already Exist"); }
		 */
		long pk = dao.add(bean);
		log.info("CartServiceImpl add method end");
		return pk;
	}
	
	@Override
	@Transactional
	public void update(CartEntity bean) throws DuplicateRecordException {
		log.info("CartServiceImpl  update method start");
		/*
		 * CartEntity existEntity = dao.findByName(bean.getName()); if (existEntity !=
		 * null && existEntity.getId() != bean.getId()) { throw new
		 * DuplicateRecordException("Cart is already Exist"); }
		 */
		dao.update(bean);
		log.info("CartServiceImpl update method end");

	}

	@Override
	@Transactional
	public void delete(CartEntity bean) {
		log.info("CartServiceImpl  delete method start");
		dao.delete(bean);
		log.info("CartServiceImpl delete method end");
	}

	@Override
	@Transactional
	public CartEntity findByName(String name) {
		log.info("CartServiceImpl  findByLogin method start");
		CartEntity bean = dao.findByName(name);
		log.info("CartServiceImpl findByLogin method end");
		return bean;
	}

	@Override
	@Transactional
	public CartEntity findByPk(long id) {
		log.info("CartServiceImpl  findByPk method start");
		CartEntity bean = dao.findByPk(id);
		log.info("CartServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public List<CartEntity> search(CartEntity bean, long pageNo, int pageSize) {
		log.info("CartServiceImpl  search method start");
		List<CartEntity> list = dao.search(bean, pageNo, pageSize);
		log.info("CartServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<CartEntity> search(CartEntity bean) {
		log.info("CartServiceImpl  search method start");
		List<CartEntity> list = dao.search(bean);
		log.info("CartServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public CartEntity findByProductAndUser(long prodId, long uId) {
		// TODO Auto-generated method stub
		return dao.findByProductAndUser(prodId, uId);
	}
	
}
