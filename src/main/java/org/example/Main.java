package org.example;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        String data =
                "36 23 33 27 19 26 37 30 31 25 " +
                "25 17 30 24 32 38 27 18 23 22 " +
                "21 27 10 28 33 29 36 15 26 24 " +
                "31 21 23 17 22 32 15 25 18 22 " +
                "16 35 31 20 24 26 36 29 25 19 " +
                "27 24 30 22 27 21 28 24 12 23 " +
                "20 19 15 23 25 38 26 31 27 37 " +
                "24 11 28 18 20 30 22 27 33 21 " +
                "13 26 34 31 29 24 30 28 25 23 " +
                "32 21 10 22 16 27 25 24 23 24";
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
        String points = formatDataAsPoints(hashMap);
        System.out.println(points);

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

    public static String formatDataAsPoints(Map<Integer, Integer> hashMap) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int x = entry.getKey();
            int y = entry.getValue();
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