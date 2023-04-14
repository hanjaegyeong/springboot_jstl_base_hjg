package com.example.board.controller.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.controller.dto.MemberDTO;

@Repository // 현재 클래스를 dao bean으로 등록
public class MemberDAOImpl implements MemberDAO {

@Autowired
SqlSession sqlSession; // SqlSession 의존관계 주입

@Override
public String loginCheck(MemberDTO dto) {
return sqlSession.selectOne("member.login_check", dto);
 }
}