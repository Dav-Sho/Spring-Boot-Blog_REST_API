package com.sho.blog_api.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long id;
    @NotEmpty
    @Size(min = 3, message = "Name must be at least 3 or more characters")
    private String name;
    @Email(message = "Please use a valid mail")
    @NotEmpty
    private String email;
    @NotEmpty
    private String message;
}
