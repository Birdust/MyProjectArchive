package com.ict01.mybatisproject.controller;

import com.ict01.mybatisproject.configuration.exception.BaseException;
import com.ict01.mybatisproject.configuration.http.BaseResponse;
import com.ict01.mybatisproject.configuration.http.BaseResponseCode;
import com.ict01.mybatisproject.domain.Article;
import com.ict01.mybatisproject.parameter.ArticleParameter;
import com.ict01.mybatisproject.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Log4j2
@Slf4j
@RestController
@RequestMapping("/article")
@Api(tags = "게시판 API")
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  /**
   * 전체 게시판 목록 조회 return
   * @return
   */
  @GetMapping("/")
  @ApiOperation(value = "전체 게시판 조회", notes = "게시판 전체 정보를 조회할 수 있습니다..")
  public BaseResponse<List<Article>> getList() {
    log.info("getList");
    return new BaseResponse<>(articleService.getList());
  }

  /**
   * 상세 게시판 조회 return
   * @return
   */
  @GetMapping("/{articleId}")
  @ApiOperation(value = "게시판 상세 조회", notes = "게시판 번호에 해당하는 상세정보를 조회할 수 있습니다..")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "articleId", value = "게시물 번호", example = "1")
  })
  public BaseResponse<Article> get(@PathVariable int articleId){
    Article article = articleService.get(articleId);
    if(article == null) {
      throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"게시물"});
    }
    return new BaseResponse<Article>(article);
  }

  /**
   * 게시판 등록 / 수정 처리
   * @param parameter
   * @return
   */
//  @GetMapping("/save")
//  public int save(Article parameter) {
//   articleService.save(parameter);
//   return parameter.getArticleId();
//  }

  @PutMapping("/save")
  @ApiOperation(value = "게시판 등록/수정 처리", notes = "신규 게시물 저장 및 수정할 수 있습니다..")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "articleId", value = "게시물 번호", example = "1"),
      @ApiImplicitParam(name = "title", value = "제목", example = "Spring Boot"),
      @ApiImplicitParam(name = "contents", value = "내용", example = "Spring Boot Practices..")
  })
  public BaseResponse<Integer> save(ArticleParameter parameter) {
    // 제목 필수 체크
    if(StringUtils.isEmpty(parameter.getTitle())) {
      throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "title", "제목"});
    }
    // 내용 필수 체크
    if(StringUtils.isEmpty(parameter.getContents())) {
      throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "contents", "내용"});
    }

    articleService.save(parameter);
    return new BaseResponse<Integer>(parameter.getArticleId());
  }

  /**
   * 개시판 삭체 처리
   * @param articleId
   */
//  @GetMapping("/delete/{articleId}")
//  public boolean delete(@PathVariable int articleId) {
//    Article article = articleService.get(articleId);
//    if(article == null) {
//      return false;
//    }
//    articleService.delete(articleId);
//    return true;
//  }

  @DeleteMapping("/{articleId}")
  @ApiOperation(value = "게시물 삭제 처리", notes = "게시물 번호에 해당하는 정보를 삭제할 수 있습니다..")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "articleId", value = "게시물 번호", example = "1"),
  })
  public BaseResponse<Boolean> delete(@PathVariable int articleId) {
    Article article = articleService.get(articleId);
    if(article == null) {
      return new BaseResponse<Boolean>(false);
    }
    articleService.delete(articleId);
    return new BaseResponse<Boolean>(true);
  }

}
