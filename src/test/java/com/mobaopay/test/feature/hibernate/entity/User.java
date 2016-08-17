package com.mobaopay.test.feature.hibernate.entity;


import javax.persistence.*;

/**
 * Created by ruby on 2016/8/16.
 * Email:liyufeng_23@163.com
 */
@Entity
@Table(name="t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
