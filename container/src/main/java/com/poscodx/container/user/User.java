package com.poscodx.container.user;

import org.springframework.stereotype.Component;

@Component
public class User {
	private Long no = 0L;
	private String name = "둘리";

	
	//오버로딩
	public User(){
		
	}
	public User(String name){
		this.name = name;
	}
	public User(Long no,String name){
		this.no = no;
		this.name = name;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User{" +
				"no=" + no +
				", name='" + name + '\'' +
				'}';
	}
}
