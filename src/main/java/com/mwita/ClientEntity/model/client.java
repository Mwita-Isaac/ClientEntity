package com.mwita.ClientEntity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Client_first_name")
    private String firstName;

    @Column(name = "Client_last_name")
    private String lastName;

    @Column(name = "Client_email_id")
    private String emailId;

}
