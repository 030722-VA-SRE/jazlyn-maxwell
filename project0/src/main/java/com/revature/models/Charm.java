package com.revature.models;

import java.util.Objects;

public class Charm {
	
	private int id;
	private String name;
	private String description;
	private int price;
	private Region region;
	private User seller;
	
	public Charm() {
		super();
	}
	
	public Charm(String name, String description, int price, Region region, User seller) {
		this();
		this.name = name;
		this.description = description;
		this.price = price;
		this.region = region;
		this.seller = seller;
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
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, price, region, seller);
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
		return Objects.equals(description, other.description) && id == other.id && Objects.equals(name, other.name)
				&& price == other.price && Objects.equals(region, other.region) && Objects.equals(seller, other.seller);
	}

	@Override
	public String toString() {
		return "Charm [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", region="
				+ region + ", seller=" + seller + "]";
	}

	
}
