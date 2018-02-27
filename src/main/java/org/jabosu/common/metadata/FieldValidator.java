package org.jabosu.common.metadata;

import org.jabosu.common.MetaField;

/**
 *
 * @author satya
 */
public interface FieldValidator {
    
    public String validate(MetaField field, String value);
}
