package com.airludan.entitis;

public class Student {
	private int no;
	private String name;
	private String password;
	private int age;
	private String hobby;
	private String email;

	public Student() {
	};

	public Student(int no, String name, String password, int age, String hobby, String email) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.age = age;
		this.hobby = hobby;
		this.email = email;
	}

	public String toString() {
		return "ѧ��:" + no + ",����:" + name +",����:" + age +",����:" + hobby + ",����:"+email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
