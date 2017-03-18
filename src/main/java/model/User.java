package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public static String FIRST_NAME_KEY = "firstName";

    //    id            INT AUTO_INCREMENT PRIMARY KEY,
    private int id;

    //    first_name    VARCHAR(50)  NOT NULL,
    private String firstName;

    //    last_name     VARCHAR(50)  NOT NULL,
    private String lastName;

    //    patronymic   VARCHAR(255),
    private String patronymic;

    private String gender_code;

    //    dob           DATE,
    private LocalDate dob;

    //    telephone     VARCHAR(100) NOT NULL,
    private String telephone;

    //    email         VARCHAR(100) NOT NULL,
    private String email;

    //    password      VARCHAR(255) NOT NULL,
    private String password;

    //   height FLOAT
    private double height;

    //  weight FLOAT
    private double weight;

    //country VARCHAR(60)
    private String country;

    //city VARCHAR(60)
    private String city;

    //status_code      VARCHAR(15)  NOT NULL,
    private String status_code;

    //rating INT,
    private int rating;

}
