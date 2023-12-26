package com.yunrap.content.board.vo;


import lombok.Data;

@Data
public class BoardVo {

    int boardSeq;
    int boardReRef;
    int boardReLev;
    int boardReSeq;
    String boardWriter;
    String boardSubject;
    String boardContent;
    int boardHits;
    String delYn;
    String insUserId;
    String insDate;
    String updUserId;
    String updDate;

}
