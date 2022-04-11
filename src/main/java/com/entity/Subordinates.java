package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(
        name = "Subordinates"
)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class Subordinates extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "EmployeeId")
    private Integer employeeId;

    @Column(name = "SupervisorId")
    private Integer supervisorId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "team")
    private String team;

    @Override
    public String toString() {
        return "Subordinates{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", supervisorId=" + supervisorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", team='" + team + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subordinates)) return false;
        if (!super.equals(o)) return false;
        Subordinates that = (Subordinates) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getEmployeeId(), that.getEmployeeId()) && Objects.equals(getSupervisorId(), that.getSupervisorId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getTeam(), that.getTeam()) && Objects.equals(getLastName(), that.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getEmployeeId(), getSupervisorId(), getFirstName(), getLastName(), getTeam(), getLastName());
    }

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

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


}
