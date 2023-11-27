package com.contentcalander.controller;


import com.contentcalander.model.Content;
import com.contentcalander.respository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentRepository repository;


    @Autowired
    public ContentController(ContentRepository contentRepository) {
        this.repository = contentRepository;
    }



    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content was not found"));
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
        repository.save(content);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody Content content){
//        if(!repository.findById(content.id())) {
//            throw new ContentNotFoundException("Not found");
//        }
        repository.save(content);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{keyword}")
    public List<Content> findByStatus(@PathVariable String keyword) {
        return  repository.listByStatus(keyword);
    }
}
