package com.galvanize.springplayground;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    Lesson findByTitle(String title);

}
