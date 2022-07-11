package com.example.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
@Data
public class UserEntity extends BaseClass {

    
    String firstName;
    String lastName;
    String msg;
    String email;

}
