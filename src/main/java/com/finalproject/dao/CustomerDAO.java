package com.finalproject.dao;

import com.finalproject.model.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCustomer(Customer customer) {
        getSessionFactory().getCurrentSession().save(customer);
    }

    public void deleteCustomer(Customer customer) {
        getSessionFactory().getCurrentSession().delete(customer);
    }

    public void updateCustomer(Customer customer) {
        getSessionFactory().getCurrentSession().update(customer);
    }

    public Customer getCustomerById(int id) {
        List list = getSessionFactory().getCurrentSession().createCriteria(Customer.class).add(Restrictions.eq("customer_id", id)).list();
        return (Customer) list.get(0);
    }

    public List<Customer> getCustomers() {
        List list = getSessionFactory().getCurrentSession().createCriteria(Customer.class).list();
        return list;
    }
}
