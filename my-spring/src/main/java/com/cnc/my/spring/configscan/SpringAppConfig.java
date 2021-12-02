package com.cnc.my.spring.configscan;

import com.cnc.my.spring.spring_formatter.NumberFormatAnnotationFormatterFactory;
import org.springframework.context.annotation.*;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

import java.time.format.DateTimeFormatter;

@Configuration
@ComponentScan(basePackages = "com.cnc.my.spring")
@PropertySource("classpath:/properties.properties")
@EnableAspectJAutoProxy
public class SpringAppConfig {

    @Bean
    public FormattingConversionService conversionService() {

        // Use the DefaultFormattingConversionService but do not register defaults
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

        // Ensure @NumberFormat is still supported
        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());

        // Register JSR-310 date conversion with a specific global format
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setDateFormatter(DateTimeFormatter.ofPattern("yyyy__MM__dd"));
        registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("yyyy__MM__dd HH__mm__ss"));
        registrar.setTimeFormatter(DateTimeFormatter.ofPattern("HH__mm__ss"));
        registrar.registerFormatters(conversionService);

        // Register date conversion with a specific global format
//        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
//        registrar.setFormatter(new DateFormatter("yyyyMMdd"));
//        registrar.registerFormatters(conversionService);

        return conversionService;
    }
}
