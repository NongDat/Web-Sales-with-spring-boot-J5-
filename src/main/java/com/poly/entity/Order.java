// Generated with g9.

package com.poly.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Order implements Serializable {

   

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id", unique=true, nullable=false, precision=19)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    Date createDate = new Date();
    
    @Column(name="Address", nullable=false, length=100)
    private String address;
    
    @Column(name = "IsPay")
    private boolean IsPay = false;

    @Column(name = "IsComfirm")
    private boolean IsComfirm = false;
    
    @OneToMany(mappedBy="order")
    private List<OrderDetail> orderDetails;
    
    @ManyToOne
    @JoinColumn(name="username")
    private Account account;

    

}
