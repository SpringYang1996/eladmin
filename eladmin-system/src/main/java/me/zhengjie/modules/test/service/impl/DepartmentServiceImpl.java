package me.zhengjie.modules.test.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.zhengjie.tool.WrapperFactory;
import me.zhengjie.modules.test.domain.Department;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.zhengjie.modules.test.service.DepartmentService;
import me.zhengjie.modules.test.service.dto.DepartmentQueryCriteria;
import me.zhengjie.modules.test.service.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




/**
* @author YnagXu
* @date 2019-07-30
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public IPage<Department> queryAll(DepartmentQueryCriteria criteria, IPage<Department> page){
        QueryWrapper<Department> queryWrapper=new WrapperFactory<Department>().dtoToQueryWrapper(criteria,null);
        return departmentMapper.selectPage(page,queryWrapper);
    }

    @Override
    public List<Department> queryAll(DepartmentQueryCriteria criteria){
        QueryWrapper<Department> queryWrapper=new WrapperFactory<Department>().dtoToQueryWrapper(criteria,null);
        return departmentMapper.selectList(queryWrapper);
    }

    @Override
    public Department findById(Long dId) {
        return departmentMapper.selectById(dId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Department create(Department resources) {
        departmentMapper.insert(resources);
        return resources;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Department resources) {
        departmentMapper.update(resources,null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long dId) {
        departmentMapper.deleteById(dId);
    }
}