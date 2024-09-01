package com.ict01.mybatisproject.repository;

import com.ict01.mybatisproject.domain.Article;
import com.ict01.mybatisproject.parameter.ArticleParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Article Repository
 * @ Author : M.H. Lee
 */
@Repository
public interface ArticleRepository {

  List<Article> getList();

  Article get(int articleId);
  void save(ArticleParameter article);

  void update(ArticleParameter article);

  void delete(int articleId);
}
