package org.jabosu.common.services.impl;

import com.typesafe.config.Config;
import org.jabosu.common.services.api.ConfigService;
import com.typesafe.config.ConfigFactory;

import java.util.List;

public class ConfigServiceImpl implements ConfigService {

    private Config config;

    public ConfigServiceImpl() {
        config = ConfigFactory.load();
    }

    @Override
    public boolean getBoolean(String string) {
        return config.getBoolean(string);
    }

    @Override
    public Number getNumber(String string) {
        return config.getNumber(string);
    }

    @Override
    public int getInt(String string) {
        return config.getInt(string);
    }

    @Override
    public long getLong(String string) {
        return config.getLong(string);
    }

    @Override
    public double getDouble(String string) {
        return config.getDouble(string);
    }

    @Override
    public String getString(String string) {
        return config.getString(string);
    }

    @Override
    public List getStringList(String key) {
        return config.getList(key);
    }

    @Override
    public List getList(String key) {
        return config.getList(key);
    }
}
