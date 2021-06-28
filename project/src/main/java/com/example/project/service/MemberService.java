package com.example.project.service;

import com.example.project.entity.Member;

import java.util.List;

public interface MemberService {
    public void registerMember(Member member) throws Exception;
    public void login(Member member) throws Exception;
    public List<Member> list() throws Exception;
}
