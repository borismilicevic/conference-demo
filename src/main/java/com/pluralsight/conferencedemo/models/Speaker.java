package com.pluralsight.conferencedemo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speaker_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "title")
    private String title;

    @Column(name = "company")
    private String company;

    @Column(name = "speaker_bio")
    private String bio;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "speaker_photo")
    private byte[] speakerPhoto;

    @ManyToMany(mappedBy = "speakers")
    private List<Session> sessions;
}
