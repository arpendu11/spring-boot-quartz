package com.stackabuse.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message implements Serializable {

	private static final long serialVersionUID = 4321761252954619538L;

	private boolean valid;
	private String msg;
	private Object data;
	
	public Message(boolean valid, String msg) {
		super();
		this.valid = valid;
		this.msg = msg;
	}
	public Message(boolean valid) {
		super();
		this.valid = valid;
	}
	
	public static Message failure(String msg) {
		return new Message(false, msg);
	}
	public static Message failure(Exception e) {
		return new Message(false, e.getMessage());
	}
	public static Message failure() {
		return new Message(false);
	}
	public static Message success() {
		return new Message(true);
	}
	public static Message success(String msg) {
		return new Message(true, msg);
	}
	
	public void setData(Object data) {
		this.valid = true;
		this.data = data;
	}
}
