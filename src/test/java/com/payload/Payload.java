package com.payload;

import com.pojo.AddAddress_Input_pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
/**
 * 
 * @author LOGAPRIYA
 * @Description Used to Maintain the Address Input Pojo class
 * @CreationDate 27/06/2022
 *
 */
public class Payload {
	public static AddAddress_Input_pojo createAddress(String first_name, String last_name, String mobile, String apartment, int state,int city, int country, String zipcode, String address, String address_type) {

		AddAddress_Input_pojo addAddress_Input_pojo = new AddAddress_Input_pojo(first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return addAddress_Input_pojo;

		}

		public static UpdateAddress_Input_Pojo updateAddress(String address_id, String first_name, String last_name, String mobile,
		String apartment, int state, int city, int country, String zipcode, String address, String address_type) {

		UpdateAddress_Input_Pojo updateAddress_Input_pojo = new UpdateAddress_Input_Pojo(address_id, first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return updateAddress_Input_pojo;

		}

		public static DeleteAddress_Input_Pojo deleteAddress(String address_id) {

		DeleteAddress_Input_Pojo deleteAddress_Input_pojo = new DeleteAddress_Input_Pojo(address_id);
		return deleteAddress_Input_pojo;

		}

}
