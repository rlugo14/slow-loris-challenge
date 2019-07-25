package com.rlugo14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Scale {
	static List<Integer> getMasses(Integer weight, List<Integer> allMasses) throws NonWeightableException{
		List<Integer> massesRepetitions = new ArrayList<>(allMasses.size());
		List<Integer> neededMasses = new ArrayList<>();
		Collections.sort(allMasses);
		List<Integer> desiredIndexes = new ArrayList<>();
		
		int sumOfAllMasses = allMasses.stream().mapToInt(mass -> mass).sum();
		
		if (weight > sumOfAllMasses) {
			return neededMasses;
		} else if (allMasses.contains(weight)) {
			Integer result = allMasses.get(allMasses.indexOf(weight));
			neededMasses.add(result);
			return neededMasses;
		}
		
		while (weight > 0) {
			for (Integer mass : allMasses) {
				massesRepetitions.add(weight/mass);
			}
			
			try {
				int indexOfInterest = massesRepetitions.lastIndexOf(1);
				desiredIndexes.add(indexOfInterest);
				int nonRepeatedMass = massesRepetitions.get(indexOfInterest);
				int massToSubstract = allMasses.get(massesRepetitions.indexOf(nonRepeatedMass));
				
				weight -= massToSubstract;
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new NonWeightableException("No possible to weight with available masses");
			}
			
			massesRepetitions.clear();
		}
		Collections.sort(desiredIndexes);
		neededMasses = desiredIndexes.stream().map(index -> allMasses.get(index)).collect(Collectors.toList());
		
		return neededMasses;
	}
}
