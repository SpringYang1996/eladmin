package me.zhengjie.modules.test.service;

import me.zhengjie.modules.test.domain.Department;
import me.zhengjie.modules.test.service.dto.DepartmentQueryCriteria;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author YnagXu
* @date 2019-07-30
*/
//@CacheConfig(cacheNames = "department")
public interface DepartmentService extends IService<Department>{

    /**
    * queryAll 分页
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    IPage<Department> queryAll(DepartmentQueryCriteria criteria, IPage<Department> page);


    /**
    * queryAll 不分页
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public List<Department> queryAll(DepartmentQueryCriteria criteria);

    /**
     * findById
     * @param dId
     * @return
     */
    //@Cacheable(key = "#p0")
    Department findById(Long dId);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    Department create(Department resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(Department resources);

    /**
     * delete
     * @param dId
     */
    //@CacheEvict(allEntries = true)
    void delete(Long dId);
}