package com.example.steinscheerepapier.game;

import com.example.steinscheerepapier.common.Symbol;

public class Game {

   private int winnerA = 0;
   private int tied = 0;
   private int winnerB = 0;

   public int getWinnerA() {
      return winnerA;
   }

   public int getTied() {
      return tied;
   }

   public int getWinnerB() {
      return winnerB;
   }

   public void play() {
      Player playerA = new Player();
      Player playerB = new Player();

      for (int i = 0; i < 100; i++) {
         int result = checkResult(playerA.getRandomSymbol(), playerB.getConstantPaperSymbol());
         countResults(result);
      }

   }

   void countResults(int result) {
      switch (result) {
         case -1:
            winnerA++;
            break;
         case 0:
            tied++;
            break;
         case 1:
            winnerB++;
            break;
         default:
            // do nothing
      }
   }

   int checkResult(Symbol symbolPLayerA, Symbol symbolPLayerB) {
      if (symbolPLayerA.equals(symbolPLayerB)) {
         return 0;
      }

      switch (symbolPLayerA) {
         case STONE:
            if (symbolPLayerB.equals(Symbol.PAPER)) {
               return 1;
            } else {
               return -1;
            }
         case SCISSOR:
            if (symbolPLayerB.equals(Symbol.STONE)) {
               return 1;
            } else {
               return -1;
            }
         case PAPER:
            if (symbolPLayerB.equals(Symbol.SCISSOR)) {
               return 1;
            } else {
               return -1;
            }
         default:
            throw new RuntimeException("received illegal symbol");
      }
   }
}
