package com.example.TestProger.repo;

import com.example.TestProger.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
