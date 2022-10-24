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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role implements Serializable {

   

    @Id
    @Column(name="Id", unique=true, nullable=false, length=10)
    private String id;
    @Column(name="Name", nullable=false, length=50)
    private String name;
    @OneToMany(mappedBy="role")
    private List<Authority> authorities;

   

}
