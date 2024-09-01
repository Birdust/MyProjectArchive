package com.ict01.mybatisproject.domain;

import lombok.Data;

import java.util.Date;

@Data
// result 용으로 사용
public class Article {

  private int articleId;
  private String title;
  private String contents;
  private Date regDate;

}
