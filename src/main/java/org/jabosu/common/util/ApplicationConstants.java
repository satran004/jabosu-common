package org.jabosu.common.util;

/**
 *
 * @author satya
 */
public class ApplicationConstants {

    public static final String FLASH_MESSAGE_KEY = "message";
    public static final String FLASH_ERROR_KEY = "error";
    public static final String FLASH_INFO_KEY = "info";
    public static final String FLASH_WARNING_KEY = "warning";

    public static final String REDIS_DATA_SERIALIZER_CLASS_KEY = "redis.session.data.serializer";

    public static final String COUNTRY_COOKIE = "country";
    public static final String CITY_COOKIE = "city";

    //category type
    public static final String CATEGORY_TYPE_ESTABLISHMENT = "establishment";
    public static final String CATEGORY_TYPE_OTHERS = "others";

    //User type
    public static final String USER_TYPE = "USER";
    public static final String VENDOR_TYPE = "VENDOR";

    //for s3 buckets
    public final static String GLOBAL_BUCKET_PREFIX = "global";
    public final static String FILE_BUCKET_PROTOCOL = "http://";


    //Property constants
    public static String DEFAULT_COUNTRY_KEY = "default_country";
}
