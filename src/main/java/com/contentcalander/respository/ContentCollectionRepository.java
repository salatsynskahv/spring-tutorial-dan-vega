package com.contentcalander.respository;

import com.contentcalander.model.Content;
import com.contentcalander.model.Status;
import com.contentcalander.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {}

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        System.out.println(id);
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }


    public void save(Content content){
        contentList.add(content);
    }


    public boolean existsById(Content content) {
        return contentList.stream().filter(c -> c.id().equals(content.id())).count() == 1;
    }
    @PostConstruct
    private void init(){
        contentList.add(new Content(1, "My first record", "My first record", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), LocalDateTime.now(), "dfdf" ));
    }


    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }


}
