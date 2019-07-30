package me.zhengjie.modules.test.repository;

import me.zhengjie.modules.test.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author YnagXu
* @date 2019-07-30
*/
public interface DepartmentRepository extends JpaRepository<Department, Long>, JpaSpecificationExecutor {
}