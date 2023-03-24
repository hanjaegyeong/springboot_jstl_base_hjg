package com.example.board.controller;

import com.example.board.controller.dto.PageRequest;
import com.example.board.controller.dto.PostPage;
import com.example.board.model.Post;
import com.example.board.model.Reserve;
import com.example.board.service.BoardService;
import com.example.board.service.Reserveservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.validation.Valid;

/*
    사용자 리퀘스트 처리
 */
@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @Autowired
    Reserveservice reserveservice;

    @GetMapping("")
    public String list(PageRequest pageRequest, Model model) {
        PostPage page = boardService.getPage(pageRequest);
        model.addAttribute("page", page);
        return "list"; // WEB-INF/list.jsp 템플릿 호출
    }
    @GetMapping("/test2")
    public String list2(PageRequest pageRequest, Model model) {
        PostPage page = boardService.getPage(pageRequest);
        model.addAttribute("page", page);
        return "list2"; // WEB-INF/list.jsp 템플릿 호출
    }

    @GetMapping("/read/{id:\\d+}")
    public String read(@PathVariable long id, Model model) {
        Post post = boardService.findById(id);
        //List<Reserve> reserve = reserveservice.findAll(id);
        model.addAttribute("post", post);
        //model.addAttribute("reserve", reserve);
        return "detail";
    }

    @GetMapping("/delete/{id:\\d+}")
    public String delete(@PathVariable long id) {
        boardService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping({"/form", "/form/{id:\\d+}"})
    public String form(@PathVariable(required = false) Long id, Model model) {
        Post post = null;
        if (id != null) { // 수정이라면 게시글 조회
            post = boardService.findById(id);
        }
        if (post == null) {
            post = new Post();
        }
        model.addAttribute("post", post);
        return "form";
    }

    /**
     * 게시글 저장
     * @param post
     * @param result 검증 오류가 발생할 경우 오류 내용을 보관
     * @return
     */
    @PostMapping("/save")
    public String save(@Valid Post post, BindingResult result) {
        if (result.hasErrors()) { // 검증 오류 발생
            return "form";
        }
        boardService.save(post);
        return "redirect:/";
    }
}
