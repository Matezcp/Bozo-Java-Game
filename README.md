# Bozo-Java-Game
Bozo is game that you roll 5 dices of 6 sides and you have many ways of make points.  
You have this board:
 (1)    |   (7)    |   (4)   
 +--------------------------+  
 (2)    |   (8)    |   (5)   
 +--------------------------+  
 (3)    |   (9)    |   (6)   
 +--------------------------+  
        |   (10)   |  
        +----------+   
          
Each position is a way of make points, when you full a position you cannot put another point in that position again.  
Points in each position:  
1: Number of dice that rolls 1  
2: Number of dice that rolls 2 * 2  
3: Number of dice that rolls 3 * 3  
4: Number of dice that rolls 4 * 4  
5: Number of dice that rolls 5 * 5  
6: Number of dice that rolls 6 * 6  
7: Has 2 equal numbers and 3 others equals, example: 1 2 2 1 2, always 15 points  
8: Has a sequence, always 20 points  
9: Has 4 equal numbers, always 30 points  
10: Has all the dices equals, always 40 points  
  
In the case you put you play in position 7,8,9 or 10 and the dices does not meet the requirements, it will score 0 points in that position  
  
The game has 10 rounds, in each round you must put you play in a position.
