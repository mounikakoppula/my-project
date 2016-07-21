
package com.niit.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;


@Repository("SupplierDAO")
public abstract class SupplierDAOImpl implements SupplierDAO {
	private static final Object Category = null;
	@Autowired
	private SessionFactory sessionFactory;
	private Object ListSupplier;
	public SupplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Supplier supplier){
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}
	@Transactional
	public void delete(String id){
		Supplier supplierToDelete=new Supplier();
		supplierToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(Category);
	}
	
	@Transactional
	
	public Supplier get(String id){
		String hql="from Category where id="+"'"+id+"'";
		//from category where id='101'
		Query query=(Query) sessionFactory .getCurrentSession().createQuery(hql);
		List<Supplier> listCategory= (List<Supplier>)  query.getResultList();
		
		if(listCategory!=null  &&   !listCategory.isEmpty())
		{
			return listCategory.get(0);
		}
		return null;
	}
	@Transactional
	public List<Supplier>list(){
		@SuppressWarnings ("unchecked")
	List<Supplier> listCategory=(List<Supplier>)
		sessionFactory.getCurrentSession()
		.createCriteria(Supplier.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
	}
}
	

 
