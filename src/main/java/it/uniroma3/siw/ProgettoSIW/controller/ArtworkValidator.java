package it.uniroma3.siw.ProgettoSIW.controller;

import it.uniroma3.siw.ProgettoSIW.model.Artwork;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ArtworkValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Artwork.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "photoURL", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "artist", "required");
    }
}
