package Entity;

import java.io.Serializable;

public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8045221945709600590L;
	
	private Object obj;
	private int cmd;
	
	public Message(Object obj,int cmd) {
		this.obj=obj;
		this.cmd=cmd;
	}

	public Object getObj() {
		return obj;
	}

	public int getCmd() {
		return cmd;
	}

	@Override
	public String toString() {
		return ""+ cmd + obj ;
	}
	
}
