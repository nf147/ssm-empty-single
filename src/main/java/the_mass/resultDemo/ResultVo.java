package the_mass.resultDemo;

import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.List;

public class ResultVo<T> {
    private int code;
    private String errMsg;
    private T data;
    private Page<T> pager;

    private List<ErrorDetail> errors;
    private long dataTimestamp;

    // director
    public static ResultBuilder status(int code) {
        ResultBuilder builder = new DefaultBuilder<>();
        builder.status(code);
        return builder;
    }

    public static ResultBuilder addError(String type, String message) {
        ResultBuilder builder = new DefaultBuilder<>();
        builder.addError(type, message);
        return builder;
    }

    public static <D> ResultVo ok(D data) {
        ResultBuilder<D> builder = new DefaultBuilder<>();
        return builder.data(data);
    }

    public static <D> ResultVo ok(D data, Page page) {
        ResultBuilder<D> builder = new DefaultBuilder<>();
        return builder.data(data);
    }

    public static ResultVo err(int code, String errMsg) {
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Page<T> getPager() {
        return pager;
    }

    public void setPager(Page<T> pager) {
        this.pager = pager;
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDetail> errors) {
        this.errors = errors;
    }

    public long getDataTimestamp() {
        return dataTimestamp;
    }

    public void setDataTimestamp(long dataTimestamp) {
        this.dataTimestamp = dataTimestamp;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", errMsg='" + errMsg + '\'' +
                ", data=" + data +
                ", pager=" + pager +
                ", errors=" + errors +
                ", dataTimestamp=" + dataTimestamp +
                '}';
    }

    // 函数的类型签名
    public interface ResultBuilder<T> {
        ResultBuilder addError(String type, String message);

        ResultBuilder status(int status);

        ResultVo<T> data(T data);

        ResultVo<T> data(int status, T data);

        ResultVo<T> err(int status);

        ResultVo<T> err(int status, String emsg);
    }

    public static class DefaultBuilder<E> implements ResultBuilder<E> {
        private ResultVo<E> resultVo;
        //private final Object status;

        public DefaultBuilder() {
            this.resultVo = new ResultVo<E>();
        }

        @Override
        public ResultBuilder addError(String type, String message) {
            if (resultVo.getErrors() == null) {
                resultVo.setErrors(new ArrayList<>());
            }
            ErrorDetail detail = new ErrorDetail();
            detail.setType(type);
            detail.setMessage(message);
            resultVo.getErrors().add(detail);
            return this;
        }

        @Override
        public ResultBuilder status(int status) {
            resultVo.setCode(status);
            return this;
        }

        @Override
        public ResultVo<E> data(E data) {
            return null;
        }

        @Override
        public ResultVo<E> data(int status, E data) {
            // status 200
            this.status(status);
            resultVo.setData(data);
            return resultVo;
        }

        @Override
        public ResultVo<E> err(int status) {
            return resultVo;
        }

        @Override
        public ResultVo<E> err(int status, String emsg) {
            this.status(status);
            resultVo.setErrMsg(emsg);
            return null;
        }
    }
}

class ErrorDetail {
    private String type;
    private String message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
