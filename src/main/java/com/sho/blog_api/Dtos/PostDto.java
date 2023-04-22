package com.sho.blog_api.Dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private long id;
    @NotEmpty
    @Size(min = 4, message = "Post title should at least 4 or more characters ")
    private String title;
    @NotEmpty
    @Size(min = 5, message = "Post description should at least 16 or more characters ")
    private String description;
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
