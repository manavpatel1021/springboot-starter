package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseClass {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    Long id;
	
	@CreatedDate
	LocalDate createDate = LocalDate.now();
	
	@LastModifiedDate
	LocalDate modifiedDate;
	
}
