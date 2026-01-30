package ru.maktor;

import ru.maktor.config.DbConf;
import ru.maktor.database.connOra;
import ru.maktor.model.listSQL;

import java.sql.Connection;
import java.util.HashMap;

public class Main {

    public static HashMap<String, String> sql;
    public static listSQL l_sql;
    public static DbConf conf;

    public static void main(String[] args) {
        l_sql = new listSQL();
        sql = listSQL.getSql();
        conf = new DbConf();
        //conf.getConf().forEach((k, v) -> System.out.println(k + " = " + v));

        System.out.println(conf.getConf().get("DB_NAME"));

        connOra dbconn = new connOra(conf);
        try {
            dbconn.connect();
        } catch (Exception e) {
            System.out.println("Connect error: " + e.toString());
        }


        //listSQL.getSql().forEach((k, v) -> System.out.println(k + " -> " + v));

        //for (String key : sql.keySet()
        //     ) {
        //    System.out.println(key + ": " + sql.get(key));
       // }
    }
}