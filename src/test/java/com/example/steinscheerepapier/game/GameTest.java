package com.example.steinscheerepapier.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.steinscheerepapier.common.Symbol;

class GameTest {

   private Game game = null;

   @BeforeEach
   void setUp() {
      game = new Game();
   }

   @Test
   void playShouldHaveExpectedPlays() {
      // given
      int expectedTimesOfPlay = 100;

      // when
      game.play();

      // then
      assertEquals(expectedTimesOfPlay, game.getTied() + game.getWinnerA() + game.getWinnerB());
   }

   @Test
   void checkInitialCountValues() {
      // given

      // when
      // then
      assertEquals(0, game.getWinnerA());
      assertEquals(0, game.getTied());
      assertEquals(0, game.getWinnerB());
   }

   @Test
   void countResultsForWinnerA() {
      // given

      // when
      game.countResults(-1);

      // then
      assertEquals(1, game.getWinnerA());
      assertEquals(0, game.getTied());
      assertEquals(0, game.getWinnerB());
   }

   @Test
   void countResultsForTied() {
      // given

      // when
      game.countResults(0);

      // then
      assertEquals(0, game.getWinnerA());
      assertEquals(1, game.getTied());
      assertEquals(0, game.getWinnerB());
   }

   @Test
   void countResultsForWinnerB() {
      // given

      // when
      game.countResults(1);

      // then
      assertEquals(0, game.getWinnerA());
      assertEquals(0, game.getTied());
      assertEquals(1, game.getWinnerB());
   }

   @Test
   void countResultsForInvalidValueHasNoEffect() {
      // given

      // when
      game.countResults(2);

      // then
      assertEquals(0, game.getWinnerA());
      assertEquals(0, game.getTied());
      assertEquals(0, game.getWinnerB());
   }

   @ParameterizedTest
   @MethodSource("getValuePairs")
   void getRandomSymbolShouldReturnCorrectSymbolForIntValue(Symbol symbolPLayerA, Symbol symbolPLayerB, int expectedResult) {
      // given

      // when
      int result = game.checkResult(symbolPLayerA, symbolPLayerB);

      // then
      assertEquals(expectedResult, result);
   }

   private static Stream<Arguments> getValuePairs() {
      return Stream.of(
            arguments(Symbol.STONE, Symbol.STONE, 0),
            arguments(Symbol.SCISSOR, Symbol.SCISSOR, 0),
            arguments(Symbol.PAPER, Symbol.PAPER, 0),

            arguments(Symbol.STONE, Symbol.SCISSOR, -1),
            arguments(Symbol.SCISSOR, Symbol.PAPER, -1),
            arguments(Symbol.PAPER, Symbol.STONE, -1),

            arguments(Symbol.STONE, Symbol.PAPER, 1),
            arguments(Symbol.SCISSOR, Symbol.STONE, 1),
            arguments(Symbol.PAPER, Symbol.SCISSOR, 1)
      );
   }
}