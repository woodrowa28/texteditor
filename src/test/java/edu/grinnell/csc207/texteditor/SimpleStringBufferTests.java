package edu.grinnell.csc207.texteditor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;


public class SimpleStringBufferTests {
    
    @Test
    public void outOfBoundsTests() {
        SimpleStringBuffer b = new SimpleStringBuffer();
        assertThrows(IndexOutOfBoundsException.class, ()->b.getChar(11));
        assertThrows(IndexOutOfBoundsException.class, ()->b.getChar(-4));
    }
    
    @Test
    public void movementTests() {
        SimpleStringBuffer b = new SimpleStringBuffer();
        b.insert('h');
        b.insert('i');
        b.insert('!');
        b.moveRight();
        assertEquals(3, b.getCursorPosition());
        b.moveLeft();
        assertEquals(2, b.getCursorPosition());
        b.moveLeft();
        assertEquals(1, b.getCursorPosition());
        b.moveRight();
        assertEquals(2, b.getCursorPosition());
        b.moveLeft();
        b.moveLeft();
        assertEquals(0, b.getCursorPosition());
        b.moveLeft();
        assertEquals(0, b.getCursorPosition());
    }
    
    @Test
    public void frontOfBufferTests() {
        SimpleStringBuffer b = new SimpleStringBuffer();
        b.insert('c');
        b.insert('o');
        b.insert('m');
        b.insert('p');
        b.insert('u');
        b.insert('t');
        b.insert('e');
        b.insert('r');
        for (int i = 0; i < b.getSize(); i++) {
            b.moveLeft();
        }
        b.delete();
        assertEquals("computer", b.toString());
        assertEquals(0, b.getCursorPosition());
        b.insert('a');
        b.insert(' ');
        assertEquals("a computer", b.toString());
        assertEquals(2, b.getCursorPosition());
    }
    
    @Test
    public void endOfBufferTests() {
        SimpleStringBuffer b = new SimpleStringBuffer();
        b.insert('h');
        b.insert('e');
        b.insert('l');
        b.insert('l');
        b.insert('o');
        assertEquals(5, b.getCursorPosition());
        b.moveRight();
        assertEquals(5, b.getCursorPosition());
        b.insert('!');
        b.insert('!');
        assertEquals(7, b.getCursorPosition());
        assertEquals("hello!!", b.toString());
    }
    
    @Test
    public void middleOfBufferTests() {
        SimpleStringBuffer b = new SimpleStringBuffer();
        b.insert('r');
        b.insert('a');
        b.insert('c');
        b.insert('e');
        b.insert('c');
        b.insert('a');
        b.insert('r');
        assertEquals(7, b.getCursorPosition());
        b.moveLeft();
        b.moveLeft();
        b.moveLeft();
        assertEquals(4, b.getCursorPosition());
        b.insert('r');
        b.insert('a');
        b.insert('c');
        b.insert('e');
        b.moveLeft();
        b.moveLeft();
        b.moveLeft();
        b.moveLeft();
        b.insert('c');
        b.insert('a');
        b.insert('r');
        assertEquals(7, b.getCursorPosition());
        assertEquals("racecarracecar", b.toString());
    }
    
    @Property
    public boolean defaultSizeTests(@ForAll @IntRange(min = 0, max = 100) int size) {
        SimpleStringBuffer b = new SimpleStringBuffer();
        for (int i = 0; i < size; i++) {
            b.insert('a');
        }
        return b.getSize() == size;
    }
    
    @Property
    public boolean deleteSizeTests(@ForAll @IntRange(min = 1, max = 100) int size) {
        SimpleStringBuffer b = new SimpleStringBuffer();
        for (int i = 0; i < size; i++) {
            b.insert('a');
        }
        b.delete();
        return b.getSize() == size - 1;
    }
    
    @Property
    public boolean insertSizeTests(@ForAll @IntRange(min = 0, max = 100) int size) {
        SimpleStringBuffer b = new SimpleStringBuffer();
        for (int i = 0; i < size; i++) {
            b.insert('a');
        }
        b.insert('b');
        return b.getSize() == size + 1;
    }
}
