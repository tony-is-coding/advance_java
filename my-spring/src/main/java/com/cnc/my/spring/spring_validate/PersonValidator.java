package com.cnc.my.spring.spring_validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name must not be empty");
        Person p = (Person) o;
        if (p.getAge() < 0) {
            e.rejectValue("age", "invalid age number!!!");
        } else if (p.getAge() > 100) {
            e.rejectValue("age", "too old!!!");
        } else if (p.getAge() < 15) {
            e.rejectValue("age", "too young!!!");
        }
    }
}
