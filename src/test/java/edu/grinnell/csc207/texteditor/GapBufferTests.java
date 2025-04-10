package edu.grinnell.csc207.texteditor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;


public class GapBufferTests {
    
    @Test
    public void deleteTests() {
        GapBuffer b = new GapBuffer();
        b.insert('h');
        b.insert('i');
        assertEquals("hi", b.toString());
        b.moveLeft();
        b.delete();
        assertEquals("i", b.toString());
        b.moveRight();
        b.delete();
        assertEquals("", b.toString());
    }
    @Test
    public void outOfBoundsTests() {
        GapBuffer b = new GapBuffer();
        assertThrows(IndexOutOfBoundsException.class, ()->b.getChar(11));
        assertThrows(IndexOutOfBoundsException.class, ()->b.getChar(-4));
    }
    
    @Test
    public void movementTests() {
        GapBuffer b = new GapBuffer();
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
        GapBuffer b = new GapBuffer();
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
        GapBuffer b = new GapBuffer();
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
        GapBuffer b = new GapBuffer();
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
    
    @Test
    public void expansionTests() {
        GapBuffer b = new GapBuffer();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 1000; i++) {
            b.insert(alphabet.charAt(i % 26));
        }
        assertEquals('l',b.getChar(999));
    }
    
    @Property
    public boolean defaultSizeTests(@ForAll @IntRange(min = 0, max = 100) int size) {
        GapBuffer b = new GapBuffer();
        for (int i = 0; i < size; i++) {
            b.insert('a');
        }
        return b.getSize() == size;
    }
    
    @Property
    public boolean deleteSizeTests(@ForAll @IntRange(min = 1, max = 100) int size) {
        GapBuffer b = new GapBuffer();
        for (int i = 0; i < size; i++) {
            b.insert('a');
        }
        b.delete();
        return b.getSize() == size - 1;
    }
    
    @Property
    public boolean insertSizeTests(@ForAll @IntRange(min = 0, max = 100) int size) {
        GapBuffer b = new GapBuffer();
        for (int i = 0; i < size; i++) {
            b.insert('a');
        }
        b.insert('b');
        return b.getSize() == size + 1;
    }
}
