package by.gsu.pms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Indexed
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    @Field
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
