package com.example.KMA.model;

public class UserWithBLOBs extends User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.ssl_cipher
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    private byte[] ssl_cipher;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.x509_issuer
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    private byte[] x509_issuer;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.x509_subject
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    private byte[] x509_subject;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.authentication_string
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    private String authentication_string;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.User_attributes
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    private String user_attributes;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ssl_cipher
     *
     * @return the value of user.ssl_cipher
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    public byte[] getSsl_cipher() {
        return ssl_cipher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ssl_cipher
     *
     * @param ssl_cipher the value for user.ssl_cipher
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    public void setSsl_cipher(byte[] ssl_cipher) {
        this.ssl_cipher = ssl_cipher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.x509_issuer
     *
     * @return the value of user.x509_issuer
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    public byte[] getX509_issuer() {
        return x509_issuer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.x509_issuer
     *
     * @param x509_issuer the value for user.x509_issuer
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    public void setX509_issuer(byte[] x509_issuer) {
        this.x509_issuer = x509_issuer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.x509_subject
     *
     * @return the value of user.x509_subject
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    public byte[] getX509_subject() {
        return x509_subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.x509_subject
     *
     * @param x509_subject the value for user.x509_subject
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    public void setX509_subject(byte[] x509_subject) {
        this.x509_subject = x509_subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.authentication_string
     *
     * @return the value of user.authentication_string
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    public String getAuthentication_string() {
        return authentication_string;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.authentication_string
     *
     * @param authentication_string the value for user.authentication_string
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    public void setAuthentication_string(String authentication_string) {
        this.authentication_string = authentication_string == null ? null : authentication_string.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.User_attributes
     *
     * @return the value of user.User_attributes
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    public String getUser_attributes() {
        return user_attributes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.User_attributes
     *
     * @param user_attributes the value for user.User_attributes
     *
     * @mbg.generated Sat Mar 25 20:50:26 ICT 2023
     */
    public void setUser_attributes(String user_attributes) {
        this.user_attributes = user_attributes == null ? null : user_attributes.trim();
    }
}