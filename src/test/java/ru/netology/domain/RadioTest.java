package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    public void fieldParametrs() {
        Radio radio = new Radio();
        assertEquals(10, radio.getMaxCurrentStation());
        assertEquals(0, radio.getMinCurrentStation());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(100, radio.getMaxCurrentVolume());
        assertEquals(0, radio.getMinCurrentVolume());
        assertEquals(0, radio.getCurrentVolume());
    }


    @Test // Установка максимального значения радиостанции
    public void setRadioMaxStation() {
        Radio service = new Radio(80);
        assertEquals(80, service.getMaxCurrentStation());
    }

    @Test//
    public void checkLimitStation(){ // Проверка того, что значение не выходит за максимум.
        Radio radio = new Radio(5);
        radio.setCurrentStation(5);
        radio.nextRadioStation();
        assertEquals(0,radio.getCurrentStation());


    }

    @Test
    // Переключение радиостанции на +1
    public void upRadioStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextRadioStation();
        assertEquals(10, radio.getCurrentStation());
    }

    @Test
    // Переключение радиостанции на +1 при достижении лимита в 10.
    public void nextRadioStationOverLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        radio.nextRadioStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void nextRadioStationOverLimit1() { //Переключение радиостанции сверх лимита
        Radio radio = new Radio();
        radio.setCurrentStation(11);
        radio.nextRadioStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void previousRadioStation() { // Убавляем станцию на 1 шаг
        Radio radio = new Radio();
        radio.setCurrentStation(4);
        radio.previousRadioStation();
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    public void previousRadioStationNearLimit() { // Убавляем станцию на 1, когда текущая 0
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.previousRadioStation();
        assertEquals(10, radio.getCurrentStation());
    }

    @Test

    public void previousRadioStationNearLimit1() { // Убавляем станцию на 1, когда текущая -1
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        radio.previousRadioStation();
        assertEquals(10, radio.getCurrentStation());
    }

    //Volume//
    @Test
    public void setVolume() { // Установка громкости на 50
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void upCurrentVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.nextVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void upCurrentVolumeOverLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.nextVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void upCurrentVolumeOverLimit1() {
        Radio radio = new Radio();
        radio.setCurrentVolume(102);
        radio.nextVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void increaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        radio.previousVolume();
        assertEquals(4, radio.getCurrentVolume());
    }

    @Test
    void increaseVolumeBelowLimit1() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        radio.previousVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void increaseVolumeBelowLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        radio.previousVolume();
        assertEquals(0, radio.getCurrentVolume());
    }


}