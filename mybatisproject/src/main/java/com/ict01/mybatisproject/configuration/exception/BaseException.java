package com.ict01.mybatisproject.configuration.exception;

import com.ict01.mybatisproject.configuration.http.BaseResponseCode;

public class BaseException extends AbstractBaseException {

  private static final long serialVersionUID = -7311129858811274042L;

  public BaseException() {
  }

  public BaseException(BaseResponseCode responseCode) {
    this.responseCode = responseCode;
  }

  public BaseException(BaseResponseCode responseCode, String[] args) {
    this.responseCode = responseCode;
    this.args = args;
  }
}
