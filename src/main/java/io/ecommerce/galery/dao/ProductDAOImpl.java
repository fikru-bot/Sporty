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

import io.ecommerce.galery.entity.ProductEntity;


@Repository
public class ProductDAOImpl implements ProductDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public long add(ProductEntity bean) {
		log.info("ProductDAOImpl  add method start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(bean);
		log.info("ProductDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(ProductEntity bean) {
		log.info("ProductDAOImpl  update method start");
		sessionFactory.getCurrentSession().merge(bean);
		log.info("ProductDAOImpl  update method end");
	}

	@Override
	public void delete(ProductEntity bean) {
		log.info("ProductDAOImpl  delete method start");
		sessionFactory.getCurrentSession().delete(bean);
		log.info("ProductDAOImpl  delete method end");
	}

	@Override
	public ProductEntity findByName(String name) {
		log.info("ProductDAOImpl  login method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductEntity.class);
		criteria.add(Restrictions.eq("name", name));
		log.info("ProductDAOImpl  login method end");
		return (ProductEntity) criteria.uniqueResult();
	}
	
	
	

	@Override
	public ProductEntity findByPk(long id) {
		log.info("ProductDAOImpl  findPk method start");
		Session session = sessionFactory.getCurrentSession();
		log.info("ProductDAOImpl  findPK method end");
		return session.get(ProductEntity.class, id);
	}

	@Override
	public List<ProductEntity> search(ProductEntity bean, long pageNo, int pageSize) {
		log.info("ProductDAOImpl  search method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ProductEntity.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getCategoryId() > 0) {
				criteria.add(Restrictions.eq("categoryId", bean.getCategoryId()));
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
		log.info("ProductDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<ProductEntity> search(ProductEntity bean) {
		log.info("ProductDAOImpl  search method start");

		log.info("ProductDAOImpl search method end");
		return search(bean, 0, 0);
	}

	@Override
	public Blob getImageById(long id) throws SerialException, SQLException {
		
		Session session=sessionFactory.getCurrentSession();
		ProductEntity person = (ProductEntity) session.get(ProductEntity.class, id);
        byte[] blob = person.getImage();
        Blob bBlob= new SerialBlob(blob);
		return bBlob;
	}

}
