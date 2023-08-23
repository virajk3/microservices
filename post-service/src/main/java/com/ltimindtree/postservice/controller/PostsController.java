package com.ltimindtree.postservice.controller;

import com.ltimindtree.postservice.model.Posts;
import com.ltimindtree.postservice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostsController {

    @Autowired
    PostService postService;

    @GetMapping("/{postId}")
    public Posts getPostById(@PathVariable("postId") Long postId) {

        Posts posts = new Posts(postId,"First Post"+postId);
        return posts;
    }

}
