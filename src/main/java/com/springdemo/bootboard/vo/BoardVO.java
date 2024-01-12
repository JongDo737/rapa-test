package com.springdemo.bootboard.vo;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO implements Serializable {

	private int boardIdx;
	private String title;
	private String contents;
	private int hitCount;
	private Date createdDatetime;
	private String creatorId;
	private Date updatedDatetime;
	private String updaterId;
	private String deletedYn;
	
}
