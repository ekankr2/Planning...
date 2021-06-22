package com.example.project.service;

import com.example.project.entity.Member;
import com.example.project.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public void registerMember(Member member) throws Exception {
        repository.create(member);

    }

}
