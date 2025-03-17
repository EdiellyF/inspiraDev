package com.InspiraDev.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.Date;


@Entity
@Table(name = devotional.TABLE_NAME )
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class devotional {


    public static final String TABLE_NAME = "devocional";

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(name = "descricao", nullable = false)
    private String description;

    @Column(name = "data_versiculo", nullable = false)
    private Date date;

    @Column(name = "key_verse", nullable = false)
    private String keyverse;



}
