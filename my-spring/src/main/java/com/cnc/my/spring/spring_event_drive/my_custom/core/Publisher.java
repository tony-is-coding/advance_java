package com.cnc.my.spring.spring_event_drive.my_custom.core;

public interface Publisher {
    void publish(Event event);

    <T extends Event> void addListener(Listener<T> listener);
}
