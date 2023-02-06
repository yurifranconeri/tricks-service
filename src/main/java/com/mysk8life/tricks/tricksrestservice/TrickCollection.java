package com.mysk8life.tricks.tricksrestservice;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Getter
@Builder
public class TrickCollection {
    @Singular private List<Trick> tricks;
}
