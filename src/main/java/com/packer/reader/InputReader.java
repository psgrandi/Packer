package com.packer.reader;

import java.util.List;

import com.packer.model.Pack;

/**
 * Interface reader that is implemented to read input files
 * @author psilveira
 *
 */
public interface InputReader {
	
	/**
	 * Read method that receives the path to a file, read it and return a list o packs.
	 * 
	 * @param Path to the file
	 * @return List of Packs
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	List<Pack> read(String absolutePath) throws IllegalArgumentException, Exception;
	
}
