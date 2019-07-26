package com.rlugo14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Scale {
	static List<Integer> getMasses(Integer weight, List<Integer> allMasses) throws NonWeightableException{
		Collections.sort(allMasses);
		List<Integer> neededMasses = new ArrayList<>();
		List<Integer> massesRepetitions = new ArrayList<>();
		
		int restWeight = weight;
		
		while (restWeight > 0) {
			for (int mass: allMasses) {
				massesRepetitions.add(restWeight/mass);
			}
			int lessRepetitions = massesRepetitions.stream().min(Comparator.comparingInt(rep -> rep > 0 ? rep : 1000)).get();
			System.out.println(lessRepetitions);
			int sumAllMasses = allMasses.stream().mapToInt(mass -> mass).sum();
			if (restWeight > sumAllMasses) {
				throw new NonWeightableException("Not possible to weight using given masses");
			}
			if (allMasses.contains(restWeight)) {
				neededMasses.add(restWeight);
				break;
			}
			if (lessRepetitions < 3) {
				int massToSubstract = allMasses.get(massesRepetitions.lastIndexOf(lessRepetitions));
				neededMasses.add(massToSubstract);
				restWeight -= massToSubstract;
			} else {
				allMasses.remove(neededMasses.get(0));
				neededMasses.clear();
				restWeight = weight;
			}
			massesRepetitions.clear();
		}
		return neededMasses;
	}
}
