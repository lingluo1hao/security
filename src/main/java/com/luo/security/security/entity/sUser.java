package com.luo.security.security.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Table(name = "s_user")
public class sUser  implements java.io.Serializable {



    private Integer id;
    private String name;
    private String email;
    private String password;
    private Date dob;
    private Set<sRole> sRoles = new HashSet<sRole>(0);

    public sUser() {
    }

    public sUser(String name, String email, String password, Date dob, Set<sRole> sRoles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.sRoles = sRoles;
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

    @Column(name = "name", length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", length = 20)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", length = 20)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", length = 10)
    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "SUser")
    public Set<sRole> getSRoles() {
        return this.sRoles;
    }

    public void setSRoles(Set<sRole> sRoles) {
        this.sRoles = sRoles;
    }


}
