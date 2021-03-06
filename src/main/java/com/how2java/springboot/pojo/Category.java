package com.how2java.springboot.pojo;

//public class Category {
//	  
//    private int id;
//      
//    private String name;
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//      
//}
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
@Entity
@Table(name = "category_")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Category {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
     
    @Column(name = "name")
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
     
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
}