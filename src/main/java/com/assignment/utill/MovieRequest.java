package com.assignment.utill;

import java.io.Serializable;

public class MovieRequest<T> implements Serializable{

	private long requestId;
	
	private T requestBody;

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public T getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(T requestBody) {
		this.requestBody = requestBody;
	}
	
	
}
