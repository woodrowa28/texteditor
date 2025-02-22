# CSC 207: Text Editor

**Author**: Aubrey Woodrow

## Resources Used

+ TTAP: Data Structures—Lab Manual by Peter-Michael Osera
https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
Provided instructions for project
+ Java 8 String Documentation
https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
Referenced for usage of substring()
+ ...

## Simple String Buffer Analysis
Since strings are immutable, whenever we concatenate strings, java must manually copy
over every character in the string (and new char, in this case) and combine them into a new
string. This process is very inefficient because it means every time we want to add a single
character to our buffer, we must create an entirely new buffer to include it. No matter the
index of insertion, java must traverse original string and copy in the new character. If the 
cursor is at the beginning or end, the copy happens directly and the character is inserted
first or last (respectively). If index is in the middle, it must copy the first part of the
string, add the new character, and then finishing copying the string. In all, this results
in copying chars equal to the length + 1, giving us T(n) = n + 1 runtime.

1. Method input is length of string buffer
2. Critical operation will retrieving a character during string concatenation
3. T(n) = n + 1.
4. insert is O(n)

## Changelog

_(TODO: fill me in with a log of your committed changes)_
