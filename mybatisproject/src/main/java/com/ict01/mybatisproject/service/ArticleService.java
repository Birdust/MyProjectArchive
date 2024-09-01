package com.ict01.mybatisproject.service;

import com.ict01.mybatisproject.domain.Article;
import com.ict01.mybatisproject.repository.ArticleRepository;
import com.ict01.mybatisproject.parameter.ArticleParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Article Service
 * @Author : M.H.LEE
 */
@Service
public class ArticleService {

  @Autowired
  private ArticleRepository articleRepository;

  /**
   * 전체 게시판 목록 조회 return
   * @return
   */
  public List<Article> getList() {
    return articleRepository.getList();
  }

  /**
   * 상세 게시판 조회 return
   * @return
   */
  public Article get(int articleId){
    return articleRepository.get(articleId);
  }

  /**
   * 게시판 등록/수정
   * @param parameter
   * @return
   */
  public void save(ArticleParameter parameter) {
    // 조회하여 return된 정보
    Article article = articleRepository.get(parameter.getArticleId());

    if(article == null) {
      articleRepository.save(parameter);
    } else {
      articleRepository.update(parameter);
    }
  }

//  /**
//   * 게시판 갱신 처리
//   * @param article
//   */
//  public void update(Article article) {
//    articleRepository.update(article);
//  }

  /**
   * 개시판 삭체 처리
   * @param articleId
   */
  public void delete(int articleId) {
    articleRepository.delete(articleId);
  }
}
