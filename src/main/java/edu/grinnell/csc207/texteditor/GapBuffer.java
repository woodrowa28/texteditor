
package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    
    private char[] buffer;
    
    private int gapStartIndex;
    
    private int textStartIndex;
    
    private static final int INITIAL_SIZE = 10;
    
    public GapBuffer() {
        buffer = new char[INITIAL_SIZE];
        gapStartIndex = 0;
        textStartIndex = INITIAL_SIZE;
    }
    
    public void insert(char ch) {
        if (gapStartIndex==textStartIndex) {
            expandBuffer();
        }
        buffer[gapStartIndex++] = ch;
    }
    
    private void expandBuffer() {
        char[] bigger = new char[buffer.length * 2];
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
        return gapStartIndex;
    }

    public void moveLeft() {
        if (gapStartIndex != 0) {
            buffer[--textStartIndex] = buffer[--gapStartIndex];
        }
    }

    public void moveRight() {
        if (textStartIndex != buffer.length) {
            buffer[gapStartIndex++] = buffer[textStartIndex++];
        }
    }

    public int getSize() {
        return buffer.length - (textStartIndex - gapStartIndex);
    }

    public char getChar(int i) {
        if (i < gapStartIndex) {
            return buffer[i];
        } else {
            return buffer[i + (textStartIndex - gapStartIndex)];
        }
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < buffer.length; i++) {
            if (i < gapStartIndex || i >= textStartIndex);
            ret += buffer[i];
        }
        return ret;
    }
}
