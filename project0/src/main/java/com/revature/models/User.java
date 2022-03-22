package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String email;
	private String password;
	private int balance;
	
	public User() {
		super();
	}

	public User(int id, String name, String email, String password, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, email, id, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return balance == other.balance && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}
	
}
