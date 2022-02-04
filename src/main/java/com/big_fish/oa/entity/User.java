package com.big_fish.oa.entity;

/**
 * ClassName: User
 * Description:
 * date: 2022/1/30 0:52
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */
public class User {
    private Long userId;
    private String username;
    private String password;
    private Long employeeId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
