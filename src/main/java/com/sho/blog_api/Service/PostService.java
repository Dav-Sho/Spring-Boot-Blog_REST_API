package com.sho.blog_api.Service;

import com.sho.blog_api.Dtos.PostDto;
import com.sho.blog_api.Utils.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    String deletePost(long id);
}
