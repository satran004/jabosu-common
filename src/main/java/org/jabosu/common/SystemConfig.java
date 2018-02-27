package org.jabosu.common;

import org.jabosu.common.services.api.StaticDataService;
import org.jabosu.common.util.Messages;
import org.jabosu.common.util.ServiceStatus;
import com.google.inject.Inject;
import java.util.Map;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class SystemConfig {
    
    private static StaticDataService staticDataService;

    private static String defaultCountry;

    @Inject
    public SystemConfig(StaticDataService staticLoaderService) {
        staticDataService = staticLoaderService;
    }
    
    public static String indexBanner() {
        return staticDataService.indexBanner();
    }
    
    public static String defaultBanner() {
        return staticDataService.defaultBanner();
    }

    public static String cdnBase() {return staticDataService.cdnBase();}
    
    public static List<String> categoryBanner(String categoryCode) {
        return staticDataService.categoryBanner(categoryCode);
    }
    
    public static String categoryThumbnail(String categoryCode) {
        return staticDataService.categoryThumbnail(categoryCode);
    }
    
    public static String defaultProfileCoverPhoto() {
        return staticDataService.defaultProfileCoverPhoto();
    }
    
    public static String defaultProfileThumbnail() {
        return staticDataService.defaultProfileThumbnail();
    }
    
    public static Collection<Category> categories() {
        return staticDataService.categories();
    }
    
    public static Category getCategory(String categoryCode) {
        return staticDataService.getCategory(categoryCode);
    }

    public static Category getCategoryByUrl(String url) {
        return staticDataService.getCategoryByUrl(url);
    }
    
    public static List<Category> getSubcategories(String categoryCode) {
        return staticDataService.getSubcategories(categoryCode);
    }
    
    public static boolean isEstablishment(String category) {
        return staticDataService.isEstablishment(category);
    }

    public static Map<String, String> countries() {
        return staticDataService.countries();
    }

    public static Map<String, String> countriesISO() {
        return staticDataService.countriesISO();
    }
    
    public static String getCountry(String isoCode) {
        return staticDataService.getCountry(isoCode);
    }
    
    public static String getCountryISOCode(String country) {
        String countryCode = staticDataService.getCountryISOCode(country);
        if(countryCode == null)
            return "";
        else
            return countryCode;
    }
    
    public static String isoCountry(String country) {
        return staticDataService.isoCountry(country);
    }
    
    public static boolean isValidCountryCode(String countryCode) {
        return staticDataService.isValidCountryCode(countryCode);
    }

    public static String getCategoryType(String category) {
        return staticDataService.getCategoryType(category);
    }
    
    public static String getCategoryDesc(String categoryCode) {
        return staticDataService.getCategoryDesc(categoryCode);
    }          
    
    public static Collection<String> cityNames(String country) {
       return staticDataService.cityNames(country);
    }
    
    public static Collection<String> cityNames(String country, boolean includeMetroCities) {
       return staticDataService.cityNames(country, includeMetroCities);
    }
    
    public static Collection<City> cities(String country) {
       return staticDataService.cities(country);
    }
    
    public static Collection<City> cities(String country, boolean includeMetroCities) {
       return staticDataService.cities(country, includeMetroCities);
    }
    
    public static City getCity(String country, String city) {
        return staticDataService.getCity(country, city);
    }
    
    public static Collection<String> areas(String country, String city) {
        return staticDataService.areas(country, city);    
    }
    
    public static Map<String, String> statusList() {
        return staticDataService.statusList();
    }
    
    public static String getTimeZone(String country) {
        return staticDataService.getTimeZone(country);
    }
    
    public static String getCurrency(String country) {
        return staticDataService.getCurrency(country);
    }
    
    public static String getDateFormat() {
        return staticDataService.getDateFormat();
    }
    
    public static String getDateTimeFormat() {
        return staticDataService.getDateTimeFormat();
    }
    
    public static List<String> featuredCategories() {
        return staticDataService.featuredCategories();
    }
    
    public static String decodeCity(String countryCode, String city) {
        return staticDataService.decodeCity(countryCode, city);
        
    }
    
    public static String normalizeCity(String city) {
        if(city == null)
            return null;

        return city.toLowerCase().replaceAll(" ", "-");
    }

    public static String denormalizeCity(String normalizeCity) {
        return normalizeCity.replaceAll("-", " ");
    }
    
    public static boolean isMetroCity(String country, String city) {
        City cityObj = getCity(country, city);
        if(cityObj == null)
            return false;
        else
            return cityObj.isMetro;
    }
    
    public static Collection<String> getSubCities(String country, String city) {
        City cityObj = getCity(country, city);
        if(cityObj == null)
            return Collections.EMPTY_LIST;
        
        if(!cityObj.isMetro)
            return Collections.EMPTY_LIST;
        else
            return cityObj.getSubCities();
    }

    public static String getCountryName(String urlCountry) {
         String country = null;
         if(urlCountry.length() == 2)  {//ISO country code. So find the country
            country = SystemConfig.getCountry(urlCountry);
        } else if(urlCountry.length() > 2) {
            country = urlCountry;
        }
         
        return country; 
    }
    
    public static String getCityName(String urlCountry, String urlCity) {
        String city = null;
        if(urlCountry.length() == 2)  {//ISO country code. So decode the city.
            city = SystemConfig.decodeCity(urlCountry, urlCity);
        } else {
            city = urlCity;
        }
        
        return city;
    }
    
    public static String getProfileStatusDesc(String statusCode) {
        switch(statusCode) {
            case ServiceStatus.PUBLISHED:
                return Messages.get("service.status.published");
            case ServiceStatus.NOT_PUBLISHED:
                return Messages.get("service.status.not_published");
            case ServiceStatus.DELETED:
                return Messages.get("service.status.deleted");
        }
        
        return "";
    }
    
    public static String getLabel(String key) {
        String label = staticDataService.getLabel(key);
        if(label == null) return "";
        else
            return label;
    }

    public static Object getProperty(String key) {
        return staticDataService.getProperty(key);
    }
}
