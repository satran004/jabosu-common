package org.jabosu.common.util;

import com.google.common.collect.Lists;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;

/**
 *
 * @author satya
 */
public class YmlLoader {

//    /**
//     * Load a Yaml file from the classpath.
//     */
//    public static Object loada(String resourceName) {
//        return load(
//                play.Play.application().resourceAsStream(resourceName),
//                play.Play.application().classloader()
//        );
//    }
    
    /**
     * Load a Yaml file from the classpath.
     */
    public static Object load(String resourceName) {
        return load(
                YmlLoader.class.getClassLoader().getResourceAsStream(resourceName),
                YmlLoader.class.getClassLoader()
        );
    }

    public static Object load(String resourceName, ClassLoader classLoader) {
        return load(
                YmlLoader.class.getClassLoader().getResourceAsStream(resourceName),
                classLoader
        );
    }
    
    public static <T> T loadAs(String resourceName, Class<T> clazz) {
        CustomClassLoaderConstructor classLoaderConstructor = 
                new CustomClassLoaderConstructor(clazz, clazz.getClassLoader());
        
        Yaml yaml = new Yaml(classLoaderConstructor);
        return (T)yaml.load(YmlLoader.class.getClassLoader().getResourceAsStream(resourceName));
       
    }
    
    public static <T> T loadAs(InputStream is, Class<T> clazz) {
        CustomClassLoaderConstructor classLoaderConstructor = 
                new CustomClassLoaderConstructor(clazz, clazz.getClassLoader());
        
        Yaml yaml = new Yaml(classLoaderConstructor);
        return (T)yaml.load(is);
       
    }
    
    public static List loadList(String resourceName, Class clazz) {
        
        CustomClassLoaderConstructor classLoaderConstructor = 
                new CustomClassLoaderConstructor(clazz, clazz.getClassLoader());
        
        Yaml yaml = new Yaml(classLoaderConstructor);
        Iterable<Object> iterable = yaml.loadAll(
                YmlLoader.class.getClassLoader().getResourceAsStream(resourceName));
        
        return Lists.newArrayList(iterable);
        
    }
    
    /**
     * Load the specified InputStream as Yaml.
     *
     * @param classloader The classloader to use to instantiate Java objects.
     */
    public static Object load(InputStream is, ClassLoader classloader) {
        org.yaml.snakeyaml.Yaml yaml = new org.yaml.snakeyaml.Yaml(new CustomClassLoaderConstructor(classloader));
        return yaml.load(is);
    }
    
    public static List loadList(InputStream is, Class clazz) {
        CustomClassLoaderConstructor classLoaderConstructor = 
                new CustomClassLoaderConstructor(clazz, clazz.getClassLoader());
        
        Yaml yaml = new Yaml(classLoaderConstructor);
        Iterable<Object> iterable = yaml.loadAll(is);
        
        return Lists.newArrayList(iterable);
    }

}
