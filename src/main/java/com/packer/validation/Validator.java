package com.packer.validation;

import com.packer.model.Pack;

/**
 * Interface validator that is implemented to apply validation rules on input files.
 * @author psilveira
 *
 */
public interface Validator {

	/**
	 * Method that apply validation rules, if any error is found then an exception is thrown
	 * 
	 * @param pack
	 */
	void validate(Pack pack);
	
}
