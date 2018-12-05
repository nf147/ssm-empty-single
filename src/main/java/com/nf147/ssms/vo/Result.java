package com.nf147.ssms.vo;

import com.github.pagehelper.Page;

public class Result<T> {
    private int code;
    private String errMsg;
    private T data;

    private Page<T> pager;
    private Throwable error;

    public Result(int i, T student, Page<T> pager) {
        this.code = i;
        this.data = student;
        this.pager = pager;
    }

    public Result(int i, String message) {
        this.code = i;
        this.errMsg = message;
    }

    public Result(int i, Throwable e) {
        this.code = i;
        this.error = e;
    }

    public Result () {}

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public Result<T> setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Page<T> getPager() {
        return pager;
    }

    public Result<T> setPager(Page<T> pager) {
        this.pager = pager;
        return this;
    }

    public Throwable getError() {
        return error;
    }

    public Result<T> setError(Throwable error) {
        this.error = error;
        return this;
    }
}
