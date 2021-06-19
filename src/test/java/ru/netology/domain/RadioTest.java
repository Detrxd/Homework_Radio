package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    Radio service = new Radio();

    @Test
//    @Disabled
    public void testLimitStation() {
        service.setCurrentStation(0);
        assertEquals(0, service.getCurrentStation());
        service.setCurrentStation(10);
        assertEquals(0, service.getCurrentStation());
        service.setCurrentStation(8);
        assertEquals(8, service.getCurrentStation());
    }

    @Test
//    @Disabled
    void testNextRadioStation() { //Проверка переключения станции на +1
        assertEquals(0, service.getCurrentStation());
        service.next(0);
        assertEquals(1, service.getCurrentStation());

    }

    @Test
    void previousRadioStation() { // Проверка переключения радиостанции в обратном порядке, начиная с 0
        assertEquals(0, service.getCurrentStation());
        service.prev();
        assertEquals(9, service.getCurrentStation());
    }
    @Test
    void downgradeRadioStation (){ // Проверка переключения радиостанции на 1 шаг
        service.setCurrentStation(5);
        assertEquals(5, service.getCurrentStation());
        service.prev();
        assertEquals(4, service.getCurrentStation());
    }

    @Test //Проверка того, что значение не уходит за нижний лимит
    void ValueVolumeDownUnderLimit() {
        assertEquals(0, service.getLimitOverValueVolume());
        service.decreaseVolume();
        assertEquals(0, service.getLimitOverValueVolume());
        service.increaseVolume();
    }

    @Test //Проверка повышения,а затем понижения звука
    void ValueVolumeUp() {
        service.increaseVolume();
        assertEquals(1, service.getLimitOverValueVolume());
        service.decreaseVolume();
        assertEquals(0, service.getLimitOverValueVolume());

    }

    @Test
    void testLimitVolume() {
        int maxValue = 1;
        for (maxValue = 1; maxValue < 10; maxValue = maxValue + 1) {
        }
        service.getLimitOverValueVolume();
        assertEquals(10, maxValue);
    }

    @Test
    void testOverLimitRadioStation() {
        int radioStation;
        for (radioStation = 1; radioStation < 9; radioStation = radioStation + 1) {
                radioStation=9;
        }
        service.next(9);        // Вероятнее всего так делать неправильно, подскажите, пожалуйста как приравнять значение radioStation к currentStation`y
        assertEquals(0, service.getCurrentStation());
    }

    @Test
    void VolumeTest() {
        int i = 0;
        while (i < 10) {
            service.increaseVolume();
            i++;
        }
        assertEquals(9, service.getLimitOverValueVolume());
    }
}