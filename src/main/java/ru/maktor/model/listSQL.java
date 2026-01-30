package ru.maktor.model;


import java.util.HashMap;

public class listSQL {

    private static HashMap<String, String> sql = new HashMap<String, String>();


    public listSQL() {
        sql.put("CheckSeq",
                "select sequence_name, last_number from user_sequences a where a.sequence_name = 'KARTA_SEQ_OBR'");
        //-- бригад на линии
        sql.put("CheckBrOnline",
                "select count(*) from brigada where a130 > 0");
        //-- количество вызовов по состоянию
        sql.put("CheckOrders",
                "select e030, get_dic(15,e030) as sost, count(*) from karta where a020 > sysdate - 10/1440 group by e030");
        //--идентификация
        sql.put("ChekIdentResErrors",
                "select count(*) from ecp_indent_patients_results t where t.dt > sysdate - 10/1440 and t.result_code < 0");
        sql.put("ChekIdentResPass",
                "select count(*) from ecp_indent_patients_results t where t.dt > sysdate - 10/1440 and t.result_code = 0");
        //-- передача ЭКВ на другую площадку
        sql.put("ChekEkvResErrors",
                "select t.result_code, count(*) from ekv_karta_xml t where t.dt > sysdate - 10/1440 and t.result_code != 0");
        sql.put("ChekEkvResPass",
                "select t.result_code, count(*) from ekv_karta_xml t where t.dt > sysdate - 10/1440 and t.result_code = 0");
        //-- передача вызовов в МИАЦ (сигнальные листки)
        sql.put("CheckMiasErrors",
                "select t.status, count(*) from mias_transfer t where t.dt > sysdate - 10/1440 and t.status != 1");
        sql.put("CheckMiasPass",
                "select t.status, count(*) from mias_transfer t where t.dt > sysdate - 10/1440 and t.status = 1");
         //-- прием вызвов 112
        sql.put("Check112Pass","select count(*) as cnt from k112_karta where dt > sysdate - 10/1440");

    }

    public static void setSql(HashMap<String, String> sql) {
        listSQL.sql = sql;
    }

    public static HashMap<String, String> getSql() {
        return sql;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
