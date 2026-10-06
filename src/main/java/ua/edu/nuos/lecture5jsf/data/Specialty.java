package ua.edu.nuos.lecture5jsf.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "specialty")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "shifr", length = 10)
    private String shifr;

    @OneToMany(mappedBy = "specialty", orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    public Specialty(String title, String shifr) {
        this.title = title;
        this.shifr = shifr;
    }
}