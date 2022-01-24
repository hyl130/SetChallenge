/*
 * File Name: Set.java
 * Description: This program takes an input of cards and outputs the set
 * Author: Hyunjo Lee (lhjoelee@gmail.edu)
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Set {
   /*
    * Class Name: Cards
    * Description: stores card's information to this obejct
    */
   static class Card{
      int color; //1 for green, 2 for yellow, 4 for blue
      int symbol; // A is 1, S is 2, H is 4 for each symbol
      int shading; // lowercase is 1, uppercase is 2, symbol is 4
      int number; // how many times the letter appears 1, 2 or 3 (3 will be represented as 4)
      boolean used;

      public Card(){
         color = 0;
         symbol = 0;
         shading = 0;
         number = 0;
         used = false;
      }

      /**
       * returns true if cards are a set
       * returns false otherwise
       */
      public static boolean compareCard(Card card1, Card card2, Card card3) {
         if( compareAttribute(card1.color, card2.color, card3.color) ){
            if( compareAttribute(card1.symbol, card2.symbol, card3.symbol) ){
               if( compareAttribute(card1.shading, card2.shading, card3.shading) ){
                  if( compareAttribute(card1.number, card2.number, card3.number) ){
                     return true;
                  }
               }
            }
         }
         return false;
      }

      /**
       * returns true if three cards have a same attribute or different attributes
       * returns false otherwise
       */
      private static boolean compareAttribute(int attribute1, int attribute2, int attribute3){
         int resultingBit = (attribute1 | attribute2) ^ attribute3;
         if(resultingBit == 0 || resultingBit == 7){
            return true;
         }
         return false;
      }
   }
   public static void main (String[] args) {
      // read from standard input
      Scanner scanner = new Scanner(System.in);
      int numOfElements = Integer.valueOf(scanner.nextLine());
      String currLine = "";
      Card[] cardsTable = new Card[numOfElements];
      int nthCard = 0;
      String[] cardInformation = new String[numOfElements];
      // store standard input's information to the card object
      while(scanner.hasNext()){
         Card currCard = new Card();
         currLine = scanner.nextLine();
         String arr[] = currLine.split(" ");

         //arr[0] is the card's color and will save this information to the Card object
         if(arr[0].equals("green")){
            currCard.color = 1;
         }
         else if(arr[0].equals("yellow")){
            currCard.color = 2;
         }
         else if(arr[0].equals("blue")){
            currCard.color = 4;
         }
         
         //arr[1] is the card's symbol and will save this information to the Card object
         if(arr[1].charAt(0) == '@'){
            currCard.symbol = 1;
            currCard.shading = 4;
         }
         else if(arr[1].charAt(0) == '$'){
            currCard.symbol = 2;
            currCard.shading = 4;
         }
         else if(arr[1].charAt(0) == '#'){
            currCard.symbol = 4;
            currCard.shading = 4;
         }

         if(arr[1].charAt(0) == 'A'){
            currCard.symbol = 1;
            currCard.shading = 2;
         }
         else if(arr[1].charAt(0) == 'S'){
            currCard.symbol = 2;
            currCard.shading = 2;
         }
         else if(arr[1].charAt(0) == 'H'){
            currCard.symbol = 4;
            currCard.shading = 2;
         }

         if(arr[1].charAt(0) == 'a'){
            currCard.symbol = 1;
            currCard.shading = 1;
         }
         else if(arr[1].charAt(0) == 's'){
            currCard.symbol = 2;
            currCard.shading = 1;
         }
         else if(arr[1].charAt(0) == 'h'){
            currCard.symbol = 4;
            currCard.shading = 1;
         }

         if(arr[1].length() == 1){
            currCard.number = 1;
         }
         else if(arr[1].length() == 2){
            currCard.number = 2;
         }
         else if(arr[1].length() == 3){
            currCard.number = 4;
         }

         cardsTable[nthCard] = currCard;
         cardInformation[nthCard] = currLine;
         nthCard++;
      }
      scanner.close();

      // go through the card table to check
      int possibleSets = 0;
      int disjoint=0;
      ArrayList<String> disjointSets = new ArrayList<String>();
      for(int i = 0; i < cardsTable.length; i++){
         for(int j = i+1; j < cardsTable.length; j++){
            for(int k = j+1; k < cardsTable.length; k++){
               // if we are looking at the same card, we would skip
               if(i == j || i == k || j == k ){
                  continue;
               }

               //if three cards make a set
               if(Card.compareCard(cardsTable[i], cardsTable[j], cardsTable[k])){
                  // if they have not been used, we would add to the disjoint set
                  if(cardsTable[i].used == false && cardsTable[j].used==false && cardsTable[k].used == false){
                     cardsTable[i].used = true;
                     cardsTable[j].used = true;
                     cardsTable[k].used = true;
                     disjointSets.add(cardInformation[i]);
                     disjointSets.add(cardInformation[j]);
                     disjointSets.add(cardInformation[k]);
                     disjointSets.add(" ");
                     disjoint++;
                  } 
                  possibleSets++;
              }
         
            }
         }
      }

      // A single line containing the number of possible SETs of three cards in the input.
      System.out.println(possibleSets);
      // A single line containing the number of disjoint SETs in the input.
      System.out.println(disjoint);
      System.out.println();
      //The cards forming a largest collection of disjoint SETs
      for(int i = 0; i < disjointSets.size(); i++){
         System.out.println(disjointSets.get(i));
      }
   }
}
