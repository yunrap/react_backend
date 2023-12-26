package com.yunrap.content.board.dao;

import com.yunrap.content.board.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardDao {

    /**
     * 게시글 목록 조회
     *
     * @return
     * @throws
     */
    List<BoardVo> getBoardList();

    /**
     * 게시글 목록 조회
     *
     * @param boardSeq
     * @return
     * @throws Exception
     */
    public BoardVo getBoardDetail(int boardSeq) throws Exception;

    /**
     * 게시글 등록
     *
     * @param boardVo
     * @return
     * @throws Exception
     */
    public int insertBoard(BoardVo boardVo) throws Exception;

    /**
     * 게시글 수정
     *
     * @param boardVo
     * @return
     * @throws Exception
     */
    public int updateBoard(BoardVo boardVo) throws Exception;

    /**
     * 게시글 삭제
     *
     * @param boardSeq
     * @return
     * @throws Exception
     */
    public int deleteBoard(int boardSeq) throws Exception;

}
