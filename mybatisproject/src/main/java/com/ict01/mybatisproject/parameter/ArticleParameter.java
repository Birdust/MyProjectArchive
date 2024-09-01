package com.ict01.mybatisproject.parameter;

import lombok.Data;

@Data
// 등록 /수정할 때 사용
public class ArticleParameter {

  private int articleId;
  private String title;
  private String contents;

}
