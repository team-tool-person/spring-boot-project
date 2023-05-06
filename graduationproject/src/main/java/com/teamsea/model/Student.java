package com.teamsea.model;

import java.util.Date;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.id
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.name
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.age
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private Byte age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.sex
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.category
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private String category;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.enrollmenttime
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private Date enrollmenttime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.graduationtime
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private Date graduationtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.course
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private Integer course;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.pushword
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private Byte pushword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.isdelete
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private Byte isdelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.password
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.id
     *
     * @return the value of student.id
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.id
     *
     * @param id the value for student.id
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.name
     *
     * @return the value of student.name
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.name
     *
     * @param name the value for student.name
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.age
     *
     * @return the value of student.age
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public Byte getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.age
     *
     * @param age the value for student.age
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setAge(Byte age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.sex
     *
     * @return the value of student.sex
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.sex
     *
     * @param sex the value for student.sex
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.category
     *
     * @return the value of student.category
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.category
     *
     * @param category the value for student.category
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.enrollmenttime
     *
     * @return the value of student.enrollmenttime
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public Date getEnrollmenttime() {
        return enrollmenttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.enrollmenttime
     *
     * @param enrollmenttime the value for student.enrollmenttime
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setEnrollmenttime(Date enrollmenttime) {
        this.enrollmenttime = enrollmenttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.graduationtime
     *
     * @return the value of student.graduationtime
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public Date getGraduationtime() {
        return graduationtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.graduationtime
     *
     * @param graduationtime the value for student.graduationtime
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setGraduationtime(Date graduationtime) {
        this.graduationtime = graduationtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.course
     *
     * @return the value of student.course
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public Integer getCourse() {
        return course;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.course
     *
     * @param course the value for student.course
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setCourse(Integer course) {
        this.course = course;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.pushword
     *
     * @return the value of student.pushword
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public Byte getPushword() {
        return pushword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.pushword
     *
     * @param pushword the value for student.pushword
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setPushword(Byte pushword) {
        this.pushword = pushword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.isdelete
     *
     * @return the value of student.isdelete
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public Byte getIsdelete() {
        return isdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.isdelete
     *
     * @param isdelete the value for student.isdelete
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.password
     *
     * @return the value of student.password
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.password
     *
     * @param password the value for student.password
     *
     * @mbg.generated Sat May 06 16:20:09 CST 2023
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}