package com.packer.validation.rule;

import com.packer.exception.APIException;
import com.packer.model.Pack;
import com.packer.validation.Validator;

/**
 * Rule that check if each max weight pack is below the threshold
 * @author psilveira
 *
 */
public class PackageMaxWeightRule implements Validator {

	private static final Integer PACK_WEIGHT_LIMIT = 100;
	
	@Override
	public void validate(Pack pack) {
		if (pack.getWeightLimit() > PACK_WEIGHT_LIMIT) {
			throw new APIException("Package can not weight more than " + PACK_WEIGHT_LIMIT + ". Current package weight: " + pack.getWeightLimit());
		}
	}
	
}
