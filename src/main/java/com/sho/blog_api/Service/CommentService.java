package com.sho.blog_api.Service;

import com.sho.blog_api.Dtos.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long post_id);
    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(long postId, long commentId);
    CommentDto updateComment(CommentDto commentDto, long postId, long commentId);
    String deleteCommentById(long postId, long commentId);
}
