package com.nongho.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Link {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String link;
    @NonNull
    private String url;
    @NonNull
    private String title;

    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();
}
