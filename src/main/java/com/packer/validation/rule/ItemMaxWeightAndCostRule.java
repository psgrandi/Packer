package com.packer.validation.rule;

import com.packer.exception.APIException;
import com.packer.model.Item;
import com.packer.model.Pack;
import com.packer.validation.Validator;

/**
 * Rule that check if each Item cost and weight are below the threshold
 * @author psilveira
 *
 */
public class ItemMaxWeightAndCostRule implements Validator {

	private static final Integer WEIGHT_LIMIT = 100;
	private static final Double COST_LIMIT = 100.0;

	@Override
	public void validate(Pack pack) {
		pack.getItems().stream().forEach(i -> validateCostLimit(i));
		pack.getItems().stream().forEach(i -> validateWeightLimit(i));
	}

	/**
	 * Check if item cost are below the threshold, if not then an APIException is thrown.
	 * @param item
	 */
	public void validateCostLimit(Item item) {
		if (item.getCost() > COST_LIMIT) {
			throw new APIException("Item can not cost more than " + COST_LIMIT + ". Current item cost: " + item.getCost());
		}
	}

	/**
	 * Check if item weight are below the threshold, if not then an APIException is thrown.
	 * @param item
	 */
	public void validateWeightLimit(Item item) {
		if (item.getWeight()> WEIGHT_LIMIT) {
			throw new APIException("Item can not weight more than " + COST_LIMIT + ". Current item weight: " + item.getWeight());
		}
	}

}
