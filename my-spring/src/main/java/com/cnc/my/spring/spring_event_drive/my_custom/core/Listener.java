package com.cnc.my.spring.spring_event_drive.my_custom.core;

public interface Listener<T extends Event> {
    void onEventHappened(T e);
}
