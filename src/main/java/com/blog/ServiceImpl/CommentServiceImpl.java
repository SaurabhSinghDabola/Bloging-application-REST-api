package com.blog.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Dto.CommentDto;
import com.blog.Excepiton.ResourceNotFoundException;
import com.blog.Model.Comment;
import com.blog.Model.Post;
import com.blog.Repository.CommentRepo;
import com.blog.Repository.PostRepo;
import com.blog.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public CommentDto addComment(CommentDto commentDto,  int postId) {
		Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post not exist with id" + postId));
		Comment comment = modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		 Comment savedComment = commentRepo.save(comment);
		
		return modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void DeleteComment(int id) {
		Comment comment= commentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("comment is not avialable with id" + id));
		commentRepo.delete(comment);
	}

}
