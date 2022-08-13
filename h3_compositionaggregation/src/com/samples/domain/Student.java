package com.samples.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="registration_id", nullable = false)
	private String registrationId;
	
	private String name;
	
	private int age;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="guide_id")
	private Guide guide;
	
	public Student() {}

	public Student(String registrationId, String name, Guide guide, int age) {
		this.registrationId = registrationId;
		this.name = name;
		this.guide = guide;
		this.age = age;
	}
	

}