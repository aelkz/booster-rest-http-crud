package org.obsidiantoaster.quickstart.jdbc;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Heiko Braun
 */
@Entity
@Table(name = "known_fruits")
@NamedQueries({
        @NamedQuery(name = "Fruits.findAll", query = "SELECT f FROM Fruit f")
})
public class Fruit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(
            name = "fruitsSequence",
            sequenceName = "known_fruits_id_seq",
            allocationSize = 1,
            initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruitsSequence")

    private int id;

    @Column(length = 40, unique = true)
    private String name;

    public Fruit() {
    }

    public Fruit(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof Fruit))
            return false;
        Fruit that = (Fruit) obj;
        if (that.name.equals(this.name) && that.id == this.id)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

}
