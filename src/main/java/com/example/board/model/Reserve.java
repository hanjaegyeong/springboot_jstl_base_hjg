package com.example.board.model;

import javax.validation.constraints.NotEmpty;

public class Reserve {
    private Long id;

    @NotEmpty(message = "예약자명을 입력해주세요.")
    private String reserver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReserver() {
        return reserver;
    }

    public void setReserver(String reserver) {
        this.reserver = reserver;
    }
    
}
