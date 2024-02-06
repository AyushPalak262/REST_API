package com.udemy.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.udemy.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserRepository userRepo;
	
	private PostRepository postRepo;
	
	public UserJpaResource(UserRepository userRepo,PostRepository postRepo) {
		super();
		this.userRepo = userRepo;
		this.postRepo=postRepo;
	}

	//get all users
	@GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
    	return userRepo.findAll();
    }
	
	//get one user 
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	//create a new user
	@PostMapping("/jpa/users")
	public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {
		
		User savedUser = userRepo.save(user);
		
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	//Delete a user
	@DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
		userRepo.deleteById(id);
		
    }
	
	//get a post of an user
	@GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostOfUser(@PathVariable int id){
		Optional<User> user = userRepo.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		return user.get().getPosts();		
    }
	
	
	//create  post for an user
	@PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id,@Valid @RequestBody Post post){
		Optional<User> user = userRepo.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		post.setUser(user.get());
		Post savedPost = postRepo.save(post);
		
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
    }
	
	//get description of a post for an user
	
	@GetMapping("/jpa/users/{id1}/posts/{id2}")
    public String retrievePostDescriptionOfUserPost(@PathVariable int id1,@PathVariable int id2){
		Optional<User> user = userRepo.findById(id1);
		Optional<Post> post = postRepo.findById(id2);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id1 +" is not there");
		if(post.isEmpty())
			throw new PostNotFoundException("id: "+id2 +" is not there");
		
		return post.get().getDescription();		
    }
	
	//delete a post of an user
	
	@DeleteMapping("/jpa/users/{id1}/posts/{id2}")
    public void DeleteAPostOfUser(@PathVariable int id1,@PathVariable int id2){
		Optional<User> user = userRepo.findById(id1);
		Optional<Post> post = postRepo.findById(id2);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id1 +" is not there");
		if(post.isEmpty())
			throw new PostNotFoundException("id: "+id2 +" is not there");
		
		 postRepo.deleteById(id2);		
    }
	
}
