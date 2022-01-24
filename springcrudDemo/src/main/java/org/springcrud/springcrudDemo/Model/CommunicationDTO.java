package org.springcrud.springcrudDemo.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CommunicationDTO {
	
	@NotBlank(message=" * email cannot be blank")
	  @Email(message = "Email should be valid")
	private String emailId;
	
	@NotNull(message="phone number required")
	 private Phone phone; 
	
	  public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Phone getPhone() {
		  return phone; } 
	  
	  public void setPhone(Phone phone) {
	  this.phone = phone; }
	 

}
