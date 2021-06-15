package ru.netology.domain;

public class Radio {
    private int currentStation;
    private int volume;

    // Radio //
    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation <= 0)
            return;
        if (currentStation >= 9)
            return;
        this.currentStation = currentStation;
    }

    public void next(int currentStation) {
        if (currentStation == 9) {
            this.currentStation = 0;
        } else {
            this.currentStation = currentStation + 1;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            this.currentStation = currentStation - 1;
        }
    }

    // Volume //
    public int getLimitOverValueVolume() {
        return volume;
    }


    public void increaseVolume() {
        if (limitOverValueVolume(volume)) {
            return;
        } else {
            volume = volume + 1;
            ;
        }
    }

    public void decreaseVolume() {
        if (limitBelowValueVolume(volume)) {
            return;
        }
        volume = volume - 1;
    }

    public boolean limitOverValueVolume(int currentVolume) {
        return currentVolume == 9;
    }

    public boolean limitBelowValueVolume(int currentVolume) {
        return currentVolume == 0;
    }
}