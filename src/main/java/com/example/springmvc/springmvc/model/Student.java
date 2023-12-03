package com.example.springmvc.springmvc.model;

import com.example.springmvc.springmvc.annotation.CourseCode;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

public class Student {
    @NotNull(message = "is required")
    @Size(min = 3, message = "the length must be at least 3 character")
    private String firstName;
    private String lastName;
    @NotBlank
    @Pattern(regexp = "^[0-9]{10}",message = "Phone Number must be 10 length")
    private String phoneNumber;
    @NotNull
    @Min(value = 1)
    private Integer age;  // primitive type - int will not work for @NotNull
    private String country;
    private String favoriteLanguage;
    private List<String> favoriteOS;
    @CourseCode
    //@CourseCode(value = "CH",message = "code must start with CH")
    private String promotionCode;

    public Student() {

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public List<String> getFavoriteOS() {
        return favoriteOS;
    }

    public void setFavoriteOS(List<String> favoriteOS) {
        this.favoriteOS = favoriteOS;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }
}
