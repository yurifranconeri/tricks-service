package com.mysk8life.tricks.tricksrestservice;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mysk8life.tricks.tricksrestservice.GroupedTricksCollection.GroupedTricksCollectionBuilder;

import lombok.extern.flogger.Flogger;

@Flogger
@Repository
public class TricksRepositoryInMemory implements TricksRepository {

        @Override
        public TrickCollection findAllTricks() {
                log.atFine().log("Returning all tricks in memory");
                return _tricks;
        }

        @Override
        public TrickCollection findTricksByStance(Stance stance) {
                log.atFine().log("Returning tricks filtered by stance [ %s ] in memory", stance);
                return new TrickCollection(
                                _tricks.getTricks().stream().filter(trick -> trick.getStances().contains(stance))
                                                .collect(Collectors.toList()));
        }

        @Override
        public TrickCollection findTricksByCategory(Category category) {
                log.atFine().log("Returning tricks filtered by category [ %s ] in memory", category);
                return new TrickCollection(
                                _tricks.getTricks().stream().filter(trick -> trick.getCategory().equals(category))
                                                .collect(Collectors.toList()));
        }

        @Override
        public TrickCollection findTricksByDifficulty(Difficulty difficulty) {
                log.atFine().log("Returning tricks filtered by difficulty [ %s ] in memory", difficulty);
                return new TrickCollection(
                                _tricks.getTricks().stream().filter(trick -> trick.getDifficulty().equals(difficulty))
                                                .collect(Collectors.toList()));
        }

        @Override
        public GroupedTricksCollection groupByCategory() {
                log.atFine().log("Returning tricks grouped by category in memory");
                GroupedTricksCollectionBuilder gtricksBuilder = GroupedTricksCollection.builder();

                _tricks.getTricks()
                                .stream()
                                .collect(Collectors.groupingBy(Trick::getCategory))
                                .forEach((k, v) -> gtricksBuilder
                                                .groupedTrick(k.name(), TrickCollection.builder().tricks(v).build())
                                                .build());

                return gtricksBuilder.build();
        }

        @Override
        public GroupedTricksCollection groupByDifficulty() {
                log.atFine().log("Returning tricks grouped by difficulty in memory");
                GroupedTricksCollectionBuilder gtricksBuilder = GroupedTricksCollection.builder();

                _tricks.getTricks()
                                .stream()
                                .collect(Collectors.groupingBy(Trick::getDifficulty))
                                .forEach((k, v) -> gtricksBuilder
                                                .groupedTrick(k.name(), TrickCollection.builder().tricks(v).build())
                                                .build());

                return gtricksBuilder.build();
        }

        @Override
        public EnumSet<Difficulty> findAllDifficulties() {
                log.atFine().log("Returning all difficulties in memory");
                return EnumSet.allOf(Difficulty.class);
        }

        @Override
        public EnumSet<Category> findAllCategories() {
                log.atFine().log("Returning all categories in memory");
                return EnumSet.allOf(Category.class);
        }

        @Override
        public EnumSet<Stance> findAllStances() {
                log.atFine().log("Returning all stances in memory");
                return EnumSet.allOf(Stance.class);
        }

        private static final TrickCollection _tricks = TrickCollection.builder()
                        .tricks(Arrays.asList(
                                        Trick.builder().name("Remar")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Parar")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Batida Backside")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Batida Frontside")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Tic Tac")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Crab Walk")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Parar com o tail")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Virar inclinando")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Girar 90 graus Backside")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Girar 180 graus Backside")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Girar 360 graus backside")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Girar 180 graus backside")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Girar 90 graus Frontside")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Girar 180 graus Frontside")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Girar 360 graus Frontside")
                                                        .difficulty(Difficulty.ONE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.RIDING)
                                                        .build(),
                                        Trick.builder().name("Popcorn")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.PREBASIC)
                                                        .build(),
                                        Trick.builder().name("Nose stall na calçada")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.PREBASIC)
                                                        .build(),
                                        Trick.builder().name("Caveman")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.PREBASIC)
                                                        .build(),
                                        Trick.builder().name("Descer a calçada")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.PREBASIC)
                                                        .build(),
                                        Trick.builder().name("Subir um bank")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.PREBASIC)
                                                        .build(),
                                        Trick.builder().name("Descer um bank")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.PREBASIC)
                                                        .build(),
                                        Trick.builder().name("Body varial")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.PREBASIC)
                                                        .build(),
                                        Trick.builder().name("Rolling in no bank")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.PREBASIC)
                                                        .build(),
                                        Trick.builder().name("Batida Backside no bank")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.PREBASIC)
                                                        .build(),
                                        Trick.builder().name("Batida Frontside no bank")
                                                        .difficulty(Difficulty.TWO)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.PREBASIC)
                                                        .build(),
                                        Trick.builder().name("Shove it")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Ollie")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR, 
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Ollie em movimento")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Ollie sobre objeto")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Ollie descendo a calçada")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Ollie subindo a calçada")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Frontside 180")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Backside 180")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR, 
                                                                Stance.SWITCH, 
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Pop Shove It")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR, 
                                                                Stance.SWITCH, 
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Frontside Pop Shove It")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR, 
                                                                Stance.SWITCH, 
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Heelflip")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH, 
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Kickflip")
                                                        .difficulty(Difficulty.THREE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.BASIC)
                                                        .build(),
                                        Trick.builder().name("Ollie North")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Varial Kickflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Hardflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Varial Heelflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Inward Heelflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Backside 180 Heelflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Backside 180 Kickflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Frontside 180 Heelflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Frontside 180 Kickflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Backside Big Spin")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Frontside Big Spin")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("360 Pop Shove It")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("No Comply Finger Flip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("360 Flip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Ollie Backside Body Variaç")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Laser Flip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Backside 360 Ollie")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Frontside 360 Ollie")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Strawberry Milk Shake")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Frontside 360 Pop Shove It")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Frontside Pop Shove It Revert")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Wallie Parking Block")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Boneless Frontside 180")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Boneless Frontside 360")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Double Heelflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Heelflip Backside Body Varial")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Double Kickflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Heelflip Frontside Body Varial")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Kickflip Frontside Body Varial")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("No Comply Backside 180")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("No Comply Frontside 180")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("No Comply Frontside Pop Shove It")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("No Comply Backside Pop Shove It")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("No Comply Impossible")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Ollie Frontside Body Varial")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Pop Shove It Frontside Body Varial")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Pop Shove It Frontside Body Varial")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Pop Shove It Revert")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Pressure Flip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Pressure Hardflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Pressure Kickflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Kicklip Backside Body Varial")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Pressure Heelflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Straight Boneless")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Front Pop Shove It Backside Body Varial")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Ollie Impossible")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Straight No Comply")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.COMBOS)
                                                        .build(),
                                        Trick.builder().name("Varial Double Flip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Varial Double Heelflip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Backside Big Spin Kickflip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Frontside Big Spin Hellflip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Hospital Flip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("540 Pop Shove It")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Backside 360 Kickflip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Indy Grab")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Frontside 360 Heelflip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("No Comply Big Spin Heelflip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Melon Grab")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Mute Grab")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Nose Grab")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Roastbeef Grab")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Tails Grab")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Method Grab")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Stale Fish Grab")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Tuck Knee Grab")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Ollie Late Backside Shove")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Ollie Late Frontside Shove")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Ollie Late Heelflip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Ollie Late Kickflip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Pop Shove It Late Kickflip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Pop Shove It Under Flip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Front Pop Shove It Late Flip")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Benihana Grab")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Varial Kickflip Revert")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Varial Flip Frontside Body Varial")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("360 Flip Revert")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("Laser Flip Revert")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.PRO)
                                                        .build(),
                                        Trick.builder().name("360 Hardflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("360 Inward Hellflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("360 Triple Flip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Alpha Flip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Backside 180 Double Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Backside 180 Double Kickflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Backside 360 Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Backside Big Spin Double Kickflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Backside Big Spin Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Beta Flip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Casper Flip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Dolphin Flip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Dragon Flip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Front Pop Shove It Late Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Frontside 180 Double Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Frontside 180 Double Kickflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Frontside Big Spin Double Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Frontside Big Spin Kickflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Gazelle Hellflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Gazelle Kickflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Gazelle Shove It")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Hard Double Flip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Hardflip Revert")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Heelflip Late Back Shove")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Heelflip Late Front Shove")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Impossible Late Flip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Inward 360 Double Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Inward Double Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Inward Heelflip Revert")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Kickflip Late Front Shove")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Kickflip Late Back Shove")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Kickflip Underflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Late Varial Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Lazer Double Heel")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Monster Flip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Pop Shove It Late Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Pop Shove Late Front Shove")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Front Pop Shove Late Back Shove")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Triple Heelflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Triple Kickflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("360 Double FLip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Frontside 360 Kickflip")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.SKATEGOD)
                                                        .build(),
                                        Trick.builder().name("Varial Heelflip Revert")
                                                        .difficulty(Difficulty.SIX)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside boardslide ledge")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside boardslide ledge")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside 50-50 Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside 50-50 Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside 5-0 Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside 5-0 Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Nosegrind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Nosegrind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Noseslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Nodeslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Tailslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Tailslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Crooked Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Crooked Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Bluntslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Bluntslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Noseblunt")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Willie Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Willie Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Nose Bluntslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Kickflip Darkslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Kickflip Darkslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Heelflip Darkslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Heelflip Darkslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Primo Slide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Boardslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Boardslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside 5050")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside 5050")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside 5-0 Rail")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside 5-0 Rail")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Feeble Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Nosegrind Rail")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Nosegrind Rail")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Feeble Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Noseslide Rail")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Hurricane Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Over Crook Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Noseslide")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Tailslide Rail")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Tailslide Rail")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Crooked Grind Rail")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Crooked Grind Rail")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Smith Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Backside Smith Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Hurricane Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.LEDGES)
                                                        .build(),
                                        Trick.builder().name("Frontside Over Crooked Grind")
                                                        .difficulty(Difficulty.FIVE)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Manual")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Nose Manual")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Manual Frontside 180")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Manual Backside 180")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Nose Manual Frontside 180")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Nose Manual Backside 180")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Manual Pop Shove It")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Manual Frontside Pop Shove It")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Nose Manual Frontside Shove It")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Nose Manual Shove It")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Pop Shove It Manual")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Pop Shove It Nose Manual")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Front Pop Shove It Manual")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Front Pop Shove It Nose Manual")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Kickflip Manual")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Kickflip Nose Manual")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Heelflip Manual")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Heelflip Nose Manual")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Manual Kickflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Manual Heelflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Nose Manual Nollie Kickflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Nose Manual Nollie Heelflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MANUALS)
                                                        .build(),
                                        Trick.builder().name("Monster Walk Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Tic Tac Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Walk the Dog Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.FAKIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Switchblade Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Heelside Rail Stand Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Yo Yo Plant Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Toeside Rail Stand Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Casper Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Truck Stand Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Bebop Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Coconut Wheelie Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Handflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Old School Kickflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Yo Ho Plant Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Helipop Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Nose Hook Impossible Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Pogo Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Saran Wrap/Wrap Around Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Smoothie Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Spacewalk Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Backside Tail Spins Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("G Turn Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Rennagade Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Backside M-80 Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Board Walks \"Partial End-Overs\" Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Flamingo \"One Foot Backwards Carve\" Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("No Handed Pogo Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Ollie Fingerflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Rail Whip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Gingersnap Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Mroz Twist Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Rail Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Rail Impossible Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Rail Roll Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Rail Stand Toe Spin Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Rolling Varial Fingerflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Walk the Cow Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("English Wheelie Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Stationary Fingerflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Truck 1.5 Flip Out Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("End-Over Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("English 1 Wheel Wheelie Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Freestyle Kickflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Gymnast Plant Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Stationary End-Overs Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Street Plant Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Swedish Wheelie Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Forward Spacewalk Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),                
                                        Trick.builder().name("Frontside M-80 Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Ollie Airwalk Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(), 
                                        Trick.builder().name("Rail Flip To Rail Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Varial Freestyle Kickflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Varial Rail Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Handstand Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Scarewalk Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Cooper Stance Rail Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Daffy Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Frontside Tail Spins Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("No Handed Truck Stand Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Switchfoot Pogo Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Truck Varial Flip Out Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("360 Freestyle Kickflip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("360 Rail Flip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Carousel Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Casper Disaster Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Fan Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Hang Ten Wheelie Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Haward Hop Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Hazze Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.FAKIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("No Handed Fan Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("Nosehook Impossible Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("One Footed Spin Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                       Trick.builder().name("TV Stand Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Varial Double Rail Flip")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.FAKIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Cross Footed Pogo Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Hand 10 Spins Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Rolling 360 Fingerflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Stationary Spacewalk Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Jaw Breaker Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("One Foot Pivot Frontside Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Rolling Fingerflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("San Francisco Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Butter Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Kickback Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Stationary Varial Fingerflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Betti Boop Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("360 Stationary Fingerflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Arm Vein Flip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Ollie Varial Fingerflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Sidewinder Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Calf Wrap Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Rail Handstand Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Broken Fingers Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Ollie 360 Fingerflip Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("One Foot Pivot Backside Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Boulder Holder Freestyle")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.FREESTYLE)
                                                        .build(),
                                        Trick.builder().name("Pumping")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Drop In Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Rock to Fakie Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Rock and Roll Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Tail Stall Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Backside slash")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Nose Stall Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(Stance.REGULAR))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Backside Axle Stall Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Frontside Axle Stall Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Backside Feeble Stall Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Backside Disaster")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Frontside Disaster")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Backside Air Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Frontside Air Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Frontside 360 Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Frontside Feeble Stall Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Blunt to Fakie Ramp")
                                                        .difficulty(Difficulty.FOUR)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.MINIRAMP)
                                                        .build(),
                                        Trick.builder().name("Pumping on Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Drop in Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Backside Slash")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Frontside Slash")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Fakie Ollie Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(Stance.FAKIE))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Rock to Fakie Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Rock and Roll Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Backside Air Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Frontside Air Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Backside 540 Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Frontside 540 Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Backside 720 Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Frontside 720 Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.VERTRAMP)
                                                        .build(),
                                        Trick.builder().name("Backside 900 Vert")
                                                        .difficulty(Difficulty.SEVEN)
                                                        .stances(EnumSet.of(
                                                                Stance.REGULAR,
                                                                Stance.SWITCH,
                                                                Stance.FAKIE,
                                                                Stance.NOLLIE))
                                                        .category(Category.VERTRAMP)
                                                        .build()
                                                        )

                        ).build();
}
