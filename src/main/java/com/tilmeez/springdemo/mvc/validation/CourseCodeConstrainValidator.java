package com.tilmeez.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator
        implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result = false;

        if (theCode != null) {

            //
            // loop thru course prefixes
            //
            // check to see if code matches any of the prefixes
            //
            for (String tempPrefix : coursePrefix) {
                result = theCode.startsWith(tempPrefix);

                // if found a match then break out the loop
                if (result) {
                    break;
                }
            }
        } else {
            result = true;
        }

        return result;
    }
}
