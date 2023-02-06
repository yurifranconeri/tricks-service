package com.mysk8life.tricks.tricksrestservice;

public enum Group {
    CATEGORY, DIFFICULTY;

    public static boolean isPresent(String group) {
        if (group == null || group.isEmpty() || group.isBlank()) {
            return false;
        }

        for (Group enumValue : Group.values()) {
            if (group.equalsIgnoreCase(enumValue.name())) {
                return true;
            }
        }

        return false;
    }
}
