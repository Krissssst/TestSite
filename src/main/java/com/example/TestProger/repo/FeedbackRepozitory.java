package com.example.TestProger.repo;

import com.example.TestProger.models.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepozitory extends CrudRepository<Feedback,Long> {
}
