package org.jabosu.common.util;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

/**
 *
 * @author satya
 */
public class InjectorHelper {

    private Injector INJECTOR;
    private static InjectorHelper instance;

    private InjectorHelper() {
    }

    public static InjectorHelper getInstance() {
        if (instance == null) {
            synchronized (InjectorHelper.class) {
                if (instance == null) {
                    instance = new InjectorHelper();
                }
            }
        }

        return instance;
    }

    public void setInjector(Injector injector) {
        this.INJECTOR = injector;
    }

    public <T> T getBean(Class<T> t) {
        return INJECTOR.getInstance(t);
    }
    
    public <T> T getBean(Class<T> t, String name) {
        if(name == null)
            return null;
        
        return INJECTOR.getInstance(Key.get(t, Names.named(name)));
    }
}
