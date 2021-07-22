package com.cnc.myspringboot.spring_event_drive.my.core;

public interface Listener<T extends Event> {
    void onEventHappened(T e);
}
