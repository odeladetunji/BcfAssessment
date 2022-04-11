package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(
        name = "Supervisors"
)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class Supervisors extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "EmployeeId")
    private Integer employeeId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "team")
    private String team;

    @Column(name = "lastName")
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Supervisors{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", team='" + team + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supervisors)) return false;
        if (!super.equals(o)) return false;
        Supervisors that = (Supervisors) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getEmployeeId(), that.getEmployeeId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getTeam(), that.getTeam()) && Objects.equals(getLastName(), that.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getEmployeeId(), getFirstName(), getTeam(), getLastName());
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
