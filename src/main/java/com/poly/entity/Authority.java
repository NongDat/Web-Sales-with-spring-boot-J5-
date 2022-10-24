// Generated with g9.

package com.poly.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Authorities", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Username", "Roleid"})
})
public class Authority implements Serializable {

  

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id", unique=true, nullable=false, precision=10)
    private Integer id;
    @ManyToOne(optional=false)
    @JoinColumn(name="RoleId", nullable=false)
    private Role role;
    @ManyToOne
    @JoinColumn(name="Username", nullable=false)
    private Account account;

   

}
