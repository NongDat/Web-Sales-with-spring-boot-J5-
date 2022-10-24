// Generated with g9.

package com.poly.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Accounts")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    @Id
    @Column(name="Username", unique=true, nullable=false, length=50)
    private String username;
    
    @Column(name="Password", nullable=false, length=50)
    private String password;
    
    @Column(name="Fullname", nullable=false, length=50)
    private String fullname;
    
    @Column(name="Email", nullable=false, length=50)
    private String email;
    
    @Column(name="Photo", nullable=false, length=50)
    private String photo;
    
    private boolean role;
    
    @OneToMany(mappedBy="account")
    private List<Order> orders;

   
}
