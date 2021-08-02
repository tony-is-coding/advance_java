package com.cnc.myboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "custom.mq.rabbitmq")
@Profile("dev")
@Component
public class RabbitMqProperties {

    private MetaProperties vacation;

    public static class MetaProperties {
        String queue;
        String exchange;

        public String getQueue() {
            return queue;
        }

        public void setQueue(String queue) {
            this.queue = queue;
        }

        public String getExchange() {
            return exchange;
        }

        public void setExchange(String exchange) {
            this.exchange = exchange;
        }
    }

    public MetaProperties getVacation() {
        return vacation;
    }

    public void setVacation(MetaProperties vacation) {
        this.vacation = vacation;
    }
}
