package com.sparta.week01.controller;

import com.sparta.week01.domain.Comment;
import com.sparta.week01.domain.CommentRepository;
import com.sparta.week01.domain.CommentRequestDto;
import com.sparta.week01.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }
    @GetMapping("/api/comments")
    public List<Comment> getComments() {
        return commentRepository.findAllByOrderByModifiedAtDesc();
    }
    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }

}