package com.packer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.packer.algorithm.Algorithm;
import com.packer.algorithm.HighestCostLowestWeightAlgorithm;
import com.packer.exception.APIException;
import com.packer.model.Pack;
import com.packer.reader.TextFileReader;

/**
 * Packer class that perform an analysis of a pack and return a result based on the algorithm
 * @author psilveira
 *
 */
public class Packer {
	
	private TextFileReader reader;
	private Algorithm algorithm;
	
	public Packer() {
		this.reader = new TextFileReader();
		this.algorithm = new HighestCostLowestWeightAlgorithm();
	}
	
	/**
	 * Method that receives a path, reads the file and apply an algorithm
	 * 
	 * @param File absolute path 
	 * @return Indexes of the packages chosen by the algorithm concatanated with a break line
	 * @throws APIException
	 */
	public String pack(String absolutePath) throws APIException {
		
		List<Pack> packages;
		
        try {
        	packages = this.reader.read(absolutePath);
        	        	
        	return packages.stream()
        		.map(pack -> this.algorithm.process(pack))
        		.map(getIdsItensFromPack)
        		.collect(Collectors.joining("\n"));
        	
        } catch (Exception ex) {
            throw new APIException(ex.getMessage());
        }
	}
	
	private Function<Pack, String> getIdsItensFromPack = pack -> {
		
		List<String> result = new ArrayList<String>();
		
		if (pack.getItems() == null || pack.getItems().isEmpty()) {
			result.add("-");
		} else {
			result.add(pack.getItems().stream().map(i -> i.getIndex().toString()).collect(Collectors.joining(",")));
		}
		return result.stream().map(String::toString).collect(Collectors.joining("\n"));
	};
	
}
