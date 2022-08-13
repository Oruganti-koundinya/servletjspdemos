package com.samples.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="houseno", column=@Column(name="billing_houseno")),
		@AttributeOverride(name="street", column=@Column(name="billing_street")),
		@AttributeOverride(name="city", column=@Column(name="billing_city")),
		@AttributeOverride(name="pincode", column=@Column(name="billing_pincode"))
	})
	private Address billingAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="houseno", column=@Column(name="shipping_houseno")),
		@AttributeOverride(name="street", column=@Column(name="shipping_street")),
		@AttributeOverride(name="city", column=@Column(name="shipping_city")),
		@AttributeOverride(name="pincode", column=@Column(name="shipping_pincode"))
	})
	private Address shippingAddress;
	
	public User() {
		
	}

	public User(String name, Address billingAddress, Address shippingAddress, int age) {
		this.name = name;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", billingAddress=" + billingAddress + ", shippingAddress="
				+ shippingAddress + "]";
	}
	
	
	
}