package com.sergim.zuup.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table
public class Driver implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer age;
	private String qualification;
	
	@OneToMany(mappedBy = "driver")
	@JsonIgnore
	private List<Car> cars = new ArrayList<>();

	public Driver() {
	}

	public Driver(Long id, String name, Integer age, String qualification) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.qualification = qualification;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public List<Car> getCars() {
		return cars;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Driver driver = (Driver) o;
		return Objects.equals(id, driver.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
