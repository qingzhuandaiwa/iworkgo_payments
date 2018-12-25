package com.yk.iworkgo.utils.http;

import java.util.List;
import java.util.Map;


public class HttpResp {

	private int responseCode;

	private Map<String, List<String>> headers;

	private String body;

    private String exceptionMsg;

	public Map<String, List<String>> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, List<String>> headers) {
		this.headers = headers;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}


    public String getExceptionMsg() {
        return exceptionMsg;
    }


    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }


    @Override
	public String toString() {
		return "responseCode = " + responseCode + ", body=" + body + ", headers = " + headers;
	}
}
