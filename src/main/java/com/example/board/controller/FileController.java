package com.example.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
    @RequestMapping("/file/{boardId}/upload.do")
    public String uploadFile(@PathVariable("boardId") Long boardId, MultipartFile[] upload, HttpServletRequest request) {

        //파일이 업로드 될 경로 설정
        String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file/" + boardId);

        //위에서 설정한 경로의 폴더가 없을 경우 생성
        File dir = new File(saveDir);
        if(!dir.exists()) {
            dir.mkdirs();
        }

        // 파일 업로드
        for(MultipartFile f : upload) {
            if(!f.isEmpty()) {
                // 기존 파일 이름을 받고 확장자 저장
                String orifileName = f.getOriginalFilename();
                String ext = orifileName.substring(orifileName.lastIndexOf("."));

                // 파일 저장
                // boardId 포함된 루트로 각각 저장
                try {
                    f.transferTo(new File(saveDir + "/" + "img" + ext));
                }catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    return "redirect:/";
    }
}