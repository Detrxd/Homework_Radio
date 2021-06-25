package ru.netology.domain;

public class Radio {
    private int currentStation;
    private int minCurrentStation = 0;
    private int maxCurrentStation = 10;
    private int currentVolume;
    private int maxCurrentVolume = 100;
    private int minCurrentVolume = 0;


    public Radio(int currentVolume, int currentStation, int minCurrentStation, int maxCurrentStation, int minCurrentVolume, int maxCurrentVolume) {
        this.currentStation = currentStation;
        this.maxCurrentStation = maxCurrentStation;
        this.minCurrentStation = minCurrentStation;
        this.currentVolume = currentVolume;
        this.minCurrentVolume = minCurrentVolume;
        this.maxCurrentVolume = maxCurrentVolume;
    }

    public Radio() {
    }

    public Radio(int maxCurrentStation) {
        this.maxCurrentStation = maxCurrentStation;
    }

    public int getMinCurrentStation() {
        return minCurrentStation;
    }

    public int getMaxCurrentStation() {
        return maxCurrentStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getMaxCurrentVolume() {
        return maxCurrentVolume;
    }

    public int getMinCurrentVolume() {
        return minCurrentVolume;
    }

    //Stations//

    public void setCurrentStation(int currentStation) { //Установить станцию

        if (currentStation < minCurrentStation) {
            currentStation = minCurrentStation;
        }
        if (currentStation > maxCurrentStation) {
            currentStation = maxCurrentStation;
        }
        this.currentStation = currentStation;
    }

    public int nextRadioStation() { //Шаг вперёд на 1

        if (currentStation >= maxCurrentStation) {
            currentStation = minCurrentStation;
            return minCurrentStation;
        }
        currentStation++;

        return currentStation;
    }

    public int previousRadioStation() { //Шаг назад на 1
        if (currentStation <= minCurrentStation) {
            currentStation = maxCurrentStation;
            return maxCurrentStation;
        }
        this.currentStation--;
        return currentStation;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > maxCurrentVolume) {
            currentVolume = maxCurrentVolume;
        }
        if (currentVolume < minCurrentVolume) {
            currentVolume = minCurrentVolume;
        }
        this.currentVolume = currentVolume;
    }

    public void nextVolume() {
        if (currentVolume >= maxCurrentVolume) {
            return;
        }
        this.currentVolume++;
    }

    public void previousVolume() {
        if (currentVolume <= minCurrentVolume) {
            return;
        }
        currentVolume--;
    }
}
    // ОСТАНОВИЛСЯ НА НАПИСАНИИ АВТОТЕСТОВ. C классом, наверное, закончил //
