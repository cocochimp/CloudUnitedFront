package com.atguigu.serviceorganization;
import com.atguigu.serviceorganization.dao.DepartmentDao;
import com.atguigu.serviceorganization.dao.NationDao;
import com.atguigu.serviceorganization.entity.DepartmentEntity;
import com.atguigu.serviceorganization.entity.NationEntity;
import com.atguigu.serviceorganization.entity.PoliticalEntity;
import com.atguigu.serviceorganization.entity.StaffInfoEntity;
import com.atguigu.serviceorganization.service.*;
import com.atguigu.serviceorganization.util.PageUtils;
import com.atguigu.serviceorganization.util.ParamsUtils;
import com.atguigu.serviceorganization.util.QueryResult;
import com.atguigu.serviceorganization.vo.DepartmentVo;
import com.atguigu.serviceorganization.vo.OrganizationVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    StaffInfoService staffInfoService;
    @Autowired
    StaffService staffService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticalService politicalService;
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    NationDao nationDao;



    @Test
    public void test01(){
        DepartmentEntity departmentEntity = departmentService.getDepartmentIdByName("水产学院党委");
        PageUtils page= staffInfoService.getAllStaffInfoByDepartmentId(departmentEntity.getDepartmentId(),new ParamsUtils(1,5).getParams());
    }


    @Test
    public void test02(){
//        List<BasicPersonVo> list = staffService.queryPage("水产学院党委", 1, 5);
//        for(BasicPersonVo item:list)
//            System.out.println(item.toString());
    }

    @Test
    public void test023(){
//        List<NationEntity> list = nationService.getAllNationMinority();
//        for(NationEntity item:list)
//            System.out.println(item.toString());
//        NationEntity hanNationId = nationService.getHanNationId();
//        System.out.println(hanNationId.toString());
    }

    @Test
    public void test03(){
        List<PoliticalEntity> list = politicalService.getPoliticalByName("人大代表");
        PageUtils categoryId = staffInfoService.getAllStaffInfoByCategoryId(list, new ParamsUtils(1, 5).getParams());
        List<StaffInfoEntity> list1 = (List<StaffInfoEntity>)categoryId.getList();

        for(StaffInfoEntity item:list1)
        {
            System.out.println(item.toString());
        }
    }

    @Test
    public void test05(){
//        List<String> list=new ArrayList<>();
//        departmentService.getAllDepartmentId(list);
//        politicalService.getAllPoliticalId(list);
//        for(String s:list){
//            System.out.println(s);
//        }
    }

    @Test
    public void test06(){
        OrganizationVo vo = new OrganizationVo();
        vo.setId("6948211641926422550");
        vo.setDepartment("阿丽莎");
        staffInfoService.getStaffInfoCount(vo);
    }

    @Test
    public void test07(){
        QueryResult queryResult = departmentService.queryPageBySearch("梁", "滨海农业学院党委", 1, 5);
        List<DepartmentVo> info = (List<DepartmentVo>)queryResult.getPageInfo().get("info");
        for(DepartmentVo vo:info){
            System.out.println(vo.toString());
        }

    }

    @Test
    public void test081(){
        QueryResult queryResult = politicalService.queryPageBySearch("王欣平", "人大代表", 1, 5);


    }


    @Test
    public void test08(){
        departmentDao.queryPageBySearch("梁", "滨海农业学院党委");
    }

//    @Test
//    public void test09(){
//        staffService.queryPageByNation()
//    }
}
