package com.packer.validation.rule;

import com.packer.exception.APIException;
import com.packer.model.Pack;
import com.packer.validation.Validator;

/**
 * Rule that check if each pack has a maximum number of 15 items.
 * @author psilveira
 *
 */
public class MaxSetOfItensRule implements Validator {

	private static final Integer NUMBER_OF_ITENS_LIMIT = 15;
	
	@Override
	public void validate(Pack pack) {
		if (pack.getItems().size() > NUMBER_OF_ITENS_LIMIT) {
			throw new APIException("Package can not have more than " + NUMBER_OF_ITENS_LIMIT + " itens. Current size: " + pack.getItems().size());
		}
	}
	
}
