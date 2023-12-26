package com.yunrap.content.board.vo;

import lombok.Data;

@Data
public class BoardFile {

    int boardSeq;
    int fileNo;
    String fileNameKey;
    String fileName;
    String filePath;
    String fileSize;
    String remark;
    String delYn;
    String insUserId;
    String insDate;
    String updUserId;
    String updDate;

}
