package com.example.switchscene;

public class GameManagerSingleton {
    // sie ist für alle anderen Klassen verfügbar
    // darf aber nur einmal vorhanden sein
    // es soll nur ein Objekt bzw. Instanz dieser Klasse geben

    // ein Objekt der Klasse GameMangerSingleton wird erste erstellt,
    // wenn getInstance zum ersten Mal aufgerufen wird
    // und noch nicht initialisiert wurde (Initialisierung erfolgt im Konstruktor)
    private static GameManagerSingleton GaMaSi;


    // ein Objekt der Klasse GameMangerSingleton wird aufgerufen
    public static GameManagerSingleton getGaMaSi() {
        if (GaMaSi == null) {
            GaMaSi = new GameManagerSingleton();
        }
        return GaMaSi;
    }
    private BuchstabenManager buma;
    private TimeManager tima;
    private WordManager woma;
    private String formattedTime;
    private int wordLength;
    private String username;

    private String SolutionWord;


    // Konstruktor einer Singleton-Klasse = privat
    // er wird nur EIN mal Aufgerufen
    private GameManagerSingleton() {
        // Initializierung von allen Managern
        buma = new BuchstabenManager();
        woma = new WordManager();
        // Initializierung von TimeManger erwartet 2 Instanzen von Klassen
        tima = new TimeManager(buma, GaMaSi);
    }

    // Zugriff auf die Manager-Klassen über set + get Methoden
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public String getSolutionWord (){
        return woma.getSolutionWord();
        // Zugriff auf die Instanzvariable "SolutionWord" vom WordManager zugegriffen
        // indem man auf die Instanz woma vom WordManager zugreift
        // getSolutionWord ist eine Methode im WordManager
        // keine get Methode notwendig
    }


    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }
    public int getWordLength() {
        return wordLength;
    }
    public WordManager getWordManager() {
        return woma;
    }
    public BuchstabenManager getBuchstabenManager() {
        return buma;
    }
    public TimeManager getTimerManager() {
        return tima;
    }
    public void setFormattedTime(String formattedTime) {
        this.formattedTime = formattedTime;
    }
    public String getFormattedTime() {
        return formattedTime;
    }
}
