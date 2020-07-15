package domain;

import java.io.Serializable;

public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6019865946011659102L;

	private int cid;
	private String cname;
	
	public Category() {
		
	}
	
	public Category(int cid,String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
