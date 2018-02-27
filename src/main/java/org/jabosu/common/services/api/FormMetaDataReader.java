package org.jabosu.common.services.api;

import org.jabosu.common.exception.BusinessException;

import java.io.InputStream;

/**
 * Created by satya on 13/12/15.
 */
public interface FormMetaDataReader {

    public InputStream getFormMetaData(String type, String name) throws BusinessException;
}
