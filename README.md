# Rook vs Bishop

A Spring Boot Application which runs through a single game of Rook-Vs-Bishop.

## Game Explanation

The white bishop remains on square c3 throughout the entirety of the game, and the black rook tries to survive 15 turns
without landing in the white bishop's line of fire. If the rook survives 15 rounds or lands on square c3, then he wins;
otherwise the white bishop wins. Each of the rook's moves are determined by the flipping of a coin and sum of numbers on
two rolled die.

## What you need

- Gradle
- JRE

## Instructions

First build the jar file:

`./gradlew build`

Then run the jar file:

`java -jar build/libs/rookvbishop-0.0.1-SNAPSHOT.jar`

The program automatically runs through the entire game and you can read through the results that have been printed on
the console.

