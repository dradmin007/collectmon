package ru.maktor.database;

import ru.maktor.config.DbConf;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;


public class connOra {


    private final String urlDb;
    private static Connection dbconn;
    private static String user;
    private static String passwd;

    public connOra(DbConf conf) {

        /*
        *                 Class.forName("oracle.jdbc.driver.OracleDriver");
        *
        * */
        urlDb = "jdbc:oracle:thin:@//" + conf.getConf().get("DB_HOST") + ":" + conf.getConf().get("DB_PORT") +
                        "/" + conf.getConf().get("DB_NAME");


        user = conf.getByName("DB_USER");
        passwd = conf.getByName("DB_PASSWD");
    }

    public Connection connect()  throws SQLException {

       try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           dbconn = getConnection(urlDb, user, passwd);
       } catch (SQLException e) {
           System.out.println("Error connect to DB : (" + urlDb + ")\n\n error : " + e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }

        return dbconn;
    }


}
