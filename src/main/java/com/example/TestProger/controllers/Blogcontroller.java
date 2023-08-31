package com.example.TestProger.controllers;

import com.example.TestProger.models.Post;
import com.example.TestProger.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class Blogcontroller {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blog(Model model) {
        Iterable<Post> post = postRepository.findAll();
        model.addAttribute("posts", post);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        Iterable<Post> post = postRepository.findAll();
        return "blog-add";
    }
    @GetMapping("/blog/addCat")
    public String blogAddCate(Model model) {
        Iterable<Post> post = postRepository.findAll();
        return "blog-addCat";
    }
    @GetMapping("/blog/addDog")
    public String blogAddDog(Model model) {
        Iterable<Post> post = postRepository.findAll();
        return "blog-addDog";
    }

    @PostMapping("/blog/addCat")
    public String blogPostAddCate(@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String full_text, Model model) {
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @PostMapping("/blog/addDog")
    public String blogPostAddDog(@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String full_text, Model model) {
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        List<Post> list = new ArrayList();
        post.ifPresent(list::add);
        model.addAttribute("post", list);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id,
                           Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> list = new ArrayList<>();
        post.ifPresent(list::add);
        model.addAttribute("post", list);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostEdit(@PathVariable(value = "id") long id,
                               @RequestParam String title,
                               @RequestParam String anons,
                               @RequestParam String full_text, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setAnons(anons);
        post.setFull_text(full_text);
        post.setTitle(title);
        postRepository.save(post);

        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }
}
