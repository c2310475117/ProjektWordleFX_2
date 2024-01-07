package com.example.switchscene;

import java.util.Scanner;

public class MainJAVA {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        BuchstabenManager bm = new BuchstabenManager();

        System.out.println("Willkommen bei Wordle!");
        System.out.print("Geben Sie die Wortlänge ein : ");

        int length = scanner.nextInt();
        WordManager wm;
        wm = bm.getWm();
        wm.generateWordList(length);
        String loesung = wm.getSolutionWord();

        GameManagerSingleton gm = GameManagerSingleton.getGaMaSi();
        TimeManager tm = new TimeManager(bm, gm);
        tm.startTimer();

        System.out.println(loesung);//Für Debugging
        // bm.startGame(); // Timer starten
        for (int i=0; i<6;i++) {
            // TimeUnit.SECONDS.sleep(1);
            System.out.print("Geben Sie das Eingabewort ein: ");

            String eingabe = scanner.next();
            String ergebnis=bm.comparisonOfLetters(loesung, eingabe);
            if (ergebnis == null) {
                i--;
            } else if (ergebnis.equals("WON")) {
                tm.stopTimer();
                String formattedTime = tm.getFormattedTime();
                System.out.println("Verbleibende Zeit: " + formattedTime);
                break;
            }
            else {
                System.out.println(ergebnis);
            }
            if (i==5){
                System.out.println();
                System.out.println("Keine Versuche mehr leider Verloren ):");
                System.exit(1);
            }

        }
    }
}

