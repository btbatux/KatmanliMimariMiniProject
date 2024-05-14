package org.katmanli.dao.abstracts;

import org.katmanli.entities.Customers;

import java.util.List;

public interface ICustomerDao {

    void save(Customers customer);

    Customers findById(int id);

    void update(Customers customers);

    void delete(Customers customers);

    List<Customers> findAll();

    Customers findByMail(String mail);

}
