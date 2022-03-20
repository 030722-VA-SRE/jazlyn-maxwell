package com.revature.models;

import java.util.Objects;

public class Charm {

	private int id;
	private String name;
	private String description;
	private int price;
	private String region;
	private String country;
	private int sellerId;

	public Charm() {
		super();
	}
	
	public Charm(String name, String description, int price, String region, String country, int sellerId) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.region = region;
		this.country = country;
		this.sellerId = sellerId;
	}
	
	public Charm(int id, String name, String description, int price, String region, String country, int sellerId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.region = region;
		this.country = country;
		this.sellerId = sellerId;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, description, id, name, price, region, sellerId);
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
		return Objects.equals(country, other.country) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(name, other.name) && price == other.price
				&& Objects.equals(region, other.region) && sellerId == other.sellerId;
	}

	@Override
	public String toString() {
		return "Charm [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", region="
				+ region + ", country=" + country + ", sellerId=" + sellerId + "]";
	}


}
