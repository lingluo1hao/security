package com.luo.security.security.entity;

import javax.persistence.*;

@Entity
@Table(name = "s_role")
public class sRole implements java.io.Serializable {


    private Integer id;
    private sUser sUser;
    private String name;

    public sRole() {
    }

    public sRole(sUser sUser) {
        this.sUser = sUser;
    }

    public sRole(sUser sUser, String name) {
        this.sUser = sUser;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", nullable = false)
    public sUser getSUser() {
        return this.sUser;
    }

    public void setSUser(sUser sUser) {
        this.sUser = sUser;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
