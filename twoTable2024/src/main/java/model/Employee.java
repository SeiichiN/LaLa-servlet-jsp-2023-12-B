package model;

import java.io.Serializable;

import model.dept.Dept;

public class Employee implements Serializable {
	private String id;
	private String name;
	private int age;
	private Dept dept;
	
	public Employee() {}

	public Employee(String id, String name, int age, Dept dept) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Dept getDept() {
		return dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept + "]";
	}
	
}
