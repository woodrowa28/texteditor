
package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    
    private String buffer;
    
    private int index;
    
    /**
     * Creates a new, empty SimpleStringBuffer with a current index of 0
     */
    public SimpleStringBuffer() { 
        buffer = "";
        index = 0;
    }
    
    /**
     * Adds a new character to the buffer at the cursor's index
     * @param ch the character to be added
     */
    public void insert(char ch) {
        if (index == 0) {
            buffer = ch + buffer;
        } else if (index == buffer.length()) {
            buffer = buffer + ch;
        } else {
            buffer = buffer.substring(0, index) + ch + buffer.substring(index);
        }
    }

    /**
     * Removes a character from the buffer at the cursor's index
     */
    public void delete() {
        if (index != 0) {
            if (index == buffer.length()) {
                buffer = buffer.substring(0, index - 1);
            } else {
                buffer = buffer.substring(0, index - 1) + buffer.substring(index);
            }
            index--;
        }
    }
    
    /**
     * Returns the position of the cursor in the buffer
     * @return cursor index
     */
    public int getCursorPosition() {
        return index;
    }
    
    /**
     * Moves the cursor one position to the left unless already at start
     */
    public void moveLeft() {
        if (index != 0) {
            index--;
        }
    }

    /**
     * Moves the cursor one position to the right unless already at end
     */
    public void moveRight() {
        if (index != buffer.length()) {
            index++;
        }
    }

    /**
     * Gets the size (number of chars) in the buffer
     * @return length of buffer
     */
    public int getSize() {
        return buffer.length();
    }
    
    /**
     * Gets the character at index i of the buffer, if it exists
     * @param i index to retrieve
     * @return character at index
     * @throws IndexOutOfBoundsException if i is not a valid index
     */
    public char getChar(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= buffer.length()) {
            throw new IndexOutOfBoundsException("Not a valid index.");
        } else {
            return buffer.charAt(i);
        }
    }

    /**
     * Provides a string representation of the object
     * @return String that buffer contains
     */
    @Override
    public String toString() {
        return buffer;
    }
}
