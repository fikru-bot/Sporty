package io.ecommerce.galery.form;

import javax.validation.constraints.NotEmpty;

import io.ecommerce.galery.entity.BaseEntity;
import io.ecommerce.galery.entity.UserEntity;



public class LoginForm extends BaseForm {

	
	@NotEmpty(message = "Login is required")
	private String login;
	
	@NotEmpty(message = "Password is required")
	private String password;


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public BaseEntity getBean() {
		UserEntity bean=new UserEntity();
		bean.setLoginId(login);
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseEntity baseBean) {
	}

}
