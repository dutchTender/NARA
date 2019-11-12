package gov.nara.um.persistence.model;

import gov.nara.common.interfaces.INameableDto;
import gov.nara.common.persistence.model.INameableEntity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class BusinessUnit  implements INameableEntity, INameableDto {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column( nullable = false)
    private String ldapName;

    @OneToMany
    private Set<User> users;



    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;

    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLdapName() {
        return ldapName;
    }

    public void setLdapName(String ldapName) {
        this.ldapName = ldapName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
