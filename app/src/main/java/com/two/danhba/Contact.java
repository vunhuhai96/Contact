package com.two.danhba;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by admin on 5/20/2018.
 */

@IgnoreExtraProperties
public class Contact implements Serializable {
    public String name, company, phone, email;
    public int gioiTinh;

    public Contact() {
    }

    public Contact(String name, String company, String phone, String email, int gioiTinh) {
        this.name = name;
        this.company = company;
        this.phone = phone;
        this.email = email;
        this.gioiTinh = gioiTinh;
    }
}
