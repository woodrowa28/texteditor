# CSC 207: Text Editor

**Author**: Aubrey Woodrow

## Resources Used

+ Code constructed with JDK23 using Apache NetBeans 22 and 24
+ TTAP: Data Structures—Lab Manual by Peter-Michael Osera
    https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
    Provided instructions for project
+ Java 8 String Documentation
    https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
    Referenced for usage of substring()
+ Lanterna API Documentation
    https://mabe02.github.io/lanterna/apidocs/3.0/com/googlecode/lanterna/screen/Screen.html 
    Used to troubleshoot the refresh() method


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

commit c5f7566fadf5dc165f976be5a31a10d7d5b942fc (HEAD -> main)                                                                                                                
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                                
Date:   Sun Feb 23 02:56:52 2025 +0000                                                                                                                                        
                                                                                                                                                                              
    Fixed minor style issue                                                                                                                                                   
                                                                                                                                                                              
commit bfac868740c86ea3b38b0605da68c75b9a366f39 (origin/main)                                                                                                                 
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                                
Date:   Sat Feb 22 20:53:08 2025 -0600                                                                                                                                        
                                                                                                                                                                              
    README final edits and acknowledgements

commit 0eac69bdd5cc7ec5cd45b4346a0d1bfcb0ac2703 (HEAD -> main, origin/main)
Author: Aubrey Woodrow <woodrowa@grinnell.edu>
Date:   Sat Feb 22 20:46:32 2025 -0600

    Fixed execution bugs and added javadocs to main file

commit 04c0197b54935b1563972d1337ab00423b302278                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Sun Feb 23 02:23:21 2025 +0000                                                                                                                        
                                                                                                                                                              
    Fleshed out main function, added file utilities                                                                                                           
                                                                                                                                                              
commit 2650bb245183847ea2e71d30c858027f9f1eaa4c                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Sun Feb 23 01:05:42 2025 +0000                                                                                                                        
                                                                                                                                                              
    Basic program loop in main                                                                                                                                
                                                                                                                                                              
commit a8743a95d3bbbaa528a9546db0ecf651e25f33e1                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Sat Feb 22 23:56:16 2025 +0000                                                                                                                        
                                                                                                                                                              
    Copied and expanded tests for gap buffer testing, added javadoc comments for gap buffer methods                                                           
                                                                                                                                                              
commit a9bacafa3cd3cdd338c3d2e7196ec5c0abc10c77                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Sat Feb 22 22:26:22 2025 +0000                                                                                                                        
                                                                                                                                                              
    Added movement and getter methods to gap buffer                                                                                                           
                                                                                                                                                              
commit d0424fd94f09e50551076eb8f218f537cf87d040                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Sat Feb 22 21:48:42 2025 +0000                                                                                                                        
                                                                                                                                                              
    Added insert and delete for the gap buffer                                                                                                                
                                                                                                                                                              
commit 6839e922ea6bec6643e9f73e8618f061dc9790fb                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Sat Feb 22 20:58:16 2025 +0000                                                                                                                        
                                                                                                                                                              
    Explained string buffer's runtime in README                                                                                                               
                                                                                                                                                              
commit 09157a0c7d1e2775689c6e2f524c4bd3c120dd2e                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Sat Feb 22 20:33:30 2025 +0000                                                                                                                        
                                                                                                                                                              
    Built testing suite for basic buffer                                                                                                                      
                                                                                                                                                              
commit e5d66a80ffd24367f98a397664ae421325b6f2c9                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Thu Feb 20 19:25:13 2025 -0600                                                                                                                        
                                                                                                                                                              
    mathlan test                                                                                                                                              
                                                                                                                                                              
commit 77f78b821a6e23ea2566ce068fcf438ef10e55de                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Fri Feb 21 00:55:58 2025 +0000                                                                                                                        
                                                                                                                                                              
    Basic main function to test lanterna                                                                                                                      
                                                                                                                                                              
commit fc55cc67258c7102b46d3e4bef9c53bf26bdab27                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Thu Feb 20 21:31:57 2025 +0000                                                                                                                        
                                                                                                                                                              
    Added movement and getter methods to the basic buffer                                                                                                     
                                                                                                                                                              
commit 70116ec986133feabcef4e56a90e359e40c29908                                                                                                               
Author: Aubrey Woodrow <woodrowa@grinnell.edu>                                                                                                                
Date:   Thu Feb 20 18:50:17 2025 +0000                                                                                                                        
                                                                                                                                                              
    Added constructor, insret, and delete to the basic buffer                                                                                                 
                                                                                                                                                              
commit 32a90495f40bd92ce905d4d78fbdab4dbaa6d5f9                                                                                                               
Author: Peter-Michael Osera <osera@cs.grinnell.edu>                                                                                                           
Date:   Thu Feb 13 12:40:05 2025 -0600                                                                                                                        
                                                                                                                                                              
    Project files                                                                                                                                             
                                                                                                                                                              
commit 02dc92144ecc088bcefb4a9798df0934efe300c1                                                                                                               
Author: Peter-Michael Osera <osera@cs.grinnell.edu>                                                                                                           
Date:   Thu Feb 13 12:39:53 2025 -0600                                                                                                                        
                                                                                                                                                              
    initial commit 