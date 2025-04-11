
package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     * @throws IOException upon terminal screen failure
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        String path = args[0];
        Path input = Paths.get(path);
        GapBuffer buffer = new GapBuffer();
        if (Files.exists(input) && Files.isRegularFile(input)) {
            fillBuffer(buffer, Files.readString(input));
        }
        
        System.out.format("Loading %s...\n", path);
        Screen screen = new DefaultTerminalFactory().createScreen();
        runLoop(buffer, screen);
        Files.writeString(input, buffer.toString());
        screen.stopScreen();
    }
    
    /**
     * Inserts the string into the gap buffer one character at a time.
     * @param buffer the gap buffer data
     * @param input input string, from the command line file
     */
    public static void fillBuffer(GapBuffer buffer, String input) {
        for (int i = 0; i < input.length(); i++) {
            buffer.insert(input.charAt(i));
        }
    }
    
    /**
     * Repeatedly takes input from user, performs the desired operation in the gap buffer,
     * and displays the changes to the screen.
     * @param buffer gap buffer data
     * @param screen screen display to present terminal
     * @throws IOException if an error occurs with screen processing
     */
    public static void runLoop(GapBuffer buffer, Screen screen) throws IOException {
        screen.startScreen();
        drawBuffer(buffer, screen);
        boolean stillRunning = true;
        while (stillRunning) {
            KeyStroke stroke = screen.readInput();
            KeyType type = stroke.getKeyType();
            if (type.equals(KeyType.Character)) {
                char ch = stroke.getCharacter();
                buffer.insert(ch);
            } else if (type.equals(KeyType.ArrowLeft)) {
                buffer.moveLeft();
            } else if (type.equals(KeyType.ArrowRight)) {
                buffer.moveRight();
            } else if (type.equals(KeyType.Backspace)) {
                buffer.delete();
                screen.clear();
            } else if (type.equals(KeyType.Escape)) {
                stillRunning = false;
            }
            drawBuffer(buffer, screen);
        }
    }
    
    /**
     * Updates the terminal screen by drawing all the new changes to the buffer.
     * @param buf gap buffer data, where the characters are stored
     * @param screen terminal display to be copied to
     * @throws IOException 
     */
    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        TextCharacter currChar;
        for (int i = 0; i < buf.getSize(); i++) {
            currChar = TextCharacter.fromCharacter(buf.getChar(i))[0];
            screen.setCharacter(i, 0, currChar);
        }
        screen.setCursorPosition(new TerminalPosition(buf.getCursorPosition(), 0));
        screen.refresh();
    }
}
