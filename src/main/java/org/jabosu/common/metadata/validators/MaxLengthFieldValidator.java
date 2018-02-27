package org.jabosu.common.metadata.validators;

import org.jabosu.common.metadata.FieldValidator;
import org.jabosu.common.util.Messages;
import org.jabosu.common.util.StringUtil;
import org.jabosu.common.MetaField;

/**
 *
 * @author satya
 */
public class MaxLengthFieldValidator implements FieldValidator {

    @Override
    public String validate(MetaField field, String value) {
        if(StringUtil.isEmpty(value))
            return null;
        
        if(field.maxLength != 0 && value.length() > field.maxLength)
            return Messages.get("error.maxLength.currenLength", field.maxLength, value.length());
        else
            return null;
    }
}
