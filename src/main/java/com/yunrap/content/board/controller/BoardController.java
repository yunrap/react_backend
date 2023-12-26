package com.yunrap.content.board.controller;

import com.yunrap.content.board.service.BoardService;
import com.yunrap.content.board.vo.BoardVo;
import com.yunrap.error.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    /**
     * 게시글 목록 조회
     *
     * @return
     * @throw Exception
     */
    @GetMapping("")
    public ModelAndView index(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        System.out.println("board page controller log");
        mv.setViewName("board");

        return mv;
    }

    /**
     * 게시글 상세 조회
     *
     * @param boardSeq
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/{boardSeq}")
    @ResponseBody
    public BoardVo getBoardDetail(@PathVariable("boardSeq") int boardSeq) throws Exception {

        System.out.println("boardSeq" + boardSeq);
        BoardVo boardVo = boardService.getBoardDetail(boardSeq);

        if (boardVo == null) {
            throw new ResourceNotFoundException();
        }

        return boardVo;
    }

    /**
     * 게시글 등록
     *
     * @param boardVo
     * @return
     * @throws Exception
     */
    @PostMapping(value="/insertBoard")
    public void insertBoard(@ModelAttribute BoardVo boardVo) throws Exception {

        boardService.insertBoard(boardVo);

    }


}
