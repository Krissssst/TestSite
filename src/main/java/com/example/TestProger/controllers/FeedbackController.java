package com.example.TestProger.controllers;

import com.example.TestProger.models.Feedback;
import com.example.TestProger.models.Post;
import com.example.TestProger.repo.FeedbackRepozitory;
import com.example.TestProger.repo.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class FeedbackController {
    private FeedbackRepozitory feedbackRepozitory;

    public FeedbackController(FeedbackRepozitory feedbackRepozitory){
        this.feedbackRepozitory=feedbackRepozitory;
    }

    @GetMapping("/feedback")
    public String feedback(Model model) {
        Iterable<Feedback> fed = feedbackRepozitory.findAll();
        model.addAttribute("feed", fed);
        return "/feedback";
    }

    @PostMapping("/feedback")
    public String feedbackPost(@RequestParam String name,
            @RequestParam String email,
            @RequestParam String sms,
            @RequestParam String tema) {
        Feedback feed=new Feedback(name,email,sms,tema);
        feedbackRepozitory.save(feed);
        return "redirect:/feedback";
    }

}
