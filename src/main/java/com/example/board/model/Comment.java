package com.example.board.model;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id; //식별자
    private Long boardId; //게시물id
    private String content; //내용
    private Date createdAt; //생성일
    private Date updatedAt; //수정일

    Comment(Long boardId, String content){
        this.boardId = boardId;
        this.content = content;
    }
}