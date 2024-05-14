package org.katmanli.business.concrates;

import org.katmanli.business.abstracts.ICustoemrService;
import org.katmanli.dao.abstracts.ICustomerDao;
import org.katmanli.entities.Customers;

import java.util.List;

public class CustomerManager implements ICustoemrService {

    private ICustomerDao iCustomerDao;


    //Dep injeciton
    public CustomerManager(ICustomerDao iCustomerDao) {
        this.iCustomerDao = iCustomerDao;
    }


    @Override
    public void save(Customers customers) {
        Customers checkMailCustomer = this.iCustomerDao.findByMail(customers.getMail());
        if (checkMailCustomer != null) {
            throw new RuntimeException(customers.getMail() + "bu eposta daha önceden eklenmiş");
        }
        this.iCustomerDao.save(customers);
    }

    @Override
    public Customers findById(int id) {

        return this.iCustomerDao.findById(id);
    }

    @Override
    public void update(Customers customers) {
        Customers checkMailCustomer = this.iCustomerDao.findByMail(customers.getMail());
        if (checkMailCustomer != null && checkMailCustomer.getId() != customers.getId()){
                throw  new RuntimeException(customers.getMail()+ " e posta zaten ekleniş");
        }
        this.iCustomerDao.update(customers);

    }

    @Override
    public void deletebyId(int id) {
        Customers customers = this.findById(id);
        this.iCustomerDao.delete(customers);
    }

    @Override
    public List<Customers> findAll() {
        return this.iCustomerDao.findAll();
    }
}
