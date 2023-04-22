package com.sho.blog_api.Controller;

import com.sho.blog_api.Dtos.PostDto;
import com.sho.blog_api.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    create post
    @PostMapping()
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto response = postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    Get all post
    @GetMapping()
    public List<PostDto> getPosts() {
        List<PostDto> response = postService.getAllPost();
        return response;
    }

//    Get single post
    @GetMapping(name = "{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable(name = "id") long id){
        PostDto response = postService.getPostById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    Update Post
    @PutMapping(name = "{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable long id){
        PostDto response = postService.updatePost(postDto, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    Delete Post
    @DeleteMapping(name = "{id}")
    public ResponseEntity<String> deletePost( @PathVariable long id){
        String  response = postService.deletePost( id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
