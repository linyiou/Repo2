package domain;

import java.io.Serializable;

public class ResultInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3310684482437531435L;
	private boolean flag;
	private Object data;
	private String errorMsg;
	
	public ResultInfo() {
		// TODO Auto-generated constructor stub
	}
	public ResultInfo(boolean flag) {
		this.flag = flag;
	}
	public ResultInfo(boolean flag,String errorMsg) {
		this.flag = flag;
		this.errorMsg = errorMsg;
	}
	public ResultInfo(boolean flag,Object data,String errorMsg) {
		this.data = data;
		this.errorMsg = errorMsg;
		this.flag = flag;
	}
	
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public Boolean isFlag() {
		return flag;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
