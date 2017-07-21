package com.packer.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.packer.model.Item;
import com.packer.model.Pack;

/**
 * Implementation of an algorithm that analyzes an pack of items and choose a set of items with the highest cost and lowest weight.
 * Each pack has a weight limit.
 * 
 * @author psilveira
 *
 */
public class HighestCostLowestWeightAlgorithm implements Algorithm {

	@Override
	public Pack process(Pack pack) {

		List<List<Item>> uniqueCombinations = 
				getAllUniqueCombinations(pack.getItems().stream()
															.filter(item -> item.getWeight() <= pack.getWeightLimit())
															.collect(Collectors.toList()));

		return new Pack(pack.getWeightLimit(), getBetterCost(pack, uniqueCombinations));
	}
	
	/**
	 * Method that receive a list of itens and create all unique combinations.
	 * 
	 * @param List of itens
	 * @return List of each combination
	 */
	public List<List<Item>> getAllUniqueCombinations(List<Item> itens) {
		List<List<Item>> uniqueCombinations = new ArrayList<>();
		for (Item item : itens) {
			List<List<Item>> itemCombinations = new ArrayList<>();
			
			for (List<Item> combination : uniqueCombinations) {
				List<Item> newCombination = new ArrayList<Item>(combination);
				newCombination.add(item);
				itemCombinations.add(newCombination);
			}
			
			uniqueCombinations.addAll(itemCombinations);
			ArrayList<Item> current = new ArrayList<Item>();
			current.add(item);
			uniqueCombinations.add(current);
		}

		return uniqueCombinations;
	}

	/**
	 * Algorithm that analyzes all combinations from each pack and choose the combination with the highest cost, 
	 * if there's two or more combinations with the same cost, then the combination with the lowest weight is chosen. 
	 * 
	 * @param Pack to be analyzed
	 * @param All possible combinations
	 * @return List of best combinations
	 */
	public List<Item> getBetterCost(Pack pack, List<List<Item>> combinations) {
		List<Item> bestPackage = new ArrayList<>();

		double highestCost = 0;
		double lowestWeight = 100;

		for (List<Item> combination : combinations) {
			double combinationWeight = combination.stream()
					.mapToDouble(Item::getWeight)
					.sum();
			
			if (combinationWeight <= pack.getWeightLimit()) {
				double combinationPrice = combination.stream()
						.mapToDouble(Item::getCost)
						.sum();
				
				if (combinationPrice > highestCost) {
					highestCost = combinationPrice;
					bestPackage = combination;
					lowestWeight = combinationWeight;
					
				} else if (combinationPrice == highestCost) {
					if (combinationWeight < lowestWeight) {
						bestPackage = combination;
						lowestWeight = combinationWeight;
					}
				}
			}
		}
		return bestPackage;
	}

}
