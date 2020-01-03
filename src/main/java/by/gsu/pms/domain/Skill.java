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
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;
    private String name;
    @ManyToMany(mappedBy = "cvSkillSet")
    private Set<Cv> cvSet = new HashSet<>();
    @ManyToMany(mappedBy = "jobSkillSet")
    private Set<Job> jobSet = new HashSet<>();
}
