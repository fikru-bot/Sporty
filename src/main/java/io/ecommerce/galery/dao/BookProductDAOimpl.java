package io.ecommerce.galery.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.ecommerce.galery.entity.BookProductEntity;




@Repository
public class BookProductDAOimpl implements BookProductDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public long add(BookProductEntity bean) {
		log.info("BookProductDAOImpl  add method start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(bean);
		log.info("BookProductDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(BookProductEntity bean) {
		log.info("BookProductDAOImpl  update method start");
		sessionFactory.getCurrentSession().merge(bean);
		log.info("BookProductDAOImpl  update method end");
	}

	@Override
	public void delete(BookProductEntity bean) {
		log.info("BookProductDAOImpl  delete method start");
		sessionFactory.getCurrentSession().delete(bean);
		log.info("BookProductDAOImpl  delete method end");
	}

	@Override
	public BookProductEntity findByName(String name) {
		log.info("BookProductDAOImpl  login method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(BookProductEntity.class);
		criteria.add(Restrictions.eq("name", name));
		log.info("BookProductDAOImpl  login method end");
		return (BookProductEntity) criteria.uniqueResult();
	}
	
	@Override
	public BookProductEntity findByPk(long id) {
		log.info("BookProductDAOImpl  findPk method start");
		Session session = sessionFactory.getCurrentSession();
		log.info("BookProductDAOImpl  findPK method end");
		return session.get(BookProductEntity.class, id);
	}

	@Override
	public List<BookProductEntity> search(BookProductEntity bean, long pageNo, int pageSize) {
		log.info("BookProductDAOImpl  search method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(BookProductEntity.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getUserId() > 0) {
				criteria.add(Restrictions.eq("userId", bean.getUserId()));
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				criteria.add(Restrictions.like("name", bean.getName() + "%"));
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("BookProductDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<BookProductEntity> search(BookProductEntity bean) {
		log.info("BookProductDAOImpl  search method start");

		log.info("BookProductDAOImpl search method end");
		return search(bean, 0, 0);
	}


}
