package com.ganwenpeng.jsinterface.model.bean;

public class JsBridgeResponse {
    private int error;
    private String message;
    private Object data;

    public JsBridgeResponse() {
    }

    public JsBridgeResponse(int error, String message, Object data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsBridgeResponse{" +
                "error=" + error +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
