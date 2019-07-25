package com.rlugo14;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> allMasses = Arrays.asList(16, 1, 128, 20, 56, 100, 70, 3, 5, 10, 15, 45, 14, 4, 6);
        int weight = 28;
        try {
            Scale.getMasses(weight, allMasses);
        } catch (NonWeightableException e) {
            e.printStackTrace();
        }
    }
}
