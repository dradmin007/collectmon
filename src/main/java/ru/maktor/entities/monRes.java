package ru.maktor.entities;

public class monRes {

    public static String monCnt;

    public monRes() {
        monCnt = "";
    }

    public String getMonCnt() {
        return monCnt;
    }

    public static void setMonCnt(String monCnt) {
        monRes.monCnt = monCnt;
    }
}
