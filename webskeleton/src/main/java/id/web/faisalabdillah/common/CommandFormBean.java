package id.web.faisalabdillah.common;

public class CommandFormBean {
	private boolean success;
	private Object message;
	private Object cause;
	private String code;
	
	public Object getCause() {
		return cause;
	}
	public void setCause(Object cause) {
		this.cause = cause;
	}public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
