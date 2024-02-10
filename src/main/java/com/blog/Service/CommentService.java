package com.blog.Service;

import com.blog.Dto.CommentDto;

public interface CommentService {
	
	CommentDto addComment(CommentDto commentDto, int postId);
	void DeleteComment(int id);
	

}
