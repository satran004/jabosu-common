package org.jabosu.common.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author satya
 */
public class ArrayValidator implements ConstraintValidator<ArrayValid, String[]> {

    private String regexp;
    @Override
    public void initialize(ArrayValid a) {
        regexp = a.regexp();
    }

    @Override
    public boolean isValid(String[] values, ConstraintValidatorContext cvc) {
        
        if(values == null)
            return true;
        
        for(String value: values) {
            if(value != null) {
                if(!value.matches(regexp))
                    return false;
            }
        }
        
        return true;
    }
    
}
