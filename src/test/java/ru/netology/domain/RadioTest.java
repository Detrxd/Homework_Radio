package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    Radio service = new Radio();

    @Test
    public void testCurrentStation() {
        service.setCurrentStation(100);
        assertEquals(100, service.getCurrentStation());
    }
    @Test
    public void testMaxMinValueLimits(){
        service.setCurrentStation(-1);
        assertEquals(10,service.getCurrentStation());
        service.setCurrentStation(120);
        assertEquals(10,service.getCurrentStation());
    }
    @Test
//    @Disabled
    public void testLimitStation() {
        service.setCurrentStation(0);
        assertEquals(0, service.getCurrentStation());
        service.setCurrentStation(100);
        assertEquals(100, service.getCurrentStation());
    }

    @Test
//    @Disabled
    void testNextRadioStation() { //Проверка переключения станции на +1
        service.next(13);
        assertEquals(14,service.getCurrentStation());
        service.next(100);
        assertEquals(0, service.getCurrentStation());

    }

    @Test
    void previousRadioStation() { // Проверка переключения радиостанции в обратном порядке, начиная с 0
        service.setCurrentStation(0);
        assertEquals(0, service.getCurrentStation());
        service.prev();
        assertEquals(100, service.getCurrentStation());
    }

    @Test
    void downgradeRadioStation() { // Проверка переключения радиостанции на 1 шаг
        service.setCurrentStation(5);
        assertEquals(5, service.getCurrentStation());
        service.prev();
        assertEquals(4, service.getCurrentStation());
    }

    @Test
        //Проверка того, что значение не уходит за нижний лимит
    void ValueVolumeDownUnderLimit() {
        assertEquals(0, service.getLimitOverValueVolume());
        service.decreaseVolume();
        assertEquals(0, service.getLimitOverValueVolume());
        service.increaseVolume();
    }

    @Test
        //Проверка повышения,а затем понижения звука
    void ValueVolumeUp() {
        service.increaseVolume();
        assertEquals(1, service.getLimitOverValueVolume());
        service.decreaseVolume();
        assertEquals(0, service.getLimitOverValueVolume());

    }

    @Test
    void testLimitVolume() {
        int maxValue = 1;
        for (maxValue = 1; maxValue < 100; maxValue = maxValue + 1) {
        }
        service.getLimitOverValueVolume();
        assertEquals(100, maxValue);
    }

    @Test
    void VolumeTest() {
        int i = 0;
        while (i <= 100) {
            service.increaseVolume();
            i++;
        }
        assertEquals(100, service.getLimitOverValueVolume());
    }

    @Test
    public void Radio() {
        assertEquals(10, service.getCurrentStation());
    }
}