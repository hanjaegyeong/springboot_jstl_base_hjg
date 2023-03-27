package com.example.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.example.board.model.Comment;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final SqlSession sqlSession;

    /**
     * 댓글 저장
     * @param content
     * @param boardId
     */
    public void save(String content, Long boardId){
        System.out.println("댓글저장 in service: " + content);

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setBoardId(boardId);

        sqlSession.insert("comment.insert", comment);
    }
    
    /**
     * 해당 게시글에 대해 모든 댓글 조회
     * @param boardId
     * @return
     */
    public List<Comment> findAll(Long boardId){
        
        List<Comment> comments = sqlSession.selectList("comment.comments", boardId);

        System.out.println("댓글개수 in service: " + comments.size());

        return comments;
    }
}