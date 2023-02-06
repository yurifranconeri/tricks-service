package com.mysk8life.tricks.tricksrestservice;

public enum Stance {
    REGULAR, SWITCH, FAKIE, NOLLIE;

    public static boolean isPresent(String stance) {
        if (stance == null || stance.isEmpty() || stance.isBlank()) {
            return false;
        }

        for (Stance enumValue : Stance.values()) {
            if (stance.equalsIgnoreCase(enumValue.name())) {
                return true;
            }
        }

        return false;
    }
}
