package com.sho.blog_api.Controller;

import com.sho.blog_api.Dtos.CommentDto;
import com.sho.blog_api.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

//    Create comment
    @PostMapping("/posts/{post_id}/comments")
    private ResponseEntity<CommentDto> createComment(@Valid @RequestBody CommentDto commentDto, @PathVariable(value = "post_id") long post_id) {
        CommentDto response = commentService.createComment(commentDto, post_id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //    Get comments
    @GetMapping("/posts/{post_id}/comments")
    private ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable(value = "post_id") long post_id) {
        List<CommentDto> response = commentService.getCommentsByPostId(post_id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //    Get comment by id
    @GetMapping("/posts/{post_id}/comments/{id}")
    private ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "post_id") long postId, @PathVariable(value = "id") long commentId) {
        CommentDto response = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //    Update comment
    @PutMapping("/posts/{post_id}/comments/{id}")
    private ResponseEntity<CommentDto> updateCommentById(@Valid @RequestBody CommentDto commentDto, @PathVariable(value = "post_id") long postId, @PathVariable(value = "id") long commentId) {
        CommentDto response = commentService.updateComment(commentDto, postId, commentId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //    Delete comment
    @DeleteMapping("/posts/{post_id}/comments/{id}")
    private ResponseEntity<String> deleteCommentById( @PathVariable(value = "post_id") long postId, @PathVariable(value = "id") long commentId) {
        String response = commentService.deleteCommentById( postId, commentId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
