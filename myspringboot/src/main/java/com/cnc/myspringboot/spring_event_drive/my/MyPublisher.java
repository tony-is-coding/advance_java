package com.cnc.myspringboot.spring_event_drive.my;

import com.cnc.myspringboot.spring_event_drive.my.core.Event;
import com.cnc.myspringboot.spring_event_drive.my.core.Listener;
import com.cnc.myspringboot.spring_event_drive.my.core.Publisher;

import java.util.HashSet;
import java.util.Set;

public class MyPublisher<T extends Event> implements Publisher {
    private final Set<Listener<T>> listeners = new HashSet<>();

    @Override
    public void publish(Event event) {
        for (Listener<T> listener : listeners) {
            listener.onEventHappened((T) event);
        }
    }

    @Override
    public void addListener(Listener<Event> listener) {
        listeners.add((Listener<T>) listener);
    }
}
