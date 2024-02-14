package com.change.electro.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    private Date time;

    // user đã review
    @ManyToMany
    @JoinColumn(name="user_id")
    private User reviewAuthor;

    // product của review này
    @OneToOne
    @JoinColumn(name="product_id")
    private Product reviewProduct;

}
