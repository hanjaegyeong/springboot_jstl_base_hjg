package com.example.board.service;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.controller.dao.MemberDAO;
import com.example.board.controller.dto.MemberDTO;

@Service // service bean으로 등록
public class MemberServiceImpl implements MemberService {

@Autowired
MemberDAO memberDao;

@Override
public String loginCheck(MemberDTO dto, HttpSession session) {
String name = memberDao.loginCheck(dto);
 if (name != null) { // 세션 변수 저장
  session.setAttribute("userid", dto.getUserid());
  session.setAttribute("name", name);
}
 return name; 
}

@Override
public void logout(HttpSession session) {
 session.invalidate(); // 세션 초기화
 }
}