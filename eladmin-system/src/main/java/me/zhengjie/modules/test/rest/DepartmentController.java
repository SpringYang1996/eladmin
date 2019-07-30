package me.zhengjie.modules.test.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.test.domain.Department;
import me.zhengjie.modules.test.service.DepartmentService;
import me.zhengjie.modules.test.service.dto.DepartmentQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;



/**
* @author YnagXu
* @date 2019-07-30
*/
@Api(tags = "Department管理")
@RestController
@RequestMapping("api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Log("查询Department")
    @ApiOperation(value = "查询Department")
    @GetMapping(value = "/department")
    @PreAuthorize("hasAnyRole('ADMIN','DEPARTMENT_ALL','DEPARTMENT_SELECT')")
    public ResponseEntity getDepartments(DepartmentQueryCriteria criteria, IPage<Department> page){
        return new ResponseEntity(departmentService.queryAll(criteria,page),HttpStatus.OK);
    }

    @Log("新增Department")
    @ApiOperation(value = "新增Department")
    @PostMapping(value = "/department")
    @PreAuthorize("hasAnyRole('ADMIN','DEPARTMENT_ALL','DEPARTMENT_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Department resources){
        return new ResponseEntity(departmentService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Department")
    @ApiOperation(value = "修改Department")
    @PutMapping(value = "/department")
    @PreAuthorize("hasAnyRole('ADMIN','DEPARTMENT_ALL','DEPARTMENT_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Department resources){
        departmentService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Department")
    @ApiOperation(value = "删除Department")
    @DeleteMapping(value = "/department/{dId}")
    @PreAuthorize("hasAnyRole('ADMIN','DEPARTMENT_ALL','DEPARTMENT_DELETE')")
    public ResponseEntity delete(@PathVariable Long dId){
        departmentService.delete(dId);
        return new ResponseEntity(HttpStatus.OK);
    }
}