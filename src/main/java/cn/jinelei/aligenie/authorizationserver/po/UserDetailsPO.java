package cn.jinelei.aligenie.authorizationserver.po;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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
    @Column(name = "account_non_expired", nullable = false, unique = true)
    private boolean accountNonExpired;
    @Column(name = "account_non_locked", nullable = false, unique = true)
    private boolean accountNonLocked;
    @Column(name = "credentials_non_expired", nullable = false, unique = true)
    private boolean credentialsNonExpired;
    @Column(name = "enable", nullable = false, unique = true)
    private boolean enabled;

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

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
