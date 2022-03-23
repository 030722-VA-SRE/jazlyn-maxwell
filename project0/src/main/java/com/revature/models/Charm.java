package com.revature.models;

import java.util.Objects;

import com.revature.services.UserService;

public class Charm {

	private int id;
	private String name;
	private String description;
	private int price;
	private String region;
	private String country;
	private User seller;

	public Charm() {
		super();
	}
	
	public Charm(int id, String name, String description, int price, String region, String country, int sellerId) {
		this();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.region = region;
		this.country = country;
		UserService uServ = new UserService();
		this.seller = uServ.getUserById(sellerId);
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
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, description, id, name, price, region, seller);
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
				&& Objects.equals(region, other.region) && seller == other.seller;
	}

	@Override
	public String toString() {
		return "Charm [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", region="
				+ region + ", country=" + country + ", seller=" + seller + "]";
	}


}
