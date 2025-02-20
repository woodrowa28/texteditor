
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

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
