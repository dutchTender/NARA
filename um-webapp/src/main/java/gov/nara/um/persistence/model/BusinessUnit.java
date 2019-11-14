package gov.nara.um.persistence.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import gov.nara.common.interfaces.INameableDto;
import gov.nara.common.persistence.model.INameableEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

@Table(name = "business_unit_catalog")
public class BusinessUnit  implements INameableEntity, INameableDto {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column( nullable = false)
    private String org_code;

    @Column( name="ldap_id", nullable = true)
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

    public void removeUser(User user){
        this.users.remove(user);
    }
    ///////////////////////////////////////////

    @Override
    public String getName() {
       String returnValue = name;

       return returnValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessUnit that = (BusinessUnit) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                org_code.equals(that.org_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, org_code);
    }

    @Override
    public String toString() {
        return "BusinessUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", org_code='" + org_code + '\'' +
                '}';
    }
}
