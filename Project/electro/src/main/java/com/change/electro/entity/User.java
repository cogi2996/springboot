package com.change.electro.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="User")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "role")
    private int role;

    // Các order của user
    @OneToMany
    @JoinColumn(name="order_id")
    private List<Order> orders;

    //Giỏ hàng của user
    @OneToOne
    @JoinColumn(name="cart_id")
    private Cart userCart;

    // các review của user
    @ManyToMany(mappedBy = "reviewAuthor")
    private List<Review> reviews;


}
