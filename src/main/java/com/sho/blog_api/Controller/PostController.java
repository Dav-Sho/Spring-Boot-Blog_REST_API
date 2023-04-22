package com.sho.blog_api.Controller;

import com.sho.blog_api.Dtos.PostDto;
import com.sho.blog_api.Service.PostService;
import com.sho.blog_api.Utils.AppConstant;
import com.sho.blog_api.Utils.PostResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        PostDto response = postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    Get all post
    @GetMapping()
    public PostResponse getAllPosts(@RequestParam(value = "pageNo", defaultValue = AppConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                    @RequestParam(value = "pageSize",  defaultValue = AppConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                    @RequestParam(value = "sortBy", defaultValue = AppConstant.DEFAULT_SORT_BY, required = false) String sortBy,
                                    @RequestParam(value = "sortDir", defaultValue = AppConstant.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        PostResponse response = postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
        return response;
    }

//    Get single post
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable(name = "id") long id){
        PostDto response = postService.getPostById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    Update Post
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable long id){
        PostDto response = postService.updatePost(postDto, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    Delete Post
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        String  response = postService.deletePost( id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
