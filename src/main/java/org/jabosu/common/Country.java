package org.jabosu.common;

import org.jabosu.common.util.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author satya
 */
public class Country {
    public String country;
    public Map<String, City> cities;
    
    private Collection<String> _cityNames = new ArrayList();
    private Collection<String> _allCityNames = new ArrayList();
    
    private Map<String, City> _allCities = new HashMap();
    
    public Collection<String> getCityNames() {
        if(_cityNames == null || _cityNames.size() == 0) {
            init();
            _cityNames = cities.keySet();
        }
        
        return _cityNames;
    }
    
    public Collection<String> getAllCityNames() { //include metro cities
        if(_allCityNames == null || _allCityNames.size() == 0) {
            for(City city: cities.values()) {
                _allCityNames.add(city.name);
                if(city.isMetro) {
                    if(city.cities != null) {
                        for(Entry<String,City> subCityEntry: city.cities.entrySet()) {
                            City subCity = subCityEntry.getValue();
                            if(subCity.name == null) {
                                subCity.name = subCityEntry.getKey();
                            }
                            _allCityNames.add(subCity.name);
                        }
                    }
                    
                }
            }
        }
        
        return _allCityNames;
    }
    
    public Collection<City> getCities() {
        return cities.values();
    }
    
    private void init() {
        if(_allCities == null || _allCities.size() == 0) { //flattern all cities
            for(City city: cities.values()) {
                if(StringUtil.isEmpty(city.name))
                    continue;
                
                _allCities.put(city.name.toLowerCase(),city);
                if(city.isMetro) {
                    if(city.cities != null) {
                        for(City subCity: city.cities.values()) {
                            if(!StringUtil.isEmpty(subCity.name)) {
                                
                                subCity.isSubcity = true; //subcity
                                subCity.metroCityName = city.name; //set metro city name
                                        
                                _allCities.put(subCity.name.toLowerCase(), subCity);
                            }
                        }
                    }
                        
                }
            }
        }
        
    }
    
    public City getCity(String cityName) {
        if(StringUtil.isEmpty(cityName))
            return null;
        
        return _allCities.get(cityName.toLowerCase());
    }
    
    public Collection<String> getAreas(String cityName) {
        init();
       
        City city = getCity(cityName);
        if(city == null || city.areas == null) return Collections.EMPTY_LIST;
        
        return city.areas.keySet();
    }
    
    public Collection<City> getAllCities() {
        if(_allCities == null || _allCities.size() == 0) {
            init();
        }
        return _allCities.values();
    }
}

