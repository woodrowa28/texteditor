
package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    
    private int[] buffer;
    
    private int gapStartIndex;
    
    private int textStartIndex;
    
    private static final int INITIAL_SIZE = 10;
    
    public GapBuffer() {
        buffer = new int[INITIAL_SIZE];
        gapStartIndex = 0;
        textStartIndex = INITIAL_SIZE;
    }
    
    public void insert(char ch) {
        if(gapStartIndex==textStartIndex) {
            expandBuffer();
        }
        buffer[gapStartIndex++] = ch;
    }
    
    private void expandBuffer() {
        int[] bigger = new int[buffer.length * 2];
        int index;
        for (index = 0; index <= gapStartIndex; index++) {
            bigger[index] = buffer[index];
        }
        gapStartIndex++;
        for (index = 1; index <= (buffer.length - textStartIndex); index++) {
            bigger[bigger.length - index] = buffer[buffer.length - index];
        }
        textStartIndex = bigger.length - index + 1;
        buffer = bigger;
    }

    public void delete() {
        if (gapStartIndex != 0) {
            gapStartIndex--;
        }
    }

    public int getCursorPosition() {
        throw new UnsupportedOperationException("Unimplemented method 'getCursorPosition'");
    }

    public void moveLeft() {
        throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
    }

    public void moveRight() {
        throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
    }

    public int getSize() {
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    public char getChar(int i) {
        throw new UnsupportedOperationException("Unimplemented method 'getChar'");
    }

    public String toString() {
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
