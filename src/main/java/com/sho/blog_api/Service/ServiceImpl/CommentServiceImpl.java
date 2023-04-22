package com.sho.blog_api.Service.ServiceImpl;

import com.sho.blog_api.Dtos.CommentDto;
import com.sho.blog_api.Entity.Comment;
import com.sho.blog_api.Entity.Post;
import com.sho.blog_api.Exception.ResourceNotFound;
import com.sho.blog_api.Repository.CommentRepository;
import com.sho.blog_api.Repository.PostRepository;
import com.sho.blog_api.Service.CommentService;
import com.sho.blog_api.Utils.PostResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private ModelMapper mapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper mapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.mapper = mapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(() -> new ResourceNotFound("Post", "id", post_id));

        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
        return mapToDto(comment);

    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFound("Post", "id", postId));
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFound("Post", "id", postId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFound("Comment", "id", commentId));
        return mapToDto(comment);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFound("Post", "id", postId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFound("Comment", "id", commentId));
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setMessage(commentDto.getMessage());
        commentRepository.save(comment);
        return mapToDto(comment);
    }

    @Override
    public String deleteCommentById(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFound("Post", "id", postId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFound("Comment", "id", commentId));
        commentRepository.delete(comment);
        return "Comment deleted";
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = mapper.map(commentDto, Comment.class);
        return comment;
    }

    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = mapper.map(comment, CommentDto.class);
        return commentDto;
    }
}
