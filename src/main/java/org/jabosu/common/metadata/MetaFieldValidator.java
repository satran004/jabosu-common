package org.jabosu.common.metadata;

import org.jabosu.common.util.InjectorHelper;
import org.jabosu.common.util.Messages;
import org.jabosu.common.util.StringUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jabosu.common.MetaField;

/**
 *
 * @author satya
 */
public class MetaFieldValidator {

    /* TODO
    
    public static List<ValidationError> validate(Map<String, String[]> params, List<MetaField> metaFields) {
        List<ValidationError> errors = null;
        
        for(MetaField field: metaFields) {
            String[] value = params.get(field.id);
            
            ValidationError error = validate(field, value);
            
            if(error != null) {
                if(errors == null) errors = new LinkedList();
                
                errors.add(error);
            }
        }
        
        return errors;
    }
    
    public static ValidationError validate(MetaField field, String[] value) {
        
        if(field.required && StringUtil.isEmpty(value)) {
            return new ValidationError(field.id, Messages.get("error.required"));
        }
        
        if(field.maxLength != 0 && !StringUtil.isEmpty(value)) {
            FieldValidator maxValidator = InjectorHelper.getInstance().getBean(FieldValidator.class, "max-length");
            String error = maxValidator.validate(field, value[0]);
            
            if(!StringUtil.isEmpty(error))
                return new ValidationError(field.id, error);
        }
        
        if(StringUtil.isEmpty(field.validator))
            return null;
        else {
            FieldValidator validator = InjectorHelper.getInstance().getBean(FieldValidator.class, field.validator);
            
            if(validator != null) {
                for(String val: value) {
                    String error = validator.validate(field, val);
                    if(!StringUtil.isEmpty(error)) {

                        if(!StringUtil.isEmpty(field.errorcode)) {
                            return new ValidationError(field.id, Messages.get(field.errorcode));
                        } else {
                            return new ValidationError(field.id, error);
                        }
                    } else
                        return null;
                }
                
                return null;
                
            } else {
                return null;
            }
        }
    }
    
    private static String getParameter(Map<String, String[]> paramMap, String param) {
        String[] values = paramMap.get(param);

        if (values == null || values.length == 0) {
            return null;
        }

        return values[0];
    }
    */
}
