package com.example.fitpal.entities;

import com.example.fitpal.enums.Gender;
import com.example.fitpal.enums.Role;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.Date;
import java.util.DoubleSummaryStatistics;

import static com.example.fitpal.config.Constants.DB_PREFIX;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = DB_PREFIX + "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String surname;
    private Date birthday;
    private Gender gender;
    private Double mass;
    private Double height;

    private Double massToLoseWeight;
    private Double desiredIntervalToLoseWeight;

    private Role role;
}
