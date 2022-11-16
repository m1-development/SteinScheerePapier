package com.example.steinscheerepapier.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.steinscheerepapier.common.Symbol;

class PlayerTest {

   private static Player player = null;

   @BeforeEach
   void setUp() {
      player = spy(new Player());
   }
   
   @Test
   void getConstantPaperSymbolShouldReturnConstantPaperSymbol() {
      // given

      // when
      Symbol symbol = player.getConstantPaperSymbol();

      // then
      assertEquals(Symbol.PAPER, symbol);
   }

   @ParameterizedTest
   @MethodSource("getValuePairs")
   void getRandomSymbolShouldReturnCorrectSymbolForIntValue(int value, Symbol expectedSymbol) {
      doReturn(value).when(player).getRandomIntNumber(anyInt(), anyInt());

      // when
      Symbol symbol = player.getRandomSymbol();

      // then
      assertEquals(expectedSymbol, symbol);
   }

   private static Stream<Arguments> getValuePairs() {
      return Stream.of(
            arguments(0, Symbol.STONE),
            arguments(1, Symbol.SCISSOR),
            arguments(2, Symbol.PAPER)
      );
   }

   @Test()
   void getRandomIntNumberShouldThrowExceptionForValue3() {
      // given
      doReturn(3).when(player).getRandomIntNumber(anyInt(), anyInt());

      // when
      // then
      assertThrows(ArrayIndexOutOfBoundsException.class, () -> player.getRandomSymbol());
   }
}