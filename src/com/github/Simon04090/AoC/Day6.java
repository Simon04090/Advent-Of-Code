package com.github.Simon04090.AoC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Day6 {
    public static final String input = "14\t0\t15\t12\t11\t11\t3\t5\t1\t6\t8\t4\t9\t1\t8\t4";
    public static Integer[] ints;
    private static ArrayList<Integer> collect;
    private static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) {
        prepareInput();
        int i = 0;
        while (isB()) {
            ArrayList<Integer> step = step();

            list.add(step);
            i++;
        }
        System.out.println(i);

    }

    private static boolean isB() {
        long y = (long) list.size();
        long x = list.stream().distinct().count();
        return x == y;
    }

    private static ArrayList<Integer> step() {
        int i = collect.stream().max(Integer::compareTo).get();
        int index = collect.indexOf(i);
        ArrayList<Integer> integerArrayList = new ArrayList<>(collect);
        integerArrayList.set(index, 0);
        while (i > 0) {
            if (index + 1 < integerArrayList.size()) {
                index++;
            } else {
                index = 0;
            }
            integerArrayList.set(index, integerArrayList.get(index) + 1);
            i--;
        }
        return integerArrayList;
    }

    private static void prepareInput() {
        String[] split = input.split("\t");
        collect = Arrays.stream(split).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
