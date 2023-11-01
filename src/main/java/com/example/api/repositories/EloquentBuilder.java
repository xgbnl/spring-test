package com.example.api.repositories;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.TransactionFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
final class EloquentBuilder implements Builder {
    @Override
    public SqlSession query() {
        return null;
    }


}
