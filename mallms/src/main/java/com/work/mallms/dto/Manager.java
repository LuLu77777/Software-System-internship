package com.work.mallms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Manager {
    private String mgrId;
    private String loginName;
    private String loginPwd;
    private String mgrName;
    private String mgrGender;
    private String mgrTel;
    private String mgrEmail;
    private String mgrQQ;
    private Date createTime;

}
