package com.example.project.controller.member;

import com.example.project.entity.Member;
import com.example.project.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/member")
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
    @GetMapping("/login")
    public String getLogin (Member member, Model model) {
        log.info("getLogin()");

        return "/member/login";
    }

    @PostMapping("/login")
    public String postLogin (Member member, Model model) throws Exception {
        log.info("postLogin(): " + member);

        service.login(member);

        model.addAttribute("msg", "로그인 성공!");

        return "/member/success";
    }
    @GetMapping("/lists")
    public String getLists (Model model) throws Exception {
        log.info("getLists(): " + service.list());

        model.addAttribute("member", service.list());

        return "/member/lists";
    }
}
