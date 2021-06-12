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

    public void next() {
        if (currentStation == 9) {
            currentStation = 0;
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
    public int getVolume() {
        return volume;
    }

    public void increaseVolume() {
        if (volume < 10) {
            volume = volume + 1;
        }
    }

    public void decreaseVolume() {
        if (volume > 0) {
            volume = volume - 1;
        }
    }

}