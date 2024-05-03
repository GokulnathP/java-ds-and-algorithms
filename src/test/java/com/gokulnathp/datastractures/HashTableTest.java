package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Nested
    class Hash {
        @Test
        void shouldHashTheKey() {
            HashTable hashTable = new HashTable();

            assertEquals(3, hashTable.hash("screws"));
            assertEquals(4, hashTable.hash("bolts"));
            assertEquals(6, hashTable.hash("nails"));
            assertEquals(6, hashTable.hash("tile"));
            assertEquals(6, hashTable.hash("lumber"));
        }
    }

    @Nested
    class SetGet {
        @Test
        void shouldAddNodeToEmptyTable() {
            HashTable hashTable = new HashTable();

            hashTable.set("screws", 2);

            assertEquals(2, hashTable.get("screws"));
        }

        @Test
        void shouldAddNodeToExistingTable() {
            HashTable hashTable = new HashTable();
            hashTable.set("screws", 2);

            hashTable.set("bolts", 15);

            assertEquals(2, hashTable.get("screws"));
            assertEquals(15, hashTable.get("bolts"));
        }

        @Test
        void shouldAddNodeToExistingListOfTableWhenHashMatches() {
            HashTable hashTable = new HashTable();
            hashTable.set("screws", 2);
            hashTable.set("bolts", 15);
            hashTable.set("nails", 5);
            hashTable.set("tile", 27);

            hashTable.set("lumber", 82);


            assertEquals(2, hashTable.get("screws"));
            assertEquals(15, hashTable.get("bolts"));
            assertEquals(5, hashTable.get("nails"));
            assertEquals(27, hashTable.get("tile"));
            assertEquals(82, hashTable.get("lumber"));

            hashTable.printTable();
        }

        @Test
        void shouldReturnZeroIfNodeIsNotPresent() {
            HashTable hashTable = new HashTable();

            assertEquals(0, hashTable.get("test"));
        }
    }

    @Nested
    class Keys {
        @Test
        void shouldReturnEmptyArrayWhenTableIsEmpty() {
            HashTable hashTable = new HashTable();

            assertEquals(new ArrayList<String>(), hashTable.keys());
        }

        @Test
        void shouldReturnAllKeys() {
            HashTable hashTable = new HashTable();
            hashTable.set("screws", 2);
            hashTable.set("bolts", 15);
            hashTable.set("nails", 5);
            hashTable.set("tile", 27);
            hashTable.set("lumber", 82);

            assertEquals(List.of("screws", "bolts", "nails", "tile", "lumber"), hashTable.keys());
        }
    }

    @Nested
    class ItemInCommon {
        @Test
        void shouldReturnTrueIfThereIsCommonItem() {
            int[] array1 = new int[]{1, 3, 5};
            int[] array2 = new int[]{2, 4, 5};

            assertTrue(HashTable.itemInCommon(array1, array2));
        }

        @Test
        void shouldReturnFalseIfThereIsNoCommonItem() {
            int[] array1 = new int[]{1, 3, 5};
            int[] array2 = new int[]{2, 4, 6};

            assertFalse(HashTable.itemInCommon(array1, array2));
        }
    }

    @Nested
    class FindDuplicates {
        @Test
        void shouldReturnEmptyListForEmptyList() {
            assertEquals(List.of(), HashTable.findDuplicates(new int[]{}));
        }

        @Test
        void shouldReturnEmptyListWhenThereAreNoDuplicates() {
            assertEquals(List.of(), HashTable.findDuplicates(new int[]{1, 2, 3, 4, 5}));
        }

        @Test
        void shouldReturnDuplicatesValues() {
            assertEquals(List.of(2, 3), HashTable.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        }

        @Test
        void shouldReturnDuplicatedValueWhenAllAreDuplicates() {
            assertEquals(List.of(3), HashTable.findDuplicates(new int[]{3, 3, 3, 3, 3}));
        }

        @Test
        void shouldReturnDuplicatedValueWhenValuesDuplicatedMultipleTimes() {
            assertEquals(List.of(-1, 0, 2), HashTable.findDuplicates(new int[]{-1, 0, 1, 0, -1, -1, 2, 2}));
        }
    }

    @Nested
    class FirstNonRepeatingChar {
        @Test
        void shouldReturnFirstNonRepeatingCharacter() {
            assertEquals('l', HashTable.firstNonRepeatingChar("leetcode"));
        }

        @Test
        void shouldReturnNullForEmptyString() {
            assertNull(HashTable.firstNonRepeatingChar(""));
        }

        @Test
        void shouldReturnNullForAllDuplicates() {
            assertNull(HashTable.firstNonRepeatingChar("aabbcc"));
        }

        @Test
        void shouldReturnNullForAllRepeating() {
            assertNull(HashTable.firstNonRepeatingChar("aaaaa"));
        }

        @Test
        void shouldReturnNonDuplicateForOfMixedCases() {
            assertEquals('A', HashTable.firstNonRepeatingChar("AaBb"));
        }

        @Test
        void shouldReturnNonDuplicateForOfMixedSymbols() {
            assertEquals('!', HashTable.firstNonRepeatingChar("!aaBb"));
        }

        @Test
        void shouldReturnNonDuplicateForSingleLetter() {
            assertEquals('a', HashTable.firstNonRepeatingChar("a"));
        }
    }

    @Nested
    class GroupAnagrams {
        @Test
        void shouldReturnAnagramGroups() {
            assertEquals(
                    List.of(List.of("eat", "tea", "ate"), List.of("bat"), List.of("tan", "nat")),
                    HashTable.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})
            );
        }
    }

    @Nested
    class TwoSum {
        @Test
        void shouldReturnEmptyArrayWhenListIsEmpty() {
            assertArrayEquals(new int[]{}, HashTable.twoSum(new int[]{}, 0));
        }

        @Test
        void shouldReturnEmptyArrayWhenNoTwoElementFound() {
            assertArrayEquals(new int[]{}, HashTable.twoSum(new int[]{1, 2, 3, 4, 5}, 10));
        }

        @Test
        void shouldReturnIndicesForListOfTwoElements() {
            assertArrayEquals(new int[]{0, 1}, HashTable.twoSum(new int[]{3, 3}, 6));
        }

        @Test
        void shouldReturnIndicesForListOfThreeElements() {
            assertArrayEquals(new int[]{1, 2}, HashTable.twoSum(new int[]{3, 2, 4}, 6));
        }

        @Test
        void shouldReturnIndicesForListOfMultipleElements() {
            assertArrayEquals(new int[]{0, 1}, HashTable.twoSum(new int[]{2, 7, 11, 15}, 9));
        }
    }

    @Nested
    class SubarraySum {
        @Test
        void shouldReturnEmptyArrayForEmptyList() {
            assertArrayEquals(new int[]{}, HashTable.subarraySum(new int[]{}, 0));
        }

        @Test
        void shouldReturnIndicesOfSubArray() {
            assertArrayEquals(new int[]{1, 3}, HashTable.subarraySum(new int[]{1, 2, 3, 4, 5}, 9));
        }

        @Test
        void shouldReturnIndicesOfSubArrayWhenSumIsSingleNumber() {
            assertArrayEquals(new int[]{1, 1}, HashTable.subarraySum(new int[]{2, 3, 4, 5, 6}, 3));
        }

        @Test
        void shouldReturnIndicesOfSubArrayWhenArrayHasNegativeNumbers() {
            assertArrayEquals(new int[]{0, 3}, HashTable.subarraySum(new int[]{-1, 2, 3, -4, 5}, 0));
        }
    }

    @Nested
    class LongestConsecutiveSequence {
        @Test
        void shouldReturnLengthOfLongestConsecutiveSequence() {
            assertEquals(5, HashTable.longestConsecutiveSequence(new int[] {1, 2, 3, 4, 5}));
            assertEquals(1, HashTable.longestConsecutiveSequence(new int[] {1, 3, 5, 7, 9}));
            assertEquals(4, HashTable.longestConsecutiveSequence(new int[] {1, 2, 2, 3, 4}));
            assertEquals(5, HashTable.longestConsecutiveSequence(new int[] {1, 0, -1, -2, -3}));
            assertEquals(0, HashTable.longestConsecutiveSequence(new int[] {}));
            assertEquals(4, HashTable.longestConsecutiveSequence(new int[] {1, 2, 3, 10, 11, 12, 13}));
            assertEquals(5, HashTable.longestConsecutiveSequence(new int[] {5, 1, 3, 4, 2}));
            assertEquals(1, HashTable.longestConsecutiveSequence(new int[] {1}));
            assertEquals(1, HashTable.longestConsecutiveSequence(new int[] {2, 2, 2, 2, 2}));
        }
    }
}