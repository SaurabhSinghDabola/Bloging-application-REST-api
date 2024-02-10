package com.blog.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
	
	@JsonIgnore
	private int id;
	private String content;
	

}
