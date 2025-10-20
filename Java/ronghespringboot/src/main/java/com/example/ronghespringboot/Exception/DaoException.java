package com.example.ronghespringboot.Exception;

import lombok.Getter;

@Getter
public class DaoException extends RuntimeException {
    private final String code;

    public DaoException(String code, String message) {

      super(message);
      this.code = code;
    }
}
