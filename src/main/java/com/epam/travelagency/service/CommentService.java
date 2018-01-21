package com.epam.travelagency.service;

import com.epam.travelagency.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment save(Comment comment);
    void update(Comment comment);
    List<Comment> getAll();
}
