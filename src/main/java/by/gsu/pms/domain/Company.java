package by.gsu.pms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private int size;
    private String city;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Contact> contactSet;
}
