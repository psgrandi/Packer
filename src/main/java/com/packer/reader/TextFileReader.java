package com.packer.reader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.packer.model.Item;
import com.packer.model.Pack;
import com.packer.validation.InputValidator;

/**
 * Implementation class from InputReader that read a text file separated with tabs
 * Example: 81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
 * 
 * @author psilveira
 *
 */
public class TextFileReader implements InputReader {
	
	public TextFileReader() {
	}

	@Override
	public List<Pack> read(String absolutePath) throws IllegalArgumentException, Exception {
		List<Pack> packages;

		try (Stream<String> lines = Files.lines(Paths.get(absolutePath))) {
			packages = lines
					.map(extractPackagesFromFile)
					.collect(Collectors.toList());

			packages.stream().forEach(p -> new InputValidator(p).validate());					
		}

		return packages;
	}
		

	private Function<String, Pack> extractPackagesFromFile = line -> {
		String[] splittedLine = line.split(":");

		double limit = Integer.parseInt(splittedLine[0].trim());

		List<Item> itens = Arrays.asList(splittedLine[1]
								.trim()
								.split(" "))
							.stream()
							.map(extractItemFromLine)
							.collect(Collectors.toList());

		return new Pack(limit, itens);
	};

	private static Function<String, Item> extractItemFromLine = line -> {
		String[] details = line
				.replaceAll("[()]", "")
				.replaceAll("[^0-9.,]+","")
				.split(",");

		Integer index = Integer.parseInt(details[0]);
		Double weight = Double.parseDouble(details[1]);
		Double cost = Double.parseDouble(details[2]);

		return new Item(index, weight, cost);
	};
}
