
package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;

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

        // TODO: fill me in with a text editor TUI!
        String path = args[0];
        System.out.format("Loading %s...\n", path);
        
        GapBuffer buffer = new GapBuffer();
        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();
        boolean stillRunning = true;
        while(stillRunning) {
            KeyStroke stroke = screen.readInput();
            KeyType type = stroke.getKeyType();
            switch (type) {
                case Character:
                    char ch = stroke.getCharacter();
                    buffer.insert(ch);
                    break;
                case ArrowLeft:
                    buffer.moveLeft();
                    break;
                case ArrowRight:
                    buffer.moveRight();
                    break;
                case Backspace:
                    buffer.delete();
                    break;
                case Escape:
                    stillRunning = false;
                    break;
            }
            drawBuffer(buffer, screen);
        }
        screen.stopScreen();
    }
    
    public static void drawBuffer(GapBuffer buf, Screen screen) {
        
    }
}
