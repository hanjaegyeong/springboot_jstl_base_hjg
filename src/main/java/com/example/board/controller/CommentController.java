package com.example.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.controller.dto.PostCommentReq;
import com.example.board.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("")
    public String saveComment(@Valid PostCommentReq postCommentReq){
        System.out.println("댓글 입력 api 호출: " + postCommentReq.getContent());
        

        return "redirect:/";
    }

    @PostMapping("/{id:\\d+}")
    public String saveComment(@PathVariable(name="id") long boardId, @Valid PostCommentReq postCommentReq){
        System.out.println("댓글 입력 api 호출-내용: " + postCommentReq.getContent());
        System.out.println("댓글 입력 api 호출-boardId: " + boardId);

        commentService.save(postCommentReq.getContent(), boardId); //댓글 저장

        return "redirect:/read/{id}";
    }
    
}