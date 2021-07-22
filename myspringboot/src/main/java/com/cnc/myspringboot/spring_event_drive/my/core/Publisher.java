package com.cnc.myspringboot.spring_event_drive.my.core;

public interface Publisher {
    void publish(Event event);

    <T extends Event> void addListener(Listener<T> listener);
}
