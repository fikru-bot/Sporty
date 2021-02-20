package io.ecommerce.galery.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ecommerce.galery.dao.UserDAOInt;
import io.ecommerce.galery.entity.UserEntity;
import io.ecommerce.galery.exception.DuplicateRecordException;





@Service
public class UserServiceImpl implements UserServiceInt {

	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private UserDAOInt dao;

	@Override
	@Transactional
	public long add(UserEntity bean) throws DuplicateRecordException {
		log.info("UserServiceImpl  add method start");
		UserEntity existEntity = dao.findByLogin(bean.getLoginId());
		if (existEntity != null) {
			throw new DuplicateRecordException("Login  id already Exist");
		}
		long pk = dao.add(bean);
		log.info("UserServiceImpl add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(UserEntity bean) {
		log.info("UserServiceImpl  delete method start");
		dao.delete(bean);
		log.info("UserServiceImpl delete method end");
	}

	@Override
	@Transactional
	public void update(UserEntity bean) throws DuplicateRecordException {
		log.info("UserServiceImpl  update method start");
		UserEntity existEntity = dao.findByLogin(bean.getLoginId());
		if (existEntity != null && existEntity.getId() != bean.getId()) {
			throw new DuplicateRecordException("Login  id already Exist");
		}
		dao.update(bean);
		log.info("UserServiceImpl update method end");

	}

	@Override
	@Transactional
	public UserEntity findByPK(long pk) {
		log.info("UserServiceImpl  findByPk method start");
		UserEntity bean = dao.findByPk(pk);
		log.info("UserServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public UserEntity findByLogin(String login) {
		log.info("UserServiceImpl  findByLogin method start");
		UserEntity bean = dao.findByLogin(login);
		log.info("UserServiceImpl findByLogin method end");
		return bean;
	}

	@Override
	@Transactional
	public List<UserEntity> search(UserEntity bean) {
		log.info("UserServiceImpl  search method start");
		List<UserEntity> list = dao.search(bean);
		log.info("UserServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserEntity> search(UserEntity bean, int pageNo, int pageSize) {
		log.info("UserServiceImpl  search method start");
		List<UserEntity> list = dao.search(bean, pageNo, pageSize);
		log.info("UserServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public boolean changePassword(Long id, String oldPassword, String newPassword) {
		log.info("UserServiceImpl  changePassword method start");
		UserEntity dtoExist = findByPK(id);
		if (dtoExist != null && dtoExist.getPassword().equals(oldPassword)) {
			dao.update(dtoExist);
			log.info("UserServiceImpl  changePassword method end");
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public UserEntity authenticate(UserEntity bean) {
		log.info("UserServiceImpl  authenticate method start");
		UserEntity uBean = dao.authenticate(bean);
		log.info("UserServiceImpl 	authenticate method end");
		return uBean;
	}

	@Override
	@Transactional
	public long registerUser(UserEntity bean) throws DuplicateRecordException {
		log.info("UserServiceImpl  registerUser method start");
		long pk = add(bean);
		log.info("UserServiceImpl  registeruser method end");
		return pk;
	}

	@Override
	@Transactional
	public boolean forgetPassword(String login) {
		log.info("UserServiceImpl  forgetPassword method start");
		log.info("UserServiceImpl  forgetPassword method end");
		return false;
	}

}
