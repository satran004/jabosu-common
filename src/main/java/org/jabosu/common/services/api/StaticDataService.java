package org.jabosu.common.services.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jabosu.common.Category;
import org.jabosu.common.City;

/**
 *
 * @author satya
 */
public interface StaticDataService {
    
    Object load(String path);

    Object load(String path, ClassLoader classLoader);

    List loadList(String path, Class clazz);
    
    <T> T loadAs(String path, Class<T> clazz);

    Collection<String> areas(String country, String city);

    Collection<Category> categories();

    List<String> categoryBanner(String categoryCode);

    String categoryThumbnail(String categoryCode);

    Collection<String> cityNames(String country);
    
    Collection<String> cityNames(String country, boolean includeMetroCities);
    
    Collection<City> cities(String country);
    
    Collection<City> cities(String country, boolean includeMetroCities);
    
    City getCity(String country, String city);

    Map<String, String> countries();

    Map<String, String> countriesISO();

    String decodeCity(String countryCode, String city);

    String defaultBanner();

    String cdnBase();
    
    String defaultProfileCoverPhoto();
    
    String defaultProfileThumbnail();

    List<String> featuredCategories();

    Category getCategory(String categoryCode);

    Category getCategoryByUrl(String url);

    String getCategoryDesc(String categoryCode);

    String getCategoryType(String category);

    String getCountry(String isoCode);

    String getCountryISOCode(String country);

    String getDateFormat();

    String getDateTimeFormat();

    List<Category> getSubcategories(String categoryCode);

    String getTimeZone(String country);
    
    String getCurrency(String country);

    String indexBanner();

    boolean isEstablishment(String category);

    boolean isValidCountryCode(String countryCode);

    String isoCountry(String country);

    String normalizeCity(String city);

    Map<String, String> statusList();
    
    String getLabel(String key);

    Object getProperty(String key);
}
