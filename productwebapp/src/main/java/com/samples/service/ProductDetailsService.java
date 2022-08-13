package com.samples.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Product;
import com.samples.utils.HibernateUtil;

public class ProductDetailsService {
	
	public void addProduct(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.getTransaction();

		try {

			transaction.begin();
			session.save(product);
			
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public List<Product> getproducts(){
		List<Product> products = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.getTransaction();

		try {

			transaction.begin();
			products = session.createQuery("from Product").list();
			
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
			return products;
	}
}
