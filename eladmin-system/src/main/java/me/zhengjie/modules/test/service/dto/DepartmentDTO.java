package me.zhengjie.modules.test.service.dto;

import lombok.Data;
import java.io.Serializable;


/**
* @author YnagXu
* @date 2019-07-30
*/
@Data
public class DepartmentDTO implements Serializable {

    // ID
    private Long dId;

    // 部门
    private String dName;
}