package io.ecommerce.galery.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.ecommerce.galery.entity.CategoryEntity;



@Repository
public class CategoryDAOImpl implements CategoryDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public long add(CategoryEntity bean) {
		log.info("CategoryDAOImpl  add method start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(bean);
		log.info("CategoryDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(CategoryEntity bean) {
		log.info("CategoryDAOImpl  update method start");
		sessionFactory.getCurrentSession().merge(bean);
		log.info("CategoryDAOImpl  update method end");
	}

	@Override
	public void delete(CategoryEntity bean) {
		log.info("CategoryDAOImpl  delete method start");
		sessionFactory.getCurrentSession().delete(bean);
		log.info("CategoryDAOImpl  delete method end");
	}

	@Override
	public CategoryEntity findByName(String name) {
		log.info("CategoryDAOImpl  login method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CategoryEntity.class);
		criteria.add(Restrictions.eq("name", name));
		log.info("CategoryDAOImpl  login method end");
		return (CategoryEntity) criteria.uniqueResult();
	}

	@Override
	public CategoryEntity findByPk(long id) {
		log.info("CategoryDAOImpl  findPk method start");
		Session session = sessionFactory.getCurrentSession();
		log.info("CategoryDAOImpl  findPK method end");
		return session.get(CategoryEntity.class, id);
	}

	@Override
	public List<CategoryEntity> search(CategoryEntity bean, long pageNo, int pageSize) {
		log.info("CategoryDAOImpl  search method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CategoryEntity.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
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
		log.info("CategoryDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<CategoryEntity> search(CategoryEntity bean) {
		log.info("CategoryDAOImpl  search method start");

		log.info("CategoryDAOImpl search method end");
		return search(bean, 0, 0);
	}

	@Override
	public Blob getImageById(long id) throws SerialException, SQLException {
		log.info("CategoryDAOImpl getImageById  method start");
		Session session=sessionFactory.getCurrentSession();
		CategoryEntity person = (CategoryEntity) session.get(CategoryEntity.class, id);
        byte[] blob = person.getImage();
        Blob bBlob= new SerialBlob(blob);
		log.info("CategoryDAOImpl getImageById method end");
		return bBlob;
	}

}
