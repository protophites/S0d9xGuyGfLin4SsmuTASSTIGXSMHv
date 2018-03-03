package me.protophite.core.data.sql;

import me.protophite.core.data.Database;

public class DataSQL implements Database {

    private SQL sql;

    public DataSQL(){
        sql = SQL.getSQL();
    }

    @Override
    public void set(String who, String where, Object what) {

    }

    @Override
    public Object get(String who, String where) {
        return null;
    }

    @Override
    public void save() {

    }
}
