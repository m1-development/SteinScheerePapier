package com.example.steinscheerepapier.gamer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.steinscheerepapier.common.Symbol;

class PlayerTest {

   @Test
   void getConstantPaperSymbolShouldReturnConstantPaperSymbol() {
      // given
      Player player = new Player();

      // when
      Symbol symbol = player.getConstantPaperSymbol();

      // then
      assertEquals(Symbol.PAPER, symbol);
   }

   @ParameterizedTest
   @MethodSource("getValuePairs")
   void getRandomSymbolShouldReturnCorrectSymbolForIntValue(int value, Symbol expectedSymbol) {
      Player player = spy(new Player());
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
      Player player = spy(new Player());
      doReturn(3).when(player).getRandomIntNumber(anyInt(), anyInt());

      // when
      assertThrows(ArrayIndexOutOfBoundsException.class, () -> player.getRandomSymbol());

      // then
   }
}