package com.yevhenii.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Yevhenii on 28.11.2017.
 */
@Entity
public class Role {
    private int id;
    private String name;
    private Collection<UserToRole> userToRolesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<UserToRole> getUserToRolesById() {
        return userToRolesById;
    }

    public void setUserToRolesById(Collection<UserToRole> userToRolesById) {
        this.userToRolesById = userToRolesById;
    }
}
