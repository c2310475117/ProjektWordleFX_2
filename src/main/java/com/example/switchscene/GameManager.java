package com.example.switchscene;

public class GameManager {
    private static GameManager instance;
    private BuchstabenManager buchstabenManager;
    private TimerManager timerManager;
    private WordManager wordManager;
    private String formattedTime;
    private int wordLength;

    private String username;

    private GameManager() {
        // Initialisiere hier alle Manager und andere benötigte Objekte
        buchstabenManager = new BuchstabenManager();
        timerManager = new TimerManager(buchstabenManager);
        wordManager = new WordManager();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    // Weitere Methoden für die Übertragung von Werten

    public void setFormattedTime(String formattedTime) {
        this.formattedTime = formattedTime;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public int getWordLength() {
        return wordLength;
    }

    public BuchstabenManager getBuchstabenManager() {
        return buchstabenManager;
    }

    public TimerManager getTimerManager() {
        return timerManager;
    }

    public WordManager getWordManager() {
        return wordManager;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
