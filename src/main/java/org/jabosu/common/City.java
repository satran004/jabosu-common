package org.jabosu.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author satya
 */
public class City {
    public String name;
    public boolean isMetro;
    public boolean isSubcity;
    public String metroCityName;
    public Map<String, String> areas;
    public Map<String, City> cities;
    private Collection<String> _subCityNames;
    
    public Collection<String> getSubCities() {
        if(!isMetro)
            return Collections.EMPTY_LIST;
        
        if(_subCityNames == null) {
            if(cities != null && cities.size() != 0)
                _subCityNames = cities.values().stream().map(city -> city.name).collect(Collectors.toList());
            
            if(_subCityNames == null) _subCityNames = new ArrayList(0);
        }
     
        return _subCityNames;
    }
    
}
