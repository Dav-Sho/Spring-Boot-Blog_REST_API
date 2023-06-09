package com.sho.blog_api.Repository;

import com.sho.blog_api.Entity.Comment;
import com.sho.blog_api.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
}
