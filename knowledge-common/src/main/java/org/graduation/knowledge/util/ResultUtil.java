package org.graduation.knowledge.util;

import cn.hutool.core.lang.Singleton;
import cn.hutool.http.HttpStatus;
import org.graduation.knowledge.base.Result;

/**
 * @author Exrick
 * @author huyuanxin
 */
public class ResultUtil {

    /**
     * 单例
     */
    private static volatile ResultUtil singleton;

    /**
     * 成功返回的信息
     */
    private static final String SUCCESS_MESSAGE = "请求成功";

    /**
     * 404返回的信息
     */
    private static final String NOT_FOUND_MESSAGE = "资源不存在";

    /**
     * 已接受请求，请继续发送请求
     */
    private static final String ACCEPT_MESSAGE = "已接受请求";

    private ResultUtil() {
    }

    public static ResultUtil getSingleton() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new ResultUtil();
                }
            }
        }
        return singleton;
    }

    public <T> Result<T> defineSuccess(T t) {
        Result<T> result = new Result<>();
        result.setMessage(SUCCESS_MESSAGE);
        result.setSuccess(true);
        result.setResult(t);
        result.setCode(HttpStatus.HTTP_OK);
        return result;
    }

    public <T> Result<T> defineSuccess(String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setMessage(msg);
        result.setCode(HttpStatus.HTTP_OK);
        result.setResult(null);
        return result;
    }

    public <T> Result<T> defineSuccess(Integer code, T t, String successMessage) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setMessage(successMessage);
        result.setCode(code);
        result.setResult(t);
        return result;
    }

    public <T> Result<T> defineSuccess(T t, String successMessage) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setMessage(successMessage);
        result.setCode(HttpStatus.HTTP_OK);
        result.setResult(t);
        return result;
    }

    public <T> Result<T> setErrorMsg(String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMessage(msg);
        result.setCode(HttpStatus.HTTP_INTERNAL_ERROR);
        return result;
    }

    public <T> Result<T> setNotFoundMsg() {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMessage(NOT_FOUND_MESSAGE);
        result.setCode(HttpStatus.HTTP_NOT_FOUND);
        return result;
    }

    public <T> Result<T> setNotFoundMsg(String notFoundMessage) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMessage(notFoundMessage);
        result.setCode(HttpStatus.HTTP_NOT_FOUND);
        return result;
    }

    public <T> Result<T> setErrorMsg(Integer code, String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMessage(msg);
        result.setCode(code);
        return result;
    }

    public <T> Result<T> setAccept(T t) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setMessage(ACCEPT_MESSAGE);
        result.setResult(t);
        result.setCode(HttpStatus.HTTP_ACCEPTED);
        return result;
    }

    public static <T> Result<T> success(T t) {
        return getSingleton().defineSuccess(t);
    }

    public static <T> Result<T> success(T t, String msg) {
        return getSingleton().defineSuccess(t, msg);
    }

    public static <T> Result<T> success(int code, T t, String successMessage) {
        return getSingleton().defineSuccess(code, t, successMessage);
    }

    public static <T> Result<T> accept(T t) {
        return getSingleton().setAccept(t);
    }

    public static <T> Result<T> error(String msg) {
        return getSingleton().setErrorMsg(msg);
    }

    public static <T> Result<T> error(Integer code, String msg) {
        return getSingleton().setErrorMsg(code, msg);
    }

    public static <T> Result<T> notFound() {
        return getSingleton().setNotFoundMsg();
    }

    public static <T> Result<T> notFound(String notFoundMessage) {
        return getSingleton().setNotFoundMsg(notFoundMessage);
    }
}
