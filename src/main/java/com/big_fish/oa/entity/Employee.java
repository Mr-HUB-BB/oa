package com.big_fish.oa.entity;

/**
 * ClassName: Employee
 * Description:
 * date: 2022/2/4 23:51
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */
public class Employee {
    private Long id;
    private String name;
    private Long departmentId;
    private String title;
    private Integer level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
