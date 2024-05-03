package com.gokulnathp.datastractures;

import java.util.*;

public class HashTable {
    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int size = 7;
    private Node[] dataMap = new Node[size];

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (dataMap[index] == null) {
            dataMap[index] = newNode;
            return;
        }

        Node currentNode = dataMap[index];
        while (currentNode.next != null) currentNode = currentNode.next;
        currentNode.next = newNode;
    }

    public int get(String key) {
        int index = hash(key);

        Node currentNode = dataMap[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) return currentNode.value;
            currentNode = currentNode.next;
        }

        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> keys = new ArrayList<>();

        for (Node node : dataMap) {
            Node currentNode = node;
            while (currentNode != null) {
                keys.add(currentNode.key);
                currentNode = currentNode.next;
            }
        }

        return keys;
    }

    public int hash(String key) {
        return key.chars().reduce(0, (accumulator, element) -> (accumulator + element * 23) % size);
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ":");
            Node currentNode = dataMap[i];
            while (currentNode != null) {
                System.out.println("\t(Key=" + currentNode.key + ", Value=" + currentNode.value + ")");
                currentNode = currentNode.next;
            }
        }
    }

    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for (int number : array1) hashMap.put(number, true);

        for (int number : array2) if (hashMap.get(number) != null) return true;

        return false;
    }

    public static List<Integer> findDuplicates(int[] numbers) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int number : numbers) hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);

        ArrayList<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) duplicates.add(entry.getKey());
        }

        return duplicates;
    }

    public static List<Integer> findDuplicatesV1(int[] numbers) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        ArrayList<Integer> duplicates = new ArrayList<>();

        for (int number : numbers) {
            if (hashMap.get(number) == null) hashMap.put(number, true);
            else if (!duplicates.contains(number)) duplicates.add(number);
        }

        return duplicates;
    }

    public static Character firstNonRepeatingChar(String string) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (Character letter : string.toCharArray()) {
            hashMap.put(letter, hashMap.getOrDefault(letter, 0) + 1);
        }

        for (Character letter : string.toCharArray()) if (hashMap.get(letter) == 1) return letter;

        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String canonical = String.valueOf(chars);

            List<String> anagrams = hashMap.getOrDefault(canonical, new ArrayList<>());
            anagrams.add(string);
            hashMap.put(canonical, anagrams);
        }

        return new ArrayList<>(hashMap.values());
    }

    public static List<List<String>> groupAnagramsV1(String[] strings) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        outerLoop:
        for (String string : strings) {
            for (String key : hashMap.keySet()) {
                if (key.length() == string.length()) {
                    boolean isAnagram = true;
                    for (char c : key.toCharArray()) isAnagram &= string.contains(c + "");
                    for (char c : string.toCharArray()) isAnagram &= key.contains(c + "");

                    if (isAnagram) {
                        List<String> anagrams = hashMap.get(key);
                        anagrams.add(string);
                        hashMap.put(key, anagrams);
                        continue outerLoop;
                    }
                }
            }
            hashMap.put(string, new ArrayList<>(List.of(string)));
        }

        return new ArrayList<>(hashMap.values());
    }

    public static int[] twoSum(int[] numbs, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < numbs.length; i++) {
            int otherNumber = target - numbs[i];

            if (hashMap.containsKey(otherNumber)) return new int[]{hashMap.get(otherNumber), i};

            hashMap.put(numbs[i], i);
        }

        return new int[]{};
    }

    public static int[] twoSumV1(int[] numbs, int target) {
        for (int i = 0; i < numbs.length - 1; i++) {
            for (int j = i + 1; j < numbs.length; j++) {
                if (numbs[i] + numbs[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public static int[] subarraySum(int[] numbs, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int currentSum = 0;
        hashMap.put(currentSum, -1);

        for (int i = 0; i < numbs.length; i++) {
            currentSum += numbs[i];
            if (hashMap.containsKey(currentSum - target)) {
                return new int[]{hashMap.get(currentSum - target) + 1, i};
            }
            hashMap.put(currentSum, i);
        }

        return new int[]{};
    }

    public static int[] subarraySumV1(int[] numbs, int target) {
        for (int i = 0; i < numbs.length; i++) {
            int total = numbs[i];
            if (total == target) return new int[]{i, i};

            for (int j = i + 1; j < numbs.length; j++) {
                total += numbs[j];
                if (total == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public static List<Integer> removeDuplicates(List<Integer> myList) {
        return new ArrayList<>(new HashSet<>(myList));
    }

    public static boolean hasUniqueChars(String string) {
        HashSet<Character> characters = new HashSet<>();

        for (char c : string.toCharArray()) if (!characters.add(c)) return false;

        return true;
    }

    public static List<int[]> findPairs(int[] array1, int[] array2, int target) {
        HashSet<Integer> set = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();

        for (int number: array1) set.add(number);

        for (int number: array2) {
            int anotherNumber = target - number;
            if(set.contains(anotherNumber)) pairs.add(new int[] { anotherNumber, number });
        }

        return pairs;
    }

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        for(int number: nums) numberSet.add(number);

        int longestSequence = 0;

        for(int number: numberSet) {
            if(!numberSet.contains(number - 1)) {
                int currentNumber = number;
                int currentSequence = 1;

                while(numberSet.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentSequence++;
                }

                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }

        return longestSequence;
    }

    public static int longestConsecutiveSequenceV1(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int number: nums) numbers.add(number);

        if(numbers.size() <= 1) return numbers.size();

        int longestSequence = 1;
        int currentSequence = 1;
        for(int value: numbers) {
            if(numbers.contains(value - 1)) {
                currentSequence++;
                continue;
            }
            if(currentSequence > longestSequence) longestSequence = currentSequence;
            currentSequence = 1;
        }

        return Math.max(currentSequence, longestSequence);
    }
}
