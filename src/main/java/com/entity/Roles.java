package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(
        name = "Roles"
)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class Roles extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Eroles name;

    public Roles() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Eroles getName() {
        return name;
    }

    public void setName(Eroles erole) {
        this.name = erole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roles)) return false;
        if (!super.equals(o)) return false;
        Roles roles = (Roles) o;
        return Objects.equals(getId(), roles.getId()) && getName() == roles.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getName());
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
