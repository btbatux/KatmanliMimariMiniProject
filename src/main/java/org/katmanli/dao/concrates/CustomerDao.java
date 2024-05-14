package org.katmanli.dao.concrates;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;
import org.katmanli.core.HibernateSession;
import org.katmanli.dao.abstracts.ICustomerDao;
import org.katmanli.entities.Customers;

import java.util.List;

public class CustomerDao implements ICustomerDao {
    private final Session session;


    public CustomerDao() {
        this.session = HibernateSession.getSession();
    }

    @Override
    public void save(Customers customer) {
        this.session.beginTransaction();
        this.session.persist(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public Customers findById(int id) {
        return this.session.get(Customers.class, id);
    }

    @Override
    public void update(Customers customer) {
        this.session.beginTransaction();
        this.session.merge(customer); // persist yerine merge kullanmak daha doğru olabilir.
        this.session.getTransaction().commit();
    }

    @Override
    public void delete(Customers customers) {
        this.session.beginTransaction();
        this.session.remove(customers);
        this.session.getTransaction().commit();
    }

    @Override
    public List<Customers> findAll() {
        return this.session.createSelectionQuery("FROM Customers", Customers.class).getResultList();

    }

    @Override
    public Customers findByMail(String mail) {
        SelectionQuery<Customers> query = this.session.createSelectionQuery("FROM Customers WHERE mail = :mail", Customers.class);
        query.setParameter("mail", mail);

        return query.getSingleResultOrNull();
    }
}
