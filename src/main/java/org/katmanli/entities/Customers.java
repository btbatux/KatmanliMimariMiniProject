package org.katmanli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "customers") //Db'deki karşılığı
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Benzersiz bir kimlik.
    @Column(name = "customer_id")
    private int id; //customer_id

    @Column(name = "customer_name",length = 100, nullable = false)//Db'de karşılık geldiği kolon,100 karakter, null olamaz.
    private String name;

    @Column(name = "customer_mail",unique = true,nullable = false)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;

    @Enumerated(EnumType.STRING) //Bunun bir sabit olduğunu ve String türünde olduğunu belirttik.
    @Column(name = "customer_gender",length = 15)
    private GENDER gender;
    public enum GENDER{MALE,FAMELA}


    public Customers() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getOnDate() {
        return onDate;
    }

    public void setOnDate(LocalDate onDate) {
        this.onDate = onDate;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", onDate=" + onDate +
                ", gender=" + gender +
                '}';
    }
}