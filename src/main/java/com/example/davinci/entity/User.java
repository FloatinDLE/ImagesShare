package com.example.davinci.entity;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Component
@Table(name="t_users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private int userNo;
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名不能超过20个字符")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
    @Column(name = "user_name")
    private String userName;
    @NotBlank(message = "联系邮箱不能为空")
    @Email(message = "邮箱格式错误")
    @Column(name = "user_email")
    private String userEmail;
    @NotBlank(message = "密码不能为空")
    @Column(name = "user_pwd")
    private String userPwd;
    public int getUserNo(){
        return userNo;
    }
    public void setUserNo(int userNo){
        this.userNo=userNo;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getUserEmail(){
        return userEmail;
    }
    public void setUserEmail(String userEmail){
        this.userEmail=userEmail;
    }
    public String getUserPwd(){
        return userPwd;
    }
    public void setUserPwd(String userPwd){
        this.userPwd=userPwd;
    }
}
