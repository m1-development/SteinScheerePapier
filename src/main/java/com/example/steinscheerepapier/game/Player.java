package com.example.steinscheerepapier.game;

import java.util.Random;

import com.example.steinscheerepapier.common.Symbol;

public class Player {

   Symbol getConstantPaperSymbol() {
      return Symbol.PAPER;
   }

   public int getRandomIntNumber(int min, int max) {
      return new Random().ints(min, max + 1)
            .findFirst()
            .orElseThrow();
   }

   Symbol getRandomSymbol() {
      int randomIntNumber = getRandomIntNumber(0, 2);
      return Symbol.values()[randomIntNumber];
   }

}
