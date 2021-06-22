package com.example.project.repository;

import com.example.project.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) throws Exception{
        //(email, password, name, phoneNum)
        String query = "insert into member (email, password, name, phoneNum) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, member.getEmail(), member.getPassword(), member.getName(),
                member.getPhoneNum());
    }
}
