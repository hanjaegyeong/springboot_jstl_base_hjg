package com.example.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.model.Post;
import com.example.board.model.Reserve;

@Service
public class Reserveservice {

    @Autowired
    SqlSession sqlSession;

    public void save(Post post) {
        if (post.getBoardId() == null) {
            sqlSession.insert("reserve.insert", post);
        } else {
            sqlSession.update("reserve.update", post);
        }
    }

    public List<Reserve> findAll(long id) {
        return null;
    }
    
}
