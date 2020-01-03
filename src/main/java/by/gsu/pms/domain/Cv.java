package by.gsu.pms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cvId;
    private String title;
    private String filePath;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "skillsForCv",
            joinColumns = { @JoinColumn(name = "cvId") },
            inverseJoinColumns = { @JoinColumn(name = "skillId") }
    )
    private Set<Skill> skillSet = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usersCv")
    private User user;
}
