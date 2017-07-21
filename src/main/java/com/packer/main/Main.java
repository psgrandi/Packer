package com.packer.main;

import com.packer.Packer;
import com.packer.exception.APIException;

/**
 * Main class used to run the application
 * @author psilveira
 *
 */
public class Main {

	public static void main(String[] args) throws APIException {
		if (args[0] == null) {
			throw new APIException("To run this app is required the path to the file!");
		} else {
			new Packer().pack(args[0]);
			System.out.println(new Packer().pack(args[0]));
		}
	}
	
}
