package com.example.api.repositories;

import org.apache.ibatis.session.SqlSession;

interface Builder {
    SqlSession query();
}
