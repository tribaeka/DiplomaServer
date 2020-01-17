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
    private String size;
    @OneToMany(mappedBy = "companiesContact", fetch = FetchType.EAGER)
    private Set<Contact> contactSet;
    @JsonIgnore
    @OneToMany(mappedBy = "companiesJob", fetch = FetchType.EAGER)
    private Set<Job> jobSet = new HashSet<>();
    private String logoPath;
}
