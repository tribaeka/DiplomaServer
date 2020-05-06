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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String name;
    private String siteUrl;
    @OneToMany(mappedBy = "companiesContact", fetch = FetchType.LAZY)
    private Set<Contact> contactSet;
    @JsonIgnore
    @OneToMany(mappedBy = "companiesJob", fetch = FetchType.LAZY)
    private Set<Job> jobSet = new HashSet<>();
    private String logoPath;

    @Override
    public String toString() {
        return name;
    }
}
