package gov.nara.um.persistence.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import gov.nara.common.interfaces.INameableDto;
import gov.nara.common.persistence.model.INameableEntity;

@Entity
@Data
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "user")
public class User implements INameableEntity, INameableDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name="user_name", unique = true, nullable = false)
    private String name;

    @Column( nullable = false)
    private String user_type;


    // @formatter:off
    @ManyToMany( cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "role_id") })
    private Set<Role> roles;

    @ManyToOne
    private BusinessUnit businessUnit;

    // @formatter:on
    public User() {
        super();


    }

    public User(final String nameToSet, final String passwordToSet, final Set<Role> rolesToSet) {
        super();

       name = nameToSet;
        //password = passwordToSet;
        roles = rolesToSet;
    }

    // API

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long idToSet) {
        id = idToSet;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }



    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }


}