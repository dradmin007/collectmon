package ru.maktor.config;

import java.util.HashMap;

public class DbConf {

    private final HashMap<String, String> conf = new HashMap<String, String>();

    public DbConf() {
        try {
            conf.put("DB_NAME",( System.getenv("DB_NAME") == null) ? "ssmpkasu.medkirov.ru": System.getenv("DB_NAME") );
            conf.put("DB_HOST",( System.getenv("DB_HOST") == null) ? "192.168.50.30": System.getenv("DB_HOST") );
            conf.put("DB_PORT",( System.getenv("DB_PORT") == null) ? "1521": System.getenv("DB_PORT") );
            conf.put("DB_USER",( System.getenv("DB_USER") == null) ? "kasu": System.getenv("DB_USER") );
            conf.put("DB_PASSWD",( System.getenv("DB_PASSWD") == null) ? "kasu123": System.getenv("DB_PASSWD") );

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public HashMap<String,String> getConf() {
        return conf;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
