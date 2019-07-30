package me.zhengjie.modules.test.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
* @author YnagXu
* @date 2019-07-30
*/

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Department extends Model<Department>  implements Serializable {

    // ID
    @TableId(value = "dId", type = IdType.AUTO)
    private Long dId;

    // 部门
    private String dName;



}