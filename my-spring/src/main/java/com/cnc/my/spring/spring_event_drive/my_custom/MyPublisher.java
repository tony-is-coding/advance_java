package com.cnc.my.spring.spring_event_drive.my_custom;

import com.cnc.my.spring.spring_event_drive.my_custom.core.Event;
import com.cnc.my.spring.spring_event_drive.my_custom.core.Listener;
import com.cnc.my.spring.spring_event_drive.my_custom.core.Publisher;

import java.util.HashSet;
import java.util.Set;

public class MyPublisher implements Publisher {
    private final Set<Listener<Event>> listeners = new HashSet<>();

    @Override
    public void publish(Event event) {
        for (Listener<Event> listener : listeners) {
            listener.onEventHappened(event);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Event> void addListener(Listener<T> listener) {
        listeners.add((Listener<Event>) listener);
    }
}
