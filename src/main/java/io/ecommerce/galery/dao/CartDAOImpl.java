package io.ecommerce.galery.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.ecommerce.galery.entity.CartEntity;


@Repository
public class CartDAOImpl implements CartDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public long add(CartEntity bean) {
		log.info("CartDAOImpl  add method start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(bean);
		log.info("CartDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(CartEntity bean) {
		log.info("CartDAOImpl  update method start");
		sessionFactory.getCurrentSession().merge(bean);
		log.info("CartDAOImpl  update method end");
	}

	@Override
	public void delete(CartEntity bean) {
		log.info("CartDAOImpl  delete method start");
		sessionFactory.getCurrentSession().delete(bean);
		log.info("CartDAOImpl  delete method end");
	}

	@Override
	public CartEntity findByName(String name) {
		log.info("CartDAOImpl  login method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CartEntity.class);
		criteria.add(Restrictions.eq("name", name));
		log.info("CartDAOImpl  login method end");
		return (CartEntity) criteria.uniqueResult();
	}

	@Override
	public CartEntity findByPk(long id) {
		log.info("CartDAOImpl  findPk method start");
		Session session = sessionFactory.getCurrentSession();
		log.info("CartDAOImpl  findPK method end");
		return session.get(CartEntity.class, id);
	}

	@Override
	public List<CartEntity> search(CartEntity bean, long pageNo, int pageSize) {
		log.info("CartDAOImpl  search method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CartEntity.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getUserId() > 0) {
				criteria.add(Restrictions.eq("userId", bean.getUserId()));
			}
			if (bean.getProductName() != null && bean.getProductName().length() > 0) {
				criteria.add(Restrictions.like("productName", bean.getProductName() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("CartDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<CartEntity> search(CartEntity bean) {
		log.info("CartDAOImpl  search method start");

		log.info("CartDAOImpl search method end");
		return search(bean, 0, 0);
	}

	@Override
	public CartEntity findByProductAndUser(long prodId, long uId) {
		log.info("CartDAOImpl  login method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CartEntity.class);
		criteria.add(Restrictions.eq("productId", prodId));
		criteria.add(Restrictions.eq("userId", uId));
		log.info("CartDAOImpl  login method end");
		return (CartEntity) criteria.uniqueResult();
	}

}
