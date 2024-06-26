package com.atguigu.serviceorganization.service.impl;

import com.atguigu.serviceorganization.entity.PoliticalEntity;
import com.atguigu.serviceorganization.service.DepartmentService;
import com.atguigu.serviceorganization.util.PageUtils;
import com.atguigu.serviceorganization.util.Query;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.serviceorganization.dao.StaffInfoDao;
import com.atguigu.serviceorganization.entity.StaffInfoEntity;
import com.atguigu.serviceorganization.service.StaffInfoService;

import java.util.List;
import java.util.Map;


@Service("staffInfoService")
public class StaffInfoServiceImpl extends ServiceImpl<StaffInfoDao, StaffInfoEntity> implements StaffInfoService {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public PageUtils getAllStaffInfoByDepartmentId(String id,Map<String, Object> params) {
        QueryWrapper<StaffInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.like("department_id", id);

        IPage<StaffInfoEntity> page = this.page(
                new Query<StaffInfoEntity>().getPage(params),
                wrapper
        );

        PageUtils pageUtils = new PageUtils(page);
        return pageUtils;
    }

    @Override
    public PageUtils getAllStaffInfoByPartyId(String id, Map<String, Object> params) {
        QueryWrapper<StaffInfoEntity> wrapper = new QueryWrapper<>();
        wrapper.like("party_id", id);

        IPage<StaffInfoEntity> page = this.page(
                new Query<StaffInfoEntity>().getPage(params),
                wrapper
        );

        PageUtils pageUtils = new PageUtils(page);
        return pageUtils;
    }

    @Override
    public StaffInfoEntity getStaffInfoByPersonId(String id) {
        QueryWrapper<StaffInfoEntity> wrapper = new QueryWrapper<>();
        StaffInfoEntity entity = baseMapper.selectOne(wrapper.like("s_id",id));
        return entity;
    }

    @Override
    public PageUtils getAllStaffInfoByPartyOthersId(String id, Map<String, Object> params) {
        QueryWrapper<StaffInfoEntity> wrapper = new QueryWrapper<>();
        IPage<StaffInfoEntity> page = this.page(
                new Query<StaffInfoEntity>().getPage(params),
                wrapper.like("party_others_id",id)
        );

        PageUtils pageUtils = new PageUtils(page);
        return pageUtils;
    }

    @Override
    public PageUtils getAllStaffInfoByCategoryId(List<PoliticalEntity> categories, Map<String, Object> params) {
        QueryWrapper<StaffInfoEntity> wrapper = new QueryWrapper<>();
        IPage<StaffInfoEntity> page=null;
        if(categories.size()==4) {
            page = this.page(
                    new Query<StaffInfoEntity>().getPage(params),
                    wrapper.eq("politicalPosition_id",categories.get(0).getPoliticalpositionId())
                            .or().eq("politicalPosition_id",categories.get(1).getPoliticalpositionId())
                            .or().eq("politicalPosition_id",categories.get(2).getPoliticalpositionId())
                            .or().eq("politicalPosition_id",categories.get(3).getPoliticalpositionId())

            );
        }else{
            page = this.page(
                    new Query<StaffInfoEntity>().getPage(params),
                    wrapper.eq("politicalPosition_id", categories.get(0))
            );
        }

        PageUtils pageUtils = new PageUtils(page);
        return pageUtils;
    }

    @Override
    public void getStaffInfoCount(OrganizationVo vo) {
        Integer count = baseMapper.selectCount(new QueryWrapper<StaffInfoEntity>().eq("department_id", vo.getId())
                .or().eq("party_id", vo.getId())
                .or().eq("party_others_id", vo.getId())
                .or().eq("politicalPosition_id", vo.getId()));
        vo.setSum(String.valueOf(count));
    }


}