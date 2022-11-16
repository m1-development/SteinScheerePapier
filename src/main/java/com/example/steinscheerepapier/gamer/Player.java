package com.example.steinscheerepapier.gamer;

import java.util.Random;

import com.example.steinscheerepapier.common.Symbol;

public class Player {

   Symbol getConstantPaperSymbol() {
      return Symbol.PAPER;
   }

   public int getRandomIntNumber(int min, int max) {
      return new Random().ints(min, max)
            .findFirst()
            .orElseThrow();
   }

   Symbol getRandomSymbol() {
      int randomIntNumber = getRandomIntNumber(0, 2);
      return Symbol.values()[randomIntNumber];
   }

}
