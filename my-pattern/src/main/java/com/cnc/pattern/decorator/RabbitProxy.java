package com.cnc.pattern.decorator;

public class RabbitProxy extends Rabbit {

    private final Rabbit wrappedRabbit;

    public RabbitProxy(Rabbit wrappedRabbit) {
        this.wrappedRabbit = wrappedRabbit;
    }

    public static Rabbit wrap(Rabbit rabbit) {
        return new RabbitProxy(rabbit);
    }

    @Override
    public void move() {
        System.out.println("rabbit is in a room");
        wrappedRabbit.move();
    }

    @Override
    public void eat(String food) {
        wrappedRabbit.eat("xxxx");
    }
}
