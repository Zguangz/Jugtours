package com.springboot.jugtours.init;

import com.springboot.jugtours.dto.Event;
import com.springboot.jugtours.dto.Group;
import com.springboot.jugtours.repo.GroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("JUG One", "JUG Two", "JUG Three", "JUG Four").forEach(name-> repository.save(new Group(name)));
        Group djug = repository.findByName("JUG One");
        Event e = Event.builder()
                .title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);
        repository.findAll().forEach(System.out::print);
    }
}
