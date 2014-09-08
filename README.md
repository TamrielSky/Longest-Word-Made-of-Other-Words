Longest-Word-Made-of-Other-Words
================================

Longest Word Made of Other Words using a trie 

Problem Statement
a program that reads a file containing a sorted list of words (one word per line, no
spaces, all lower case), then identifies the

1. 1st longest word in the file that can be constructed by concatenating copies of shorter words also found in the file.
2. The program should then go on to report the 2nd longest word found 
3. Total count of how many of the words in the list can be constructed
   of other words in the list.


import the folder into eclipse and run the code
 
 
A few points I would like to mention regarding the approach I took to solve this :

1. I have used a Trie data structure to store the words after reading them from the file.
2. I also maintain a HashMap as a part of the Trie (populated during construction of the Trie) which stores the word parsed as Key and the list of prefixes that word has in the Trie as value. 
3. A Queue is maintained to store the word parsed and its equivalent suffix(created by removing the prefix from the word which the hashmap maintains) If there are multiple prefixes in HashMap for same word, 2 corresponding suffixes are stored for that word in the Queue. 
4. Now we pop elements out of the Queue and keep checking if the suffix is present in the Trie. If it is present then we consider it as a compound word. If not then we again check if same word has a prefix and if there is a prefix we insert the suffix and the word in the Queue.
