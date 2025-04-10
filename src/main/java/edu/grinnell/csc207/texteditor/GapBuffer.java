
package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    
    private char[] buffer;
    
    private int gapStartIndex;
    
    private int textStartIndex;
    
    private static final int INITIAL_SIZE = 10;
    
    /**
     * Creates a new empty gap buffer with the cursor at the start and the
     * after-cursor text starting position out of bounds to show nothing is present.
     */
    public GapBuffer() {
        buffer = new char[INITIAL_SIZE];
        gapStartIndex = 0;
        textStartIndex = INITIAL_SIZE;
    }
    
    /**
     * Inserts the character at the cursor position, expanding the gap buffer if it's full
     * @param ch the character to be inserted
     */
    public void insert(char ch) {
        if (gapStartIndex == textStartIndex) {
            expandBuffer();
        }
        buffer[gapStartIndex++] = ch;
    }
    
    /**
     * Creates a new gap buffer of double the size, keeping the existing gap structure
     * and cursor placement (helper function for insert).
     */
    private void expandBuffer() {
        char[] bigger = new char[buffer.length * 2];
        int index;
        if (gapStartIndex == buffer.length) {
            for (index = 0; index < buffer.length; index++) {
                bigger[index] = buffer[index];
                textStartIndex = bigger.length;
            }
        } else {
            for (index = 0; index < gapStartIndex; index++) {
                bigger[index] = buffer[index];
            }
            for (index = 1; index <= (buffer.length - textStartIndex); index++) {
                bigger[bigger.length - index] = buffer[buffer.length - index];
            }
            textStartIndex = bigger.length - index + 1;
        }
        buffer = bigger;
    }

    /**
     * Removes a character from the buffer by considering it part of the gap.
     */
    public void delete() {
        if (gapStartIndex != 0) {
            gapStartIndex--;
        }
    }

    /**
     * Returns the current position of the cursor in the buffer.
     * @return location of the start of the gap, aka the cursor position
     */
    public int getCursorPosition() {
        return gapStartIndex;
    }

    /**
     * Moves the cursor one left by sending the character immediately left of the cursor 
     * to the other side of the gap.
     */
    public void moveLeft() {
        if (gapStartIndex != 0) {
            buffer[--textStartIndex] = buffer[--gapStartIndex];
        }
    }

    /** 
     * Moves the cursor one right by sending the character immediately right of the
     * cursor to the other side of the gap.
     */
    public void moveRight() {
        if (textStartIndex != buffer.length) {
            buffer[gapStartIndex++] = buffer[textStartIndex++];
        }
    }

    /**
     * Gets the size of the buffer
     * @return the number of characters "used" in the buffer (size)
     */
    public int getSize() {
        return buffer.length - (textStartIndex - gapStartIndex);
    }

    /**
     * Gets the character at the given index of the buffer, ignoring the gap indices.
     * @param i index of the desired character
     * @return character at the index
     */
    public char getChar(int i) {
        if (i < 0 || i >= buffer.length) {
            throw new IndexOutOfBoundsException("Not a valid index.");
        } else if (i < gapStartIndex) {
            return buffer[i];
        } else {
            return buffer[i + (textStartIndex - gapStartIndex)];
        }
    }

    /**
     * Provides a string representation of the object
     * @return String that buffer contains, ignoring the gap chars
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < buffer.length; i++) {
            if (i < gapStartIndex || i >= textStartIndex) {
                ret.append(buffer[i]);
            }
        }
        return ret.toString();
    }
}
