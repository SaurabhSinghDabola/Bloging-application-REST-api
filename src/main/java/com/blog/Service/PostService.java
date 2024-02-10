package com.blog.Service;

import java.util.List;

import com.blog.Dto.PostDto;
import com.blog.Model.Post;

public interface PostService {
	
	// createPost
	
	PostDto createPost(PostDto postDto, int CategoryId, int id);
	
	   //updatePost
	PostDto updatePost(PostDto postDto , int postId);
	
	   // deletePost
	void deletePost(int postId);
	
	  // get single post by id
	PostDto getPost(int postId);
	
	  // get all post
	List<Post> getAllposts();
	 
	// get all post by category
	List<PostDto> getPostsByCategory(int CategoryId);
	
	// get all post by user
	List<PostDto> getPostsByUser(int id);

}
