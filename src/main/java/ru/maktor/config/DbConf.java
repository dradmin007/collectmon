package ru.maktor.config;

import java.util.HashMap;

public class DbConf {

    private final HashMap<String, String> conf = new HashMap<String, String>();

    public DbConf() {
        try {
            if (System.getenv("DB_NAME") == null) {
                throw new RuntimeException("DB_NAME is not set!");
            } else {
                conf.put("DB_NAME", System.getenv("DB_NAME"));
            }
            if (System.getenv("DB_HOST") == null) {
                throw new RuntimeException("DB_HOST is not set!");
            } else {
                conf.put("DB_HOST",System.getenv("DB_HOST") );
            }
            if (System.getenv("DB_PORT") == null) {
                throw new RuntimeException("DB_PORT is not set!");
            } else {
                conf.put("DB_PORT",System.getenv("DB_PORT") );
            }
            if (System.getenv("DB_USER") == null) {
                throw new RuntimeException("DB_USER is not set!");
            } else {
                conf.put("DB_USER",System.getenv("DB_USER") );
            }
            if (System.getenv("DB_PASSWD") == null) {
                throw new RuntimeException("DB_PASSWD is not set!");
            } else {
                conf.put("DB_PASSWD",System.getenv("DB_PASSWD") );
            }

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public HashMap<String,String> getConf() {
        return conf;
    }

    public String getByName(String confName) {
        return conf.get(confName).isEmpty() ? "" : conf.get(confName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
