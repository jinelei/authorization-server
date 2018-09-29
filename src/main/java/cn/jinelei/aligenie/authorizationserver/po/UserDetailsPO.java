package cn.jinelei.aligenie.authorizationserver.po;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "oauth_user_details")
public class UserDetailsPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "username", length = 64, nullable = false, unique = true)
    private String username;
    @Column(name = "password", length = 128, nullable = false, unique = true)
    private String password;
    @Column(name = "authorities", length = 128, nullable = false, unique = true)
    private String authorities;
    @Column(name = "is_enabled", nullable = false, unique = true)
    private boolean isEnabled;
    @Column(name = "is_expired", nullable = false, unique = true)
    private boolean isExpired;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public UserDetailsPO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsPO that = (UserDetailsPO) o;
        return userId == that.userId &&
                isEnabled == that.isEnabled &&
                isExpired == that.isExpired &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(authorities, that.authorities);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, username, password, authorities, isEnabled, isExpired);
    }

    @Override
    public String toString() {
        return "UserDetailsPO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities='" + authorities + '\'' +
                ", isEnabled=" + isEnabled +
                ", isExpired=" + isExpired +
                '}';
    }

    public UserDetailsPO(String username, String password, String authorities, boolean isEnabled, boolean isExpired) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isEnabled = isEnabled;
        this.isExpired = isExpired;
    }
}
