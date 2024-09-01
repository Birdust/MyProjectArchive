package com.ict01.mybatisproject.configuration.exception;

import com.ict01.mybatisproject.configuration.http.BaseResponseCode;

public abstract class AbstractBaseException extends RuntimeException {

  private static final long serialVersionUID = -8562291788131947692L;

  protected BaseResponseCode responseCode;
  protected Object[] args;

  public AbstractBaseException() {
  }

  public AbstractBaseException(BaseResponseCode responseCode) {
    this.responseCode = responseCode;
  }

  public BaseResponseCode getResponseCode() {
    return responseCode;
  }

  public Object[] getArgs() {
    return args;
  }
}
