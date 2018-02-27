package org.jabosu.common.validators;

import java.util.Collection;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author satya
 */
public class CollectionNotEmptyValidator implements ConstraintValidator<CollectionNotEmpty, Collection>{

    @Override
    public void initialize(CollectionNotEmpty a) {
    }

    @Override
    public boolean isValid(Collection t, ConstraintValidatorContext cvc) {
        if(t == null || t.isEmpty())
            return false;
        else
            return true;
    }
    
}
