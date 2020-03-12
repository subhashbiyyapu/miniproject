package com.cg.hbms.exception;

public class NoRoomsAvailableException  extends Exception {
	String message;
	public NoRoomsAvailableException()
	{
	
	}
	
 public NoRoomsAvailableException(String message)
{
this.message=message;
}
 public NoRoomsAvailableException(String message,Throwable t)
{
	 super(message,t);
this.message=message;
}
@Override
public String toString() {
	return "NoRoomsAvailableException [message=" + message + "]";
}
 
 
}
