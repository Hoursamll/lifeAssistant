package com.szdx.lifeAssistant.common.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseData {

    private final int code;
    private final String msg;
    private final Map<String, Object> data = new HashMap<String, Object>();

    public String getMessage() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseData putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public ResponseData(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public static ResponseData ok() {
        return new ResponseData(0, "OK");
    }

    public static ResponseData notFound() {
        return new ResponseData(404, "Not Found");
    }

    public static ResponseData badRequest() {
        return new ResponseData(400, "Bad Request");
    }

    public static ResponseData forbidden() {
        return new ResponseData(403, "Forbidden");
    }

    public static ResponseData unauthorized() {
        return new ResponseData(401, "Unauthorized");
    }

    public static ResponseData serverInternalError() {
        return new ResponseData(500, "Server Internal Error");
    }

    public static ResponseData customerError() {
        return new ResponseData(1001, "Customer Error");
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
