package org.jabosu.common.util;

import org.jabosu.common.exception.BusinessException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.BeanWrapper;
//import org.springframework.beans.BeanWrapperImpl;

public class CopyUtil {

    /** TODO
   
    public static void copySpecificBeanProperties(
            final Object source,
            final Object target,
            final String... properties) {

        final BeanWrapper src = new BeanWrapperImpl(source);
        final BeanWrapper trg = new BeanWrapperImpl(target);

        for (final String propertyName : properties) {
            trg.setPropertyValue(
                    propertyName,
                    src.getPropertyValue(propertyName)
            );
        }

    }


    public static void copyBeanProperties(
            final Object source,
            final Object target, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }

    public static void copyBeanProperties(
            final Object source,
            final Object target) {
        BeanUtils.copyProperties(source, target);
    }

    public static void copyMapProperties(Map<String, ? extends Object> map, final Object target) throws BusinessException {
        try {
            org.apache.commons.beanutils.BeanUtils.populate(target, map);
        } catch (Exception ex) {
            throw new BusinessException(ex);
        }
    }
    
    public static <T> Set<ConstraintViolation<T>> validate(Class<T> clazz, String property, Object value) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> constraintViolations = validator.validateValue(clazz, property, value);
        
        return constraintViolations;
    }
    
    public static boolean setProperty(Object obj, String propName, Object value) throws BusinessException {
        if(obj == null)
            return false;
        
        try {
             Field field = obj.getClass().getDeclaredField(propName);
             field.set(obj, value);
             
             return true;
        } catch(Exception e) {
            throw new BusinessException("Error setting property", e);
        }
    }
    **/

}
