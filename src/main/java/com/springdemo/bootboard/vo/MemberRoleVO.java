package com.springdemo.bootboard.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRoleVO implements Serializable {

	private String userName;
	private String roleName;
	
}
