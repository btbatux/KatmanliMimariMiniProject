package org.katmanli.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.katmanli.dao.concrates.CustomerDao;
import org.katmanli.entities.Customers;


public class HibernateSession {
    public static Session session = null;



    public static Session getSession() {
        if (session == null) {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Customers.class)
                    .buildSessionFactory();

            session = sessionFactory.openSession();

        }
        return session;
    }
}
