package com.excited.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Mobile {
	
	@Id
	private int id;
	private String name;
	private int cost;
	public Mobile() {
    }
	
	public Mobile(int id2, String name2, int cost2) {
		this.id = id2;
		this.name = name2;
		this.cost = cost2;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}
	

}
