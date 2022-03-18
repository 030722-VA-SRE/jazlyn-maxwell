package com.revature.models;

import java.util.Objects;

public class Region {
	
	private int id;
	private String name;
	private String country;
	
	public Region() {
		super();
	}

	public Region(int id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		return Objects.equals(country, other.country) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	
	
}
