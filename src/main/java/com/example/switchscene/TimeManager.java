package com.example.switchscene;
import javafx.animation.AnimationTimer;

import java.util.Timer;
import java.util.TimerTask;

public class TimeManager {

    private int secondsRemaining;
    private Timer timer;
    private String formattedTime;
    private BuchstabenManager buma;
    private GameManagerSingleton GaMaSi;
    private AnimationTimer aniTime;
    private Runnable onTimeTick;

    // dem Konstruktor werden Parameter und Klassen-Instanzen übergeben
    public TimeManager(BuchstabenManager bm, GameManagerSingleton gm) {
        // Initialisieren der Klassen-Instanzen bzw. der Klassen-variablen
        this.buma = bm;
        this.GaMaSi = gm;

        // AnimationTime Methode aktualisiert die handleTimeTick Methode (bei jedem Frame-Update) updated
        this.aniTime = new AnimationTimer() {
            @Override
            public void handle(long now) {
                handleTimerTick();
            }
        };
    }

    // Runnable = Java Schnittstelle -> Operation die ohne Argumente ausgeführt wird und keine Ergebnisse zurückgibt
    // ermöglicht das Ausführen einer Aktion während der Timer tickt = so kann die Zeit durchgehen angezeigt werden
    public void setOnTimeTick(Runnable onTimeTick) {
        this.onTimeTick = onTimeTick;
    }

    // setzt die verbleibende Zeit
    public void startTimer() {
        secondsRemaining = 300;
        timer = new Timer(true); // Deamon-Thread
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handleTimerTick();//  der Timer tickt jede Sekunde
            }
        }, 0, 1000);
        aniTime.start(); // AnimationTimer Methode wird verwendet
        // um die handleTimerTick Methode bei jedem Frame-Update aufzurufen
    }

    // stopt die Timer Methode und die AnimationTimer Methode
    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
            aniTime.stop();
        }
    }


    private void handleTimerTick() {
        secondsRemaining--; // verringert den Timer im 1 Sekunde --

        if (onTimeTick != null) {
            onTimeTick.run();
        }

        if (secondsRemaining <= 0) {
            timer.cancel(); // die Methode Timer wird abgebrochen
            buma.handleTimeUp(); // die Methode handleTimeUp im BuchstabenManger wird aufgerufen
        }
    }

    public String getFormattedTime() {
        int minutes = secondsRemaining / 60;
        int seconds = secondsRemaining % 60;
        int hundredths = (int) ((secondsRemaining - Math.floor(secondsRemaining)) * 100);

        // Gibt die formatierte Zeit im Format "MM:SS:HH" zurück.
        return String.format("%02d:%02d:%02d", minutes, seconds, hundredths);

    }
}