package com.rlugo14;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> allMasses = new LinkedList<>(Arrays.asList(1, 3, 4, 6, 22, 56, 114, 400, 158));
        int weight = 333;
        try {
            System.out.println(Scale.getMasses(weight, allMasses));
        } catch (NonWeightableException e) {
            e.printStackTrace();
        }
    }
}
