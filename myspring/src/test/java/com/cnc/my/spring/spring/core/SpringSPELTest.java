package com.cnc.my.spring.spring.core;

import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpringSPELTest {
    @Test
    public void testNoExpress() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'hello world'");
        String message = exp.getValue(String.class);

        System.out.println(message);
    }
}
