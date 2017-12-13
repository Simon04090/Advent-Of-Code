package com.github.Simon04090.AoC;

import java.util.stream.IntStream;

public class Day10 {
    private static final String input = "157,222,1,2,177,254,0,228,159,140,249,187,255,51,76,30";
    private static int[] lengths;
    private static int[] lengths2;

    public static void main(String[] args) {
        prepareInput();
        System.out.println(part1());
        System.out.println(part2());

    }

    private static String part2() {
        int[] sparseHash = knotHash(lengths2, 64);
        int[] denseHash = new int[sparseHash.length / 16];
        for (int i = 0; i < sparseHash.length / 16; i++) {

            denseHash[i] = sparseHash[i * 16];
            for (int j = 1; j < sparseHash.length / 16; j++) {

                denseHash[i] = denseHash[i] ^ sparseHash[j + (i * 16)];
            }
        }
        StringBuilder hashStringBuilder = new StringBuilder();
        for (int hash : denseHash) {
            hashStringBuilder.append(String.format("%02x", hash));
        }
        return hashStringBuilder.toString();
    }

    private static int part1() {
        int[] ints = knotHash(lengths, 1);
        return ints[0] * ints[1];
    }

    private static int[] knotHash(int[] lengths, int rounds) {
        int pos = 0;
        int skipSize = 0;
        int[] ints = IntStream.range(0, 256).toArray();
        for (int i = 0; i < rounds; i++) {
            for (int length : lengths) {
                int currentStartPos = pos;
                int currentEndPos = pos + length - 1;
                currentEndPos %= ints.length;
                for (int y = 0; y < length / 2; y++) {
                    int anInt = ints[currentStartPos];
                    ints[currentStartPos] = ints[currentEndPos];
                    ints[currentEndPos] = anInt;
                    currentStartPos++;
                    if (currentStartPos >= ints.length) {
                        currentStartPos = 0;
                    }
                    currentEndPos--;
                    if (currentEndPos < 0) {
                        currentEndPos = ints.length - 1;
                    }
                }
                pos += skipSize + length;
                pos %= ints.length;
                skipSize++;
            }
        }
        return ints;
    }

    private static void prepareInput() {
        String[] split = input.split(",");
        lengths = new int[split.length];
        IntStream.range(0, split.length).forEachOrdered(i -> lengths[i] = Integer.parseInt(split[i]));
        char[] chars = input.toCharArray();
        lengths2 = new int[chars.length + 5];
        IntStream.range(0, chars.length).forEachOrdered(i -> lengths2[i] = chars[i]);
        lengths2[chars.length] = 17;
        lengths2[chars.length + 1] = 31;
        lengths2[chars.length + 2] = 73;
        lengths2[chars.length + 3] = 47;
        lengths2[chars.length + 4] = 23;
    }
}
