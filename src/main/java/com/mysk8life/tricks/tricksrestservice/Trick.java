package com.mysk8life.tricks.tricksrestservice;

import lombok.Builder;
import lombok.Getter;
import java.util.Set;

@Getter
@Builder
public class Trick {
    private String name;

    private Difficulty difficulty;

    private Set<Stance> stances;

    private Category category;
}
