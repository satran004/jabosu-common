package org.jabosu.common.auth;


import com.datastax.driver.mapping.annotations.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jabosu.common.entity.BaseModel;

import java.util.*;

@Table(name = "users")
//@Strategy(naming = NamingStrategy.SNAKE_CASE)
@Getter
@Setter
@Accessors(fluent = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @PartitionKey
    @Column(name = "user_id")
    private String userId;

    @Column
    private int version;

    @Column
    private String username;

    @Column
    private String email;

    @Column(name = "pwd")
    private String password;

    @Column
    private String salt;

    @Column(name ="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "display_name")
    private String displayName;

    @Column
    private String country;

//    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "active")
    private boolean active;

    @Column(name = "email_validated")
    private boolean emailValidated;

    @Column(name="maximum_profile_count")
    private int maximumProfileCount;

//    @Column(name="roles")
//    @FrozenValue
//    private List<SecurityRole> roles = new ArrayList<>();
//
//    @Column(name="linked_accounts")
//    @FrozenValue
//    private Set<LinkedAccount> linkedAccounts = new HashSet<>();
//
//    @Column(name = "permissions")
//    @FrozenValue
//    private List<UserPermission> permissions = new ArrayList<>();
//
//    @Column(name = "profile_picture")
//    private String profilePicture;
//
//    @Required
//    @Column(name = "user_type")
//    private String userType;

    public User() {
    }

    //getter setter

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isEmailValidated() {
        return emailValidated;
    }

    public void setEmailValidated(boolean emailValidated) {
        this.emailValidated = emailValidated;
    }

    public int getMaximumProfileCount() {
        return maximumProfileCount;
    }

    public void setMaximumProfileCount(int maximumProfileCount) {
        this.maximumProfileCount = maximumProfileCount;
    }



}