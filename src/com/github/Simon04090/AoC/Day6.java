package com.github.Simon04090.AoC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Day6 {
    private static final String input = "14\t0\t15\t12\t11\t11\t3\t5\t1\t6\t8\t4\t9\t1\t8\t4";
    private static ArrayList<Integer> collect;
    private static final ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        prepareInput();
        System.out.println(part1());
        System.out.println(part2());

    }

    private static int part2() {
        return list.size() - list.indexOf(collect);
    }

    private static int part1() {
        int i = 0;
        ArrayList<Integer> lastStep = new ArrayList<>(collect);
        while (!isRepeat(lastStep)) {
            list.add(lastStep);
            lastStep = step();

            i++;
            collect = new ArrayList<>(lastStep);
        }
        return i;
    }

    private static boolean isRepeat(ArrayList<Integer> step) {
        if (list.size()==0) return false;
        for (ArrayList<Integer> integers : list) {
            if (step.equals(integers)) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Integer> step() {
        @SuppressWarnings("ConstantConditions") int i = collect.stream().max(Integer::compareTo).get();
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
