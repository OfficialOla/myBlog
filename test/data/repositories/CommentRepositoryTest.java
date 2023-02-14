package data.repositories;

import data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryTest {

    private CommentRepository commentRepository;

    private Comment comment;

    @BeforeEach
    public void setUp(){
        commentRepository = new CommentRepositoryImpl();
        comment = new Comment();
        comment.setComment("It's a facade");

    }
    @Test public void saveOneComment_countIsOneTest(){
        Comment comment = new Comment();
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
    }
    @Test public void saveOneComment_IdOfCommentIsOne(){
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
    }
    @DisplayName("Update Comment test")
    @Test public void saveTwoCommentsWithSameId_countIsOneTest(){
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        savedComment.setComment("It's alright");
        commentRepository.save(savedComment);
        assertEquals(1, commentRepository.count());
    }
    @Test public void saveOneComment_findCommentById(){
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
        Comment foundComment = commentRepository.findById(1);
        assertEquals(foundComment, savedComment);
    }
    @Test public void saveOneComment_deleteOneComment_countIsZero(){
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        commentRepository.delete(1);
        assertEquals(0, commentRepository.count());
    }

}