package com.example.board.service;

import javax.servlet.http.HttpSession;
import com.example.board.controller.dto.MemberDTO;

public interface MemberService {
 public String loginCheck(MemberDTO dto, HttpSession session);
 public void logout(HttpSession session);
}