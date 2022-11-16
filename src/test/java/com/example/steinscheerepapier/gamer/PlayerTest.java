package com.example.steinscheerepapier.gamer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.steinscheerepapier.common.Symbol;

class PlayerTest {

   @Test
   void getConstantPaperSymbolShouldReturnConstantPaperSymbol() {
      // given
      Player player = new Player();

      // when
      Symbol symbol = player.getConstantPaperSymbol();

      // then
      assertEquals(Symbol.Paper, symbol);
   }
}