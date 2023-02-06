package com.mysk8life.tricks.tricksrestservice;

public enum Difficulty {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT;

    public static boolean isPresent(String difficulty) {
        if (difficulty == null || difficulty.isEmpty() || difficulty.isBlank()) {
            return false;
        }

        for (Difficulty enumValue : Difficulty.values()) {
            if (difficulty.equalsIgnoreCase(enumValue.name())) {
                return true;
            }
        }

        return false;
    }
}
