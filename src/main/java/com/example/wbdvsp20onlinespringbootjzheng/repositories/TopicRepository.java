package com.example.wbdvsp20onlinespringbootjzheng.repositories;

import com.example.wbdvsp20onlinespringbootjzheng.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    @Query("SELECT topic FROM Topic topic")
    public List<Topic> findAllTopics();

    @Query("SELECT topic FROM Topic topic WHERE topic.lessonId=:lid")
    public List<Topic> findTopicsForLesson(@Param("lid") String lessonId);

    @Query("SELECT topic FROM Topic topic WHERE topic.id=:tid")
    public Topic findTopicById(@Param("tid") Integer topicId);
}
