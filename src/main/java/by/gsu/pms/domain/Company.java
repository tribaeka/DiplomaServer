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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String name;
    private String siteUrl;
    private String size;
    @OneToMany(mappedBy = "companiesContact", fetch = FetchType.EAGER)
    private Set<Contact> contactSet;
    @OneToMany(mappedBy = "companiesJob", fetch = FetchType.EAGER)
    private Set<Job> jobSet = new HashSet<>();
}
