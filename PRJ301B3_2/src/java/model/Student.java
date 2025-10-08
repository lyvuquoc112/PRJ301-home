/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hanly
 */
public class Student {
    private int studentId;
    private String  fullName, gender, dob, email, phone;

    public Student() {
    }

    public Student(int studentId, String fullName, String gender, String dob, String email, String phone) {
        this.studentId = studentId;
        this.fullName = fullName;

        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public Student(String fullName, String gender, String dob, String email, String phone) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", fullName=" + fullName + ", dob=" + dob + ", gender=" + gender + ", email=" + email + ", phone=" + phone + '}';
    }

}
