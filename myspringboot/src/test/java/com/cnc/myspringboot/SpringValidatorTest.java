package com.cnc.myspringboot;


import com.cnc.myspringboot.configscan.SpringAppConfig;
import com.cnc.myspringboot.spring_validate.Person;
import com.cnc.myspringboot.spring_validate.PersonValidator;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.DataBinder;

public class SpringValidatorTest {
    @Test
    public void testPersonValidate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Person person = new Person("tony", 120);
        PersonValidator personValidator = context.getBean(PersonValidator.class);
        DataBinder binder = new DataBinder(person);
        binder.setValidator(personValidator);
        binder.validate();

    }

}
