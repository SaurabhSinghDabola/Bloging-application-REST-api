package com.blog.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Dto.PostDto;
import com.blog.Excepiton.ResourceNotFoundException;
import com.blog.Model.Category;
import com.blog.Model.Post;
import com.blog.Model.User;
import com.blog.Repository.CategoryRepo;
import com.blog.Repository.PostRepo;
import com.blog.Repository.UserRepo;
import com.blog.Service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private UserRepo userRepo;

	@Override
	public PostDto createPost(PostDto postDto,  int CategoryId, int id) {
		User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user is not resgiter with this id" + id));
	    Category cat = categoryRepo.findById(CategoryId).orElseThrow(()-> new ResourceNotFoundException("Category is not added with id" + id));
	    
	    Post post = modelMapper.map(postDto,Post.class);
	    
	  //  post.setImages(postDto.getImage());
	    post.setAddedDate(new Date());
	    post.setCategory(cat);
	    post.setUser(user);
	    
	    Post newPost = postRepo.save(post);
	    
	    return modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, int postId) {
		
		Post post= postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post not exist with id " + postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImages(postDto.getImages());
		
		Post updatedPost =  postRepo.save(post);
	    return modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(int postId) {
		Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post not exist with id " + postId));
		postRepo.delete(post);
		
	}

	@Override
	public PostDto getPost(int postId) {
		 Post singlePost = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post is not avialable with id "+ postId));
		 return modelMapper.map(singlePost, PostDto.class);
	}

	@Override
	public List<Post> getAllposts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(int CategoryId) {
		Category cat =categoryRepo.findById(CategoryId).orElseThrow(()-> new ResourceNotFoundException("category not exist with id"+ CategoryId));
		List<Post> posts = postRepo.findByCategory(cat);
	    List<PostDto> postDtos = posts.stream().map((post)-> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	    return postDtos;
				
	}

	@Override
	public List<PostDto> getPostsByUser(int id) {
		User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not exist with this is" + id));
		List<Post> posts = postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().map((post)-> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
		
	}

}
