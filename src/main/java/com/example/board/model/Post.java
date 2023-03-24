package com.example.board.model;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Post {
    private Long boardId;

    @NotEmpty(message = "제목을 입력하여 주세요.")
    private String title;

    @NotEmpty(message = "내용을 입력하여 주세요.")
    private String content;
    
    private String nickname;

    private String address;

    private String area;

    public Long getBoardId() {
        return this.boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private Date createdAt;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
