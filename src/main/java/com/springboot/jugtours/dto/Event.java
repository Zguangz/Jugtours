package com.springboot.jugtours.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private Instant date;
    private String title;
    private String description;
    @ManyToMany
    private Set<User> attendees;

}
