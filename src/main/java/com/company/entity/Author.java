package com.company.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = Author.TABLE_NAME)
public class Author {

    public static final String TABLE_NAME = "author";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String username;

    private String password;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;


}
