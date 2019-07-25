package com.rlugo14;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> allMasses = Arrays.asList(16, 1, 128);
        int weight = 145;
        try {
            Scale.getMasses(weight, allMasses);
        } catch (NonWeightableException e) {
            e.printStackTrace();
        }
    }
}
