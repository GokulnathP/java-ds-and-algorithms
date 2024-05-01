package com.gokulnathp.datastractures;

import java.util.ArrayList;

public class StackArrayList<T> {
    private final ArrayList<T> stackList = new ArrayList<>();

    public T peek() {
        if(stackList.isEmpty()) return null;
        return stackList.get(stackList.size() - 1);
    }

    public void push(T value) {
        stackList.add(value);
    }

    public T pop() {
        if (stackList.isEmpty()) return null;

        return stackList.remove(stackList.size() - 1);
    }

    public T[] toArray() {
        return (T[]) stackList.toArray();
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public static String reverseString(String string) {
        StackArrayList<Character> characterStack = new StackArrayList<>();
        for (char letter : string.toCharArray()) characterStack.push(letter);

        StringBuilder stringBuilder = new StringBuilder();
        while (!characterStack.isEmpty()) stringBuilder.append(characterStack.pop());

        return stringBuilder.toString();
    }

    public static boolean isBalancedParentheses(String string) {
        StackArrayList<Character> characterStack = new StackArrayList<>();

        for (Character letter : string.toCharArray()) {
            if (letter == '(') characterStack.push(letter);
            else if (letter == ')') if (characterStack.isEmpty() || characterStack.pop() != '(') return false;
        }

        return characterStack.isEmpty();
    }

    public static void sortStack(StackArrayList<Integer> stack) {
        StackArrayList<Integer> sortedStack = new StackArrayList<>();

        while(!stack.isEmpty()) {
            int lastValue = stack.pop();

            while(!sortedStack.isEmpty() && lastValue < sortedStack.peek()) stack.push(sortedStack.pop());

            sortedStack.push(lastValue);
        }

        while(!sortedStack.isEmpty()) stack.push(sortedStack.pop());
    }
}
