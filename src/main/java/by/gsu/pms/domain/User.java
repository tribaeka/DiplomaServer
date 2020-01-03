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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String status;
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Cv> cvSet = new HashSet<>();
}
