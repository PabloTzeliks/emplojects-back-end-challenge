package pablo.tzeliks.emploject.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String description;

    @ManyToMany(mappedBy = "employe")
    private List<Employe> employees;
}
