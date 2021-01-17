package com.ikubinfo.primefaces.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.SessionScoped;

import org.springframework.scheduling.annotation.Scheduled;

import com.ikubinfo.primefaces.model.Discount;
import com.ikubinfo.primefaces.model.User;
import com.ikubinfo.primefaces.service.UserService;

import com.ikubinfo.primefaces.util.Messages;

@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientPageManagedBean implements Serializable {
	private static final long serialVersionUID = 3800933422824282320L;

	
	private User user;
	private Discount discount;
	private String output;

	private String oldPasswordTyped;
	private String newPassword;
	private String newPasswordRetyped;

	

	@ManagedProperty(value="#{userBean}")
	private UserManagedBean userBean;
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{messages}")
	private Messages messages;

	@PostConstruct
	public void init() {
		user=userService.getUserByUsername(userBean.getUser().getUsername());
		updateDiscount();
		discount=userService.getDiscount(userBean.getUser().getUsername());
		ifDiscountMessage();
		//System.out.println(discount.getPercentDiscount());

	}

	public void ifDiscountMessage() {
		if(user.getDiscountId()==1) {
			
			//String percent= String.valueOf(dis.getPercentDiscount());
			output="HAPPY BIRHTDAY TO YOU! IT'S YOUR BIRTHDAY AND TODAY WE HAVE A "+ discount.getPercentDiscount()+
					"% DISCOUNT FOR YOUR BIRTHDAY!!!";
		}if(user.getDiscountId()==2) {
			output="";
		}
		
	}
	
	public void getDiscountDetails() {
		//discount=userService.getDiscount(userBean.getUser().getUsername());
	}
	
	
	public void changePassword() {
		if(oldPasswordTyped.equals(userBean.getUser().getPassword()) && newPassword.equals(newPasswordRetyped)) {
			userService.changePassword(newPassword, userBean.getUser().getUsername());
			messages.showInfoMessage(" *Your password was succefully changed* ");
		}else {
			messages.showErrorMessage("Incorrect old password or new passwords! TRY AGAIN");

		}
	}
	
	@Scheduled(cron="0 * * ? * *")
	public void updateDiscount() {
		userService.updateDiscountId(user);
	}

	public String getOldPasswordTyped() {
		return oldPasswordTyped;
	}

	public void setOldPasswordTyped(String oldPasswordTyped) {
		this.oldPasswordTyped = oldPasswordTyped;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordRetyped() {
		return newPasswordRetyped;
	}

	public void setNewPasswordRetyped(String newPasswordRetyped) {
		this.newPasswordRetyped = newPasswordRetyped;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserManagedBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserManagedBean userBean) {
		this.userBean = userBean;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

}
