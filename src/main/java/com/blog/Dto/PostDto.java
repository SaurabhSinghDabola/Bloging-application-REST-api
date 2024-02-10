package com.blog.Dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.Model.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
 
	private int postId;
	private String title;
	private String content;
	
	private String images;
	
	private Date addedDate;
	
	private CategoryDto category;
	private UserDto user;
	
	private Set<CommentDto> comments  = new HashSet<>();

}
