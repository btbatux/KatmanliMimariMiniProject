package org.katmanli.business.abstracts;

import org.katmanli.entities.Customers;

import java.util.List;

public interface ICustoemrService {

    void save(Customers customers);

    Customers findById(int id);

    void update(Customers customers);

    void deletebyId(int id);

    List<Customers> findAll();
}
