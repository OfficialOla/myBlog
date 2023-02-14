package data.repositories;

import data.models.Comment;

import java.util.List;

public interface CommentRepository {
    Comment save(Comment comment);

    Comment findById(int id);

    long count();

    List<Comment> findAll();

    void delete(int id);

    void delete(Comment comment);
}
