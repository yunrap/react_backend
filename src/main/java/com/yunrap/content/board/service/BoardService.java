package com.yunrap.content.board.service;

import com.yunrap.content.board.dao.BoardDao;
import com.yunrap.content.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;

    /**
     * 게시글 목록 조회
     *
     * @return
     * @throw Exception
     */
    public List<BoardVo> getBoardList() throws Exception {
        List<BoardVo> boardList =  boardDao.getBoardList();
        return boardList;
    }

    /**
     * 게시글 상세 조회
     *
     * @param boardSeq
     * @return
     * @throws Exception
     */
    public BoardVo getBoardDetail(int boardSeq) throws Exception
    {
        return boardDao.getBoardDetail(boardSeq);
    }

    /**
     * 게시글 등록
     *
     * @param boardVo
     * @return
     * @throws Exception
     */
    public int insertBoard(BoardVo boardVo) throws Exception{
        return boardDao.insertBoard(boardVo);
    };


    /**
     * 게시글 및 첨부파일 등록
     *
     * @param board
     * @return
     * @throws Exception
     */
    public int insertBoardFiles(BoardVo board, MultipartFile[] files) throws Exception {
        int insertCount = 0;
//        insertCount = boardDao.insertBoard(board);
        return insertCount;
    }

}
