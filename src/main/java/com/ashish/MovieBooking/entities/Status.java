package com.ashish.MovieBooking.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`status`")
public class Status {

    @Id
    @GeneratedValue
    private int statusId;

    @Column(length = 20, nullable = false, unique = true)
    private String statusName;

    public Status( String statusName) {
        this.statusName = statusName;
    }

    public Status() {

    }
}
