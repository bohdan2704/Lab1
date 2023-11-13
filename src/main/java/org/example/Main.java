package org.example;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> number = new ArrayList<>() {};
        List<Integer> nums = new ArrayList<>() {};
        String data =
                "32 16 25 13 30 26 22 23 17 21 " +
                "24 10 29 37 23 11 34 15 27 13 " +
                "33 25 20 26 21 28 33 24 14 35 " +
                "31 16 24 38 27 25 22 17 29 23 " +
                "23 30 13 34 26 18 31 25 19 36 " +
                "26 15 27 35 24 12 23 18 28 32 " +
                "21 25 20 28 22 29 17 24 16 26 " +
                "36 23 33 27 19 26 37 30 31 25 " +
                "25 17 30 24 32 38 27 18 23 22 " +
                "21 27 10 28 33 29 36 15 26 24 ";
        String [] numbersFromData = data.split(" ");
        for (String num : numbersFromData) {
            numbers.add(Integer.parseInt(num));
        }

        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        for (int num : numbers) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num)+1);
            } else {
                hashMap.put(num, 1);
            }
        }

        Integer mostFrequentValue = findKeyWithMaxValue(hashMap);
        double mediumValue = findMediumValue(numbers);
        Pair minMAx = findMinMaxValues(numbers);
        double avgValue = avgValue(numbers);
        String points = formatDataAsPoints(hashMap, number, nums);
        double calculate8 = calculateSumTask8(number, nums);
        double calculateI10 = calculateSumTaskIntegral10();
        double calculateD10 = calculateSumTaskDiscrete10(number, nums);
        System.out.println(points);

        System.out.println("\n" + mostFrequentValue);
        System.out.println("\n" + mediumValue);
        System.out.println("\n" + minMAx);
        System.out.println("\n" + avgValue);
        System.out.println("\n" + calculate8);
        System.out.println("\n" + calculateI10);
        System.out.println("\n" + calculateD10);
    }

    public static double calculateSumTask8(List<Integer> numbers, List<Integer> nums) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }

        double sum = 0;
        double Xv = 24.74;
        for (int i = 0; i < numbers.size(); i++) {
            sum += Math.pow(numbers.get(i), 2) * nums.get(i) - Math.pow(Xv, 2);
        }

        return 0.01 * sum;
    }
    public static double calculateSumTaskIntegral10() {
        int[] nums = {7, 11, 11, 25, 21, 14, 11};
        double sum = 0;
        double Xv = 24.74;
        double x = 12;
        for (int i = 0; i < nums.length; i++, x += 4) {
            sum += Math.pow((x - Xv),3) * nums[i];
        }

        return 0.01 * sum;
    }
    public static double calculateSumTaskDiscrete10(List<Integer> numbers, List<Integer> nums) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }

        double sum = 0;
        double Xv = 24.74;
        for (int i = 0; i < numbers.size(); i++) {
            sum += Math.pow((numbers.get(i) - Xv),3) * nums.get(i);
        }

        return 0.01 * sum;
    }

    public static double findMediumValue(List<Integer> numbers) {
        Collections.sort(numbers);
        int size = numbers.size();
        if (size % 2 == 0) {
            int firstIndex = size / 2 - 1;
            int secondIndex = size / 2;

            return  (numbers.get(firstIndex) + numbers.get(secondIndex))/2.0;
        } else {
            return numbers.get(size/2);
        }
    }

    public static Pair findMinMaxValues(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);

        return new Pair(min, max);
    }

    public static Integer findKeyWithMaxValue(Map<Integer, Integer> map) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("Map is empty or null");
        }

        Map.Entry<Integer, Integer> maxEntry = null;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

    public static String formatDataAsPoints(Map<Integer, Integer> hashMap, List<Integer> num, List<Integer> nums) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int x = entry.getKey();
            num.add(x);
            int y = entry.getValue();
            nums.add(y);
            stringBuilder.append("(").append(x).append(", ").append(y).append(")\n");
        }

        return stringBuilder.toString();
    }

    public static double avgValue(List<Integer> list) {
        int sum = 0;
        for (int value : list) {
            sum += value;
        }
        return (double)sum/list.size();
    }

}