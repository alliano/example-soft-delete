package com.softdelete.models.entities;

import java.io.Serializable;
import java.util.Date;

// import org.hibernate.annotations.Filter;
// import org.hibernate.annotations.FilterDef;
// import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//anotasi @SQLDelete ini untuk meng custom query dari jpa 
@SQLDelete(sql = "UPDATE user set is_delete=NOW() WHERE id =?")
@Where(clause = "is_delete IS NULL")
/**
 * @FIlterDef() -> ini untuk membuat filter query
 * @ParamDef() untuk membuat filter parameter query
 * @Filter() ini untuk memfilter query parameter name nya reference ke nama dari @FilterDef
 * dan condition nya reverence ke nama dari @ParamDef
 */
// @FilterDef(name = "filterUser", parameters = @ParamDef(name="isDelete", type=Date.class))
// @Filter(name = "filterUser", condition = "is_delete = :isDeleted ")
@Entity
@Setter //=> untuk seter
@Getter//=>utuk geter
@NoArgsConstructor //=>untuk constructor
@Table(name = "user")
public class User implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(length = 50,nullable = false)
   private String name;

   @Column(nullable = false, unique = true)
   private String email;

   @Column(length = 255,nullable = false)
   private String password;

   @Column(length = 30,nullable = false)
   private String region;

   public Long getId() {
      return id;
   }

   @Temporal(TemporalType.TIMESTAMP)
   @Column(nullable = true)
   private Date is_delete;

   @Builder
   public User(String name,String email,String password,Date date,String region){
      this.is_delete = date;
      this.name = name;
      this.password = password;
      this.email = email;
      this.region = region;
   }

}
