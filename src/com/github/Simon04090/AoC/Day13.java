package com.github.Simon04090.AoC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day13 {
    private static final String input = "0: 5\n" +
            "1: 2\n" +
            "2: 3\n" +
            "4: 4\n" +
            "6: 8\n" +
            "8: 4\n" +
            "10: 6\n" +
            "12: 6\n" +
            "14: 8\n" +
            "16: 6\n" +
            "18: 6\n" +
            "20: 12\n" +
            "22: 14\n" +
            "24: 8\n" +
            "26: 8\n" +
            "28: 9\n" +
            "30: 8\n" +
            "32: 8\n" +
            "34: 12\n" +
            "36: 10\n" +
            "38: 12\n" +
            "40: 12\n" +
            "44: 14\n" +
            "46: 12\n" +
            "48: 10\n" +
            "50: 12\n" +
            "52: 12\n" +
            "54: 12\n" +
            "56: 14\n" +
            "58: 12\n" +
            "60: 14\n" +
            "62: 14\n" +
            "64: 14\n" +
            "66: 14\n" +
            "68: 17\n" +
            "70: 12\n" +
            "72: 14\n" +
            "76: 14\n" +
            "78: 14\n" +
            "80: 14\n" +
            "82: 18\n" +
            "84: 14\n" +
            "88: 20\n";
    private static final Map<Integer, Integer> depthRangeMap = new HashMap<>();

    public static void main(String[] args) {
        String[] split = input.split("\n");
        for (String s : split) {
            String[] split1 = s.split(": ");
            depthRangeMap.put(Integer.valueOf(split1[0]), Integer.valueOf(split1[1]));
        }
        Integer maxDepth = depthRangeMap.keySet().stream().max(Integer::compareTo).get();
//        int[] currentPositions = new int[maxDepth];
//        boolean[] directions = new boolean[maxDepth];
//        Arrays.fill(currentPositions, 1);
//        Arrays.fill(directions, true);
        int severity = 0;
//        for (int currentPosition = 0; currentPosition < currentPositions.length; currentPosition++) {
//            if (currentPositions[currentPosition] == 1) {
//                severity += (currentPosition * depthRangeMap.getOrDefault(currentPosition, 0));
//            }
//            for (int i : currentPositions) {
//                Integer range = depthRangeMap.getOrDefault(i, -1);
//                if (range > 0) {
//                    if (directions[i]) {
//                        if (currentPositions[i] == range) {
//                            currentPositions[i]--;
//                            directions[i] = false;
//                        } else {
//                            currentPositions[i]++;
//                        }
//                    }if (!directions[i]) {
//                        if (currentPositions[i] == 1) {
//                            currentPositions[i]++;
//                            directions[i] = true;
//                        } else {
//                            currentPositions[i]--;
//                        }
//                    }
//                }
//                if (range < 0) {
//                    currentPositions[i] = -1;
//                }
//            }
//        }
        for (int time = 0; time <= maxDepth; time++) {
            if (time%(depthRangeMap))
        }

        System.out.println(severity);
    }
}
