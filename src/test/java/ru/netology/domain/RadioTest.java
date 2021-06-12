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
        service.next();
        assertEquals(1, service.getCurrentStation());
        service.next();
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
    void testValueVolumes() {
        assertEquals(0, service.getVolume());
        service.decreaseVolume();
        assertEquals(0, service.getVolume());
        service.increaseVolume();
        assertEquals(1, service.getVolume());
    }

    @Test
    void testLimitVolume() {
        int maxValue = 1;
        for (maxValue = 1; maxValue < 10; maxValue = maxValue + 1) {
        }
        service.getVolume();
        assertEquals(10, maxValue);
    }
}