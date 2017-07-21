package com.packer.model;

import java.util.List;

/**
 * Entity of packs that contains a weight limit and a list of items
 * @author psilveira
 *
 */
public class Pack {

	private double weightLimit;
	private List<Item> items;

	public Pack(double weightLimit, List<Item> items) {
		this.weightLimit = weightLimit;
		this.items = items;
	}

	public double getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(double weightLimit) {
		this.weightLimit = weightLimit;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItens(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		
//		return (this.itens == null || this.itens.isEmpty()) ? 
//				"-" : itens.stream().map(item -> String.valueOf(item.getIndex())).collect(Collectors.joining(", ")); 
		
		return "Package [weightLimit=" + weightLimit + ", itens=" + items + "]";
	}

}
