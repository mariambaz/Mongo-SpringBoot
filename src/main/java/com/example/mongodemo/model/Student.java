package com.example.mongodemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Student")
public class Student {

    @Id
    private String studentId;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Grad Year cannot be null")
    @Min(value = 2022, message = "Graduation year should not be before 2022")
    @Max(value = 2027, message = "Graduation year should not be after 2027")
    private short gradYear;

    @NotNull(message = "Enrollment Date cannot be null")
    @Past(message = "Enrollment date must be before the current date")
    private Date enrollmentDate;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should have a valid format")
    private String email;

    @NotNull(message = "Mobile Number cannot be null")
    // Regular Expression:
    // ^\s*                 ----> Whitespace (if any)
    // (?:\+?(\d{1,3}))?    ----> Country Code (Optional)
    //^1[0-9]{9}$           ----> Mobile Number
    @Pattern(regexp = "^\\s*(?:\\+?(\\d{1,3}))?1[0-9]{9}$", message = "Mobile number not valid")
    private String mobileNumber;

    @NotNull(message = "Undergrad status cannot be null")
    @AssertTrue(message = "Student must be an undergraduate")
    private boolean undergraduate;

    @NotNull(message = "Passed status cannot be null")
    private boolean passed;

}
