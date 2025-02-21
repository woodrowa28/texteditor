
package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.TextCharacter;
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
        
        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();
        screen.stopScreen();
    }
}
