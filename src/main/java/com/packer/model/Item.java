package com.packer.model;

/**
 * Entity with Item inside of pack.
 * 
 * @author psilveira
 *
 */
public class Item {

	private Integer index;
	private double weight;
	private double cost;

	public Item(Integer index, double weight, double cost) {
		this.index = index;
		this.weight = weight;
		this.cost = cost;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Item [index=" + index + ", weight=" + weight + ", cost=" + cost + "]";
	}

}
