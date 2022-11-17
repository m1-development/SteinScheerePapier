package com.example.steinscheerepapier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.steinscheerepapier.game.Game;

@SpringBootApplication
public class SteinScheerePapierApplication implements CommandLineRunner {

   private static final Logger LOG = LoggerFactory.getLogger(SteinScheerePapierApplication.class);

   public static void main(String[] args) {
      SpringApplication.run(SteinScheerePapierApplication.class, args);
   }

   @Override
   public void run(String... args) throws Exception {
      /*
       * Stein-Scheere-Papier Challenge
       * - Zwei Computerspieler A und B spielen 100 mal gegeneinander
       * - Spieler A spielt zufällig eines der Symbole Stein, Scheere oder Papier
       * - Spieler B spielt konstant mit dem Symbol Papier
       * - Beide Spieler werden vom Programm ohne Nutzereingabe "gespielt"
       * - Das Ergebnis wird am Ende aller Runden auf der Console ausgegeben
       */
      LOG.info("Running game 'stone scissor paper'");
      Game game = new Game();
      game.play();
      LOG.info(String.format("Results: Winner A: %s, Tied: %s, Winner B: %s", game.getWinnerA(), game.getTied(), game.getWinnerB()));
   }
}
