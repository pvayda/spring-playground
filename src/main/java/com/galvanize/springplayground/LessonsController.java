package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }
    @GetMapping("/{id}")
    public Lesson read(@PathVariable Long id){
        return this.repository.findById(id).get();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.repository.deleteById(id);
    }
    @PatchMapping("/{id}")
    public Lesson patch(@PathVariable Long id, @RequestBody Lesson inputLesson){
        Lesson lesson = this.repository.findById(id).get();
        lesson.setTitle(inputLesson.getTitle());
        lesson.setDeliveredOn(inputLesson.getDeliveredOn());
        return this.repository.save(lesson);

    }
}