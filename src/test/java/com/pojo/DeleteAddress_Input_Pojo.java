package com.pojo;

/**
 * 
 * @author LOGAPRIYA
 * @Description To provide input value to delete address
 * @CreationDate 27/06/2022
 *
 */
public class DeleteAddress_Input_Pojo {
	private String address_id;

	public DeleteAddress_Input_Pojo(String address_id) {
		super();
		this.address_id = address_id;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	
	
}
