package com.pojo;

import java.util.ArrayList;
/**
 * 
 * @author LOGAPRIYA
 *@Description To get the response statuscode
 * @CreationDate 27/06/2022
 */
public class GetAddress_Output_Pojo {
	private int status;
    private String message;
    private ArrayList<Datum> data;
	
    public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Datum> getData() {
		return data;
	}
	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}
    
    
}
