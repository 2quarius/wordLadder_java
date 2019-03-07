# Word Ladder


### Introduction
A ***word ladder*** is a connection from one word to another formed by changing one letter at a time with the constraint that at each step the sequence of letters still forms a **valid** word.
>For example, here is a word ladder connecting "code" to "data"   
>&emsp;&emsp;code -> core -> care -> dare -> date -> data
That word ladder, however, is not the shortest possible one. Although the words may be a little less familiar, the following ladder is one step shorter:   
&emsp;&emsp;code -> cade -> cate -> date -> data
### Implementation
**My job in this problem is to write a program that finds a minimal word ladder between two words.** My code will make use of several of Java standard library, along with breadth-first search algorithm to find the shortest such sequence.
