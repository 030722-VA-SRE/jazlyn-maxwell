package com.revature.models;

import java.util.Objects;

public class Charm {
	
	private int id;
	private String name;
	private String description;
	private long price;
	public static int counter;
	
	public Charm() {
		super();
		this.id = counter;
		counter++;
	}
	public Charm(String name, String description, long price) {
		this();
		this.name = name;
		this.description = description;
		this.price = price;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(description, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Charm other = (Charm) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& price == other.price;
	}
	@Override
	public String toString() {
		return name + ": " + description;
	}
	
}
