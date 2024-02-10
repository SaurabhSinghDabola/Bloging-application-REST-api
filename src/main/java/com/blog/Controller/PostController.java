package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Dto.PostDto;
import com.blog.Model.Post;
import com.blog.Service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag( 
		name = "CRUD  REST api for posts",
		description = "Create user, update user, Delete user, get user")
@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Operation(
			 summary = "create new post Rest api"
			
		)
	@PostMapping("/user/{id}/category/{CategoryId}/new")
	public ResponseEntity<PostDto> createPostHandler(@RequestBody PostDto postDto,@PathVariable int id , @PathVariable int CategoryId){
	   PostDto newPost  = 	 postService.createPost(postDto, CategoryId, CategoryId);
	   return new ResponseEntity<>(newPost, HttpStatus.CREATED);
		
		}
	
	@Operation(summary = "get post by postId")
	@GetMapping("/postId/{id}")
	public ResponseEntity<PostDto> getPostHandler(@PathVariable("id") int postId){
		PostDto getPost= postService.getPost(postId);
		return ResponseEntity.ok(getPost);
		
	}
	
	@Operation( summary = "get posts  by categoryId api")
	@GetMapping("/category/{CategoryId}")
	public ResponseEntity<List<PostDto>> postsByCategoryHandler(@PathVariable int CategoryId){
		List<PostDto> postDtos = postService.getPostsByCategory(CategoryId);
		return ResponseEntity.ok(postDtos);
			
	}
	@Operation( summary = "get posts by userId")
	@GetMapping("/user/{id}")
	public ResponseEntity<List<PostDto>> postsByUserHandler(@PathVariable int id){
		List<PostDto> postDtos = postService.getPostsByUser(id);
		return ResponseEntity.ok(postDtos);
			
	}
	@Operation( summary = "update post by postId")
	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatePostHandler(@RequestBody PostDto postDto, @PathVariable int postId){
		PostDto updatedpost = postService.updatePost(postDto, postId);
		return ResponseEntity.ok(updatedpost);
	}
	@Operation( summary = "delete post by postId")
	@DeleteMapping("/{postId}")
	public ResponseEntity<String> deletePostHandler(@PathVariable int postId){
		postService.deletePost(postId);
		return ResponseEntity.ok("post deleted sucessfully....");
	}
	
}
