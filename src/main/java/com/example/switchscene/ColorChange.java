package com.example.switchscene;

public class ColorChange {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[30m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public void Color() {
        System.out.println(ANSI_RED + "test rot" + ANSI_RESET + " testest");
        System.out.println(ANSI_GREEN + "test gruen" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + "test background" + ANSI_BLACK_BACKGROUND);
    }

}
// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
// Quelle meines Wissens

// ColorChange Farbe = new ColorChange();
//        Farbe.Color();
// (siehe oben) Der Code muss in die Main eingefügt werden.

// Aufgabe Fabio: Einen Buchstaben auswählen und probieren nur diesen im ganzen Wort einzufärben