package com.rlugo14;

import java.util.ArrayList;
import java.util.List;

class Scale {
	static List<Integer> getMasses(Integer weight, List<Integer> allMasses) throws NonWeightableException{
		List<Integer> massesRepetitions = new ArrayList<>(allMasses.size());
		List<Integer> desiredIndexes = new ArrayList<>();
		
		int sumOfAllMasses = allMasses.stream().mapToInt(mass -> mass).sum();
		
		if (weight > sumOfAllMasses) {
			throw new NonWeightableException("Weight too big and therefore not weightable");
		}
		
		while (weight > 0) {
			for (Integer mass : allMasses) {
				massesRepetitions.add(weight/mass);
			}
			
			try {
				int indexOfInterest = massesRepetitions.indexOf(1);
				desiredIndexes.add(indexOfInterest);
				int nonRepeatedMass = massesRepetitions.get(indexOfInterest);
				int massToSubstract = allMasses.get(massesRepetitions.indexOf(nonRepeatedMass));
				
				weight -= massToSubstract;
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new NonWeightableException("No possible to weight with available masses");
			}
			
			massesRepetitions.clear();
		}
		System.out.println(desiredIndexes);
		return massesRepetitions;
	}
}
