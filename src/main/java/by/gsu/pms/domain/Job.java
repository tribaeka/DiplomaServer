package by.gsu.pms.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name="job_location", nullable=false)
    private Location location;
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "skillsForJob",
            joinColumns = { @JoinColumn(name = "jobId") },
            inverseJoinColumns = { @JoinColumn(name = "skillId") }
    )
    private Set<Skill> jobSkillSet = new HashSet<>();
    @CreatedDate
    private LocalDate postDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "companiesJob")
    private Company companiesJob;
}
