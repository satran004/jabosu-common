package org.jabosu.common.metadata.validators;

import org.jabosu.common.metadata.FieldValidator;
import org.jabosu.common.util.Messages;
import org.jabosu.common.util.StringUtil;
import org.jabosu.common.MetaField;

/**
 *
 * @author satya
 */
public class NumericFieldValidator implements FieldValidator {

    public String validate(MetaField field, String value) {
        
        if(StringUtil.isEmpty(value))
            return null;
        try {
            Integer.parseInt(value);
        } catch(Exception e) {
            return Messages.get("error.number");
        }
        
        return null;
    }
    
}
