package com.packer.algorithm;

import com.packer.model.Pack;

/**
 * Interface algorithms used to implement an file reader algorithm.
 * 
 * @author psilveira
 *
 */
public interface Algorithm {

	/**
	 * Method that receives an Pack and perform an analysis based on rules to return the best pack to be sent.
	 * 
	 * @param Pack with items and weight limit
	 * @return Best pack to be sent
	 */
	Pack process(Pack pack);
}
