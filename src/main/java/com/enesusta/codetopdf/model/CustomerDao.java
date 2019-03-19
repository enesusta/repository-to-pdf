package com.enesusta.codetopdf.model;

public class CustomerDao {

    public String createCustomer(Customer customer) {
        return customer.getFirstName() + " isimli kullanici olusturuldu";
    }

}
