package io.ecommerce.galery.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.ecommerce.galery.entity.UserEntity;




@Repository
public class UserDAOimpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(getClass().getName());

	@Override
	public long add(UserEntity bean) {
		log.info("UserDAOImpl  add method start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(bean);
		log.info("UserDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(UserEntity bean) {
		log.info("UserDAOImpl  update method start");
		sessionFactory.getCurrentSession().merge(bean);
		log.info("UserDAOImpl  update method end");
	}

	@Override
	public void delete(UserEntity bean) {
		log.info("UserDAOImpl  delete method start");
		sessionFactory.getCurrentSession().delete(bean);
		log.info("UserDAOImpl  delete method end");
	}

	@Override
	public UserEntity findByLogin(String login) {
		log.info("UserDAOImpl  login method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("loginId", login));
		log.info("UserDAOImpl  login method end");
		return (UserEntity) criteria.uniqueResult();
	}

	@Override
	public UserEntity findByPk(long id) {
		log.info("UserDAOImpl  findPk method start");
		Session session = sessionFactory.getCurrentSession();
		log.info("UserDAOImpl  findPK method end");
		return session.get(UserEntity.class, id);
	}

	@Override
	public List<UserEntity> search(UserEntity bean, long pageNo, int pageSize) {
		log.info("UserDAOImpl  search method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserEntity.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", bean.getFirstName() + "%"));
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", bean.getLastName() + "%"));
			}
			if (bean.getLoginId() != null && bean.getLoginId().length() > 0) {
				criteria.add(Restrictions.like("loginId", bean.getLoginId() + "%"));
			}
			
			if (bean.getRoleId() > 0) {
				criteria.add(Restrictions.eq("roleId", bean.getRoleId()));
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("UserDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<UserEntity> search(UserEntity bean) {
		log.info("UserDAOImpl  search method start");

		log.info("UserDAOImpl search method end");
		return search(bean, 0, 0);
	}

	@Override
	public UserEntity authenticate(UserEntity bean) {
		log.info("UserDAOImpl  Authenticate method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.like("loginId", bean.getLoginId()));
		criteria.add(Restrictions.like("password", bean.getPassword()));
		log.info("UserDAOImpl  Authenticate method end");
		return (UserEntity)criteria.uniqueResult();
	}

}
