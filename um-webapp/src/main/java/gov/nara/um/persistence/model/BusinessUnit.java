package gov.nara.um.persistence.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import gov.nara.common.interfaces.INameableDto;
import gov.nara.common.persistence.model.INameableEntity;

import javax.persistence.*;
import java.util.Set;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class BusinessUnit  implements INameableEntity, INameableDto {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "businessUnit_id")
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

    ////////////////////////////////////////////
    // story #
    ///////////////////////////////////////////
    public User addUser(User user){
        this.users.add(user);
        return user;
    }
    ///////////////////////////////////////////

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
