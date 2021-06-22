package com.example.project.controller.member;

import com.example.project.entity.Member;
import com.example.project.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/registerMember")
    public String getRegisterMember (Member member, Model model) {
        log.info("getRegisterMember()");

        return "/member/register";
    }

    @PostMapping("/registerMember")
    public String postRegisterMember (Member member, Model model) throws Exception {
        log.info("postRegisterMember()");
        log.info("member: " + member);

        service.registerMember(member);

        model.addAttribute("msg","등록이 완료되었습니다!");

        return "/member/success";
    }
}
