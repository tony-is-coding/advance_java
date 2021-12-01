package com.cnc.pattern.decorator;

public class TestDecorator {
    public static void main(String[] args) {
        Rabbit rabbit = RabbitProxy.wrap(new Rabbit());
        rabbit.eat("胡萝卜");
        rabbit.move();
    }
}
