package it.uniroma3.siw.ProgettoSIW.controller;

import it.uniroma3.siw.ProgettoSIW.model.ArtCollection;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ArtCollectionValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ArtCollection.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "curator", "required");
    }
}
