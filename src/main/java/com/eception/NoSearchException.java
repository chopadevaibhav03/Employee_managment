package com.eception;

public class NoSearchException extends RuntimeException{

	String s;
	public NoSearchException(String s)
	{
		super(s);
		this.s = s;
		System.out.println(s);
	}
}
