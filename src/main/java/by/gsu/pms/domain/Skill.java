package by.gsu.pms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    @JsonIgnore
    @ManyToMany(mappedBy = "cvSkillSet", fetch = FetchType.EAGER)
    private Set<Cv> cvSet = new HashSet<>();
    @JsonIgnore
    @ManyToMany(mappedBy = "jobSkillSet", fetch = FetchType.EAGER)
    private Set<Job> jobSet = new HashSet<>();
}
