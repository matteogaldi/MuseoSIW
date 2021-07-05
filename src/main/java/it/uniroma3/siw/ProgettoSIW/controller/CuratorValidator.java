package it.uniroma3.siw.ProgettoSIW.controller;

import it.uniroma3.siw.ProgettoSIW.model.Curator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CuratorValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Curator.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placeOfBirth", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "badge", "required");
    }
}
