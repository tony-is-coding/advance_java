package com.cnc.myspringboot.spring_event_drive.my.core;

public interface Publisher {
    void publish(Event event);

    void addListener(Listener<Event> listener);
}
