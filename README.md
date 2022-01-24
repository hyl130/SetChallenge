# SET Challenge

The program takes the input through **standard input** and will contain an integer N, followed by a list of N distinct SET cards, one per line.
SET is played with a special deck of cards. Each card has four attributes:
1. Color -- one of the words “blue”, “green”, or “yellow”
2. Symbol -- the three symbols will be represented by the letters A, S, and H
3. Shading -- the shading of the symbols will be represented by the case of the letter: one of
lower-case (a,s,h), upper-case (A, S, H), or "symbol-case" (@, $, #)
4. Number -- the letter will appear one, two, or three times

The program’s output consists of:
1. A single line containing the number of possible SETs of three cards in the input.
2. A single line containing the number of disjoint SETs in the input.
3. The cards forming a largest collection of disjoint SETs.

## How to run?

To compile,
``
$ javac Set.java
``

To run,
``
$ cat inputFileName.txt | java Set
``
