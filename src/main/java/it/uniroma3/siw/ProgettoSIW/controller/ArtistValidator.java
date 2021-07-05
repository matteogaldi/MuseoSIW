package it.uniroma3.siw.ProgettoSIW.controller;

import it.uniroma3.siw.ProgettoSIW.model.Artist;
import it.uniroma3.siw.ProgettoSIW.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ArtistValidator implements Validator {

    @Autowired
    ArtistService artistService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Artist.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationality", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placeOfBirth", "required");

        if (!errors.hasErrors()) {
            if (this.artistService.alreadyExists((Artist) o)) {
                errors.reject("duplicate");
            }
        }
    }
}
