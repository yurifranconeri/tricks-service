package com.mysk8life.tricks.tricksrestservice;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Builder
@Getter
public class GroupedTricksCollection {
    @Singular Map<String, TrickCollection> groupedTricks;
}
