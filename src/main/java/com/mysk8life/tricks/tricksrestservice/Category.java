package com.mysk8life.tricks.tricksrestservice;

public enum Category {
    RIDING, PREBASIC, BASIC, COMBOS, PRO, SKATEGOD, LEDGES, RAILS, MANUALS, FREESTYLE, MINIRAMP, VERTRAMP;

    public static boolean isPresent(String category) {
        if (category == null || category.isEmpty() || category.isBlank()) {
            return false;
        }

        for (Category enumValue : Category.values()) {
            if (category.equalsIgnoreCase(enumValue.name())) {
                return true;
            }
        }
        
        return false;
    }
}
