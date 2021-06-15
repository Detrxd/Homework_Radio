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
    void testNextRadioStation() {

        assertEquals(0, service.getCurrentStation());
        service.next(0);
        assertEquals(1, service.getCurrentStation());
        service.next(1);
        assertEquals(2, service.getCurrentStation());
    }

    @Test
    void previousRadioStation() {
        assertEquals(0, service.getCurrentStation());
        service.prev();
        assertEquals(9, service.getCurrentStation());
        service.prev();
        assertEquals(8, service.getCurrentStation());
    }

    @Test
    void testValueVolume() {
        assertEquals(0, service.getLimitOverValueVolume());
        service.decreaseVolume();
        assertEquals(0, service.getLimitOverValueVolume());
        service.increaseVolume();
        assertEquals(1, service.getLimitOverValueVolume());
        service.decreaseVolume();
        assertEquals(0, service.getLimitOverValueVolume());
        service.increaseVolume();
        assertEquals(1, service.getLimitOverValueVolume());
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
        int radioStation = 1;
        for (radioStation = 1; radioStation < 9; radioStation = radioStation + 1) {
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