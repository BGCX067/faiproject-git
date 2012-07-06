package id.web.faisalabdillah.dto;

public class JsonResultBean<T> {
	private int resultsize;
	private boolean success;
	private T result;
	private String message;
	private String errorcode;
	
	
	public int getResultsize() {
		return resultsize;
	}
	public void setResultsize(int resultsize) {
		this.resultsize = resultsize;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	
}
