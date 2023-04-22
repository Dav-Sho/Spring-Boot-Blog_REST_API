package com.sho.blog_api.Service;

import com.sho.blog_api.Dtos.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    String deletePost(long id);
}
