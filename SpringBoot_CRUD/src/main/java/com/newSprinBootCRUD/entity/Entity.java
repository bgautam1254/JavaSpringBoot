package com.newSprinBootCRUD.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@jakarta.persistence.Entity             // rows of the database will be created by --> @Entity annotations only
@Data               // @Data --> @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
@AllArgsConstructor // it creates constructor with all-field-arguments
@NoArgsConstructor  // it creates constructor with no-arguments
public class Entity {
    /*
     1. Below variables will become the tables --> rows of the database.
        These variables would be converted from camelCaseNotation to UPPERCASE_SNAKE_CASE_NOTATION
        example: departmentId      --> DEPARTMENT_ID
                 departmentName    --> DEPARTMENT_NAME
                 departmentAddress --> DEPARTMENT_ADDRESS
                 departmentCode    --> DEPARTMENT_CODE

     2. We will create   1. empty constructor
                         2. All field --> parametrized constructors
                         3. All field --> toString(){} method
                         4. All field --> getter and setter

     3. Only with @Entity annotation the rows of the database will be created.

     */

    @Id                                                 // make departmentId as primary key
    @GeneratedValue(strategy = GenerationType.AUTO)     //this will automatically generate new departmentId
    private Long departmentId;

    //    @Length(max=5, min=1)
    //    @Size(max=10, min=0)
    //    @Email()
    //    @Positive
    //    @Negative
    //    @PositiveOrZero
    //    @NegativeOrZero
    //    @Future
    //    @FutureOrPresent
    //    @Past
    //    @PastOrPresentF
    @NotBlank(message = "Please enter Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


//    //    GetMapping will work with an empty constructor, else will not show list
//    public Department() {
//    }
//
//
//    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
//        this.departmentId = departmentId;
//        this.departmentName = departmentName;
//        this.departmentAddress = departmentAddress;
//        this.departmentCode = departmentCode;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' +
//                ", departmentAddress='" + departmentAddress + '\'' +
//                ", departmentCode='" + departmentCode + '\'' +
//                '}';
//    }
//
//
//    public Long getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Long departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//
//    public String getDepartmentAddress() {
//        return departmentAddress;
//    }
//
//    public void setDepartmentAddress(String departmentAddress) {
//        this.departmentAddress = departmentAddress;
//    }
//
//    public String getDepartmentCode() {
//        return departmentCode;
//    }
//
//    public void setDepartmentCode(String departmentCode) {
//        this.departmentCode = departmentCode;
//    }


}


