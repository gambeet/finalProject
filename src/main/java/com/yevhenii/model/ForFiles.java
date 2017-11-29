package com.yevhenii.model;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by Yevhenii on 29.11.2017.
 */
@Entity
@Table(name = "for_files", schema = "traineeDB", catalog = "")
public class ForFiles {
    private int id;
    private String name;
    private byte[] data;

    @Id
    @Column(name = "id")
    @GeneratedValue
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

    @Basic
    @Column(name = "data")
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForFiles forFiles = (ForFiles) o;

        if (id != forFiles.id) return false;
        if (name != null ? !name.equals(forFiles.name) : forFiles.name != null) return false;
        if (!Arrays.equals(data, forFiles.data)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
