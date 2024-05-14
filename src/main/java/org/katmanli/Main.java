package org.katmanli;
import org.katmanli.business.concrates.CustomerManager;
import org.katmanli.dao.concrates.CustomerDao;
import org.katmanli.entities.Customers;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager(new CustomerDao());


        /*Customers customers = new Customers();
        customers.setName("Ayse");
        customers.setMail("info@ayse.com");
        customers.setGender(Customers.GENDER.FAMELA);
        customers.setOnDate(LocalDate.now());

        customerManager.save(customers);*/

        List<Customers> customers = customerManager.findAll();
        System.out.println(customers.toString());

    }
}