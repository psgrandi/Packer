package com.packer.validation;

import java.util.ArrayList;
import java.util.List;

import com.packer.model.Pack;
import com.packer.validation.rule.ItemMaxWeightAndCostRule;
import com.packer.validation.rule.MaxSetOfItensRule;
import com.packer.validation.rule.PackageMaxWeightRule;

/**
 * Validator class that performs a set of validation rules on input files.
 * For each rule there's a Class that runs its validation separately 
 * 
 * @author psilveira
 *
 */
public class InputValidator {
	
	private Pack pack;

	private static final List<Class<? extends Validator>> rules = new ArrayList<Class<? extends Validator>>();
	static {
		rules.add(PackageMaxWeightRule.class);
		rules.add(MaxSetOfItensRule.class);
		rules.add(ItemMaxWeightAndCostRule.class);
	}

	public InputValidator(Pack pack) {
		this.pack = pack;
	}
	
	public void validate() {
		List<Validator> instances = instanciateRules();
		
		doProcess(instances);
	}

	private List<Validator> instanciateRules() {
		List<Validator> rulesInstances = new ArrayList<Validator>();

		rules.stream().forEach(r -> {
			try {
				rulesInstances.add(r.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
 				e.printStackTrace();
			}
		});

		return rulesInstances;
	}
	
	private void doProcess(List<Validator> instances) {
		instances.stream().forEach(i -> i.validate(this.pack));
	}

}
