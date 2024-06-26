package com.atguigu.servicerenwuku.controller;


import com.atguigu.servicerenwuku.entity.*;
import com.atguigu.servicerenwuku.service.GrowthTrackService;
import com.atguigu.servicerenwuku.service.PhotoService;
import com.atguigu.servicerenwuku.service.RenwukuService;
import com.atguigu.servicerenwuku.util.IdWorker;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/service/renwuku")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "人物库")
public class RenwukuController {
    @Autowired
    RenwukuService service;
    @Autowired
    PhotoService photoService;
    @Autowired
    GrowthTrackService growthTrackService;

    @ApiOperation(value = "查询人物库所有成员")
    @GetMapping("/queryallpeople")//查询人物库所有成员
    public ResultVo queryallpeople() {
        ResultVo<Object> resultVo = new ResultVo();
        List<PersonVo> list = new ArrayList<>();
        try {
            list = service.queryallpeople();
            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "增加人物库成员")
    @PostMapping("/addPeople")//增加人物库成员
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public ResultVo addPeople(Person person) {
        IdWorker idWorker = new IdWorker(1, 1);
        ResultVo resultVo = new ResultVo();
        try {
            String id = String.valueOf(idWorker.nextId());
            person.setId(id);

            /*
             * 成长轨迹添加
             *
             *
             * */
            GrowthTrack growthTrack = new GrowthTrack(id, person.getPositionAxis(), person.getActiveAxis(), person.getAwardAxis());
            growthTrackService.save(new GrowthTrack(id, person.getPositionAxis(), person.getActiveAxis(), person.getAwardAxis()));
            person.setGrowthTrackId(id);
            /*
            人物库资料添加
             */
            Person_personal person_personal = new Person_personal(person.getId(), person.getName(), person.getSex(),
                    person.getNationId(), person.getBirth(), person.getPoliticsId(), person.getNativePlace(), person.getBachelorId(),
                    person.getFulltimedegreeId(), person.getPhone(), person.getAreaId(),
                    person.getCampusId(), id);

            Person_staff person_staff = new Person_staff(person.getId(), person.getDepartmentId(), person.getCurrentPositionId(),
                    person.getTitleId(), person.getJob(), person.getJobLevelId(), person.getPartyId(), person.getOtherPartyId(),
                    person.getJoinPartyDate(), person.getPoliticalPositionId(), person.getOrganizationId(), id);

            service.addPeopletoPersonal(person_personal);
            service.addPeopletoStaff(person_staff);


            /*
            头像上传
             */
            String imgUrl;
            String imgName;
            if (ObjectUtils.isEmpty(person.getPhoto())) {
                imgUrl = "";
                imgName = "";
            } else {
                imgUrl = "http://localhost:9106/RenWuKuPhoto/" + person.getPhoto().getOriginalFilename();
                imgName = person.getPhoto().getOriginalFilename();
                InputStream inputStream = person.getPhoto().getInputStream();
                File file = new File("service/service-renwuku/src/main/resources/static/image/" + person.getPhoto().getOriginalFilename());
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bytes = new byte[1024 * 8];
                int len = 0;
                while ((len = inputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                }
                fileOutputStream.close();
                inputStream.close();
            }

            Photo photo = new Photo(id, imgUrl, imgName);
            photoService.save(photo);
            person.setPhotoId(id);


            resultVo.setMess("添加人物库成员成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();  //事务手动设置回滚
            resultVo.setMess("添加人物库成员失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "根据id删除人物库成员")
    @PostMapping("/deletePeople/{id}")  //根据id删除人物库成员
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public ResultVo deletePeople(@PathVariable(value = "id") String id) {
        ResultVo resultVo = new ResultVo();
        try {
            Photo photo = photoService.getById(id);
            String fileName = "service/service-renwuku/src/main/resources/static/image/" + photo.getImgName();
            File file = new File(fileName);
            file.delete();
            photoService.removeById(id);
            growthTrackService.removeById(id);
            service.deletePeople(id);
            resultVo.setMess("删除人物库成员成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("删除人物库成员失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "修改人物库成员")
    @PostMapping("/updatePeople")   //修改人物库成员
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public ResultVo updatePeople(Person person) {
        IdWorker idWorker = new IdWorker(1, 1);
        ResultVo resultVo = new ResultVo();
        try {
            //判断是否上传了新的照片
            if (person.getPhoto().getSize() != 0) {
                //先删除原来的照片
                Photo photo = photoService.getById(person.getPhotoId());
                String fileName = "service/service-renwuku/src/main/resources/static/image/" + photo.getImgName();
                File file = new File(fileName);
                file.delete();
                photoService.removeById(person.getPhotoId());

                //上传新的照片
                InputStream inputStream = person.getPhoto().getInputStream();
                File newFile = new File("service/service-renwuku/src/main/resources/static/image/" + person.getPhoto().getOriginalFilename());
                FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                byte[] bytes = new byte[1024 * 8];
                int len = 0;
                while ((len = inputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                }
                fileOutputStream.close();
                inputStream.close();
                String imgUrl = "http://localhost:9106/RenWuKuPhoto/" + person.getPhoto().getOriginalFilename();
                String imgName = person.getPhoto().getOriginalFilename();
                Photo newPhoto = new Photo(person.getId(), imgUrl, imgName);
                photoService.save(photo);
            }
            //修改成长轨迹
            GrowthTrack growthTrack = new GrowthTrack(person.getId(), person.getPositionAxis(), person.getActiveAxis(), person.getAwardAxis());
            growthTrackService.updateByEntity(growthTrack);

            Person_personal person_personal = new Person_personal(person.getId(), person.getName(), person.getSex(),
                    person.getNationId(), person.getBirth(), person.getPoliticsId(), person.getNativePlace(), person.getBachelorId(),
                    person.getFulltimedegreeId(), person.getPhone(), person.getAreaId(),
                    person.getCampusId(), person.getPhotoId());

            Person_staff person_staff = new Person_staff(person.getId(), person.getDepartmentId(), person.getCurrentPositionId(),
                    person.getTitleId(), person.getJob(), person.getJobLevelId(), person.getPartyId(), person.getOtherPartyId(),
                    person.getJoinPartyDate(), person.getPoliticalPositionId(), person.getOrganizationId(), person.getGrowthTrackId());
            service.updatePeopletoPersonal(person_personal);
            service.updatePeopletoStaff(person_staff);
            resultVo.setMess("修改人物库成员成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();  //事务手动设置回滚
            resultVo.setMess("修改人物库成员失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    @ApiOperation(value = "模糊查询成员")
    @GetMapping("/queryPeopleByCondition")
    public ResultVo queryPeopleByCondition(String name,
                                           String partyId,
                                           String departmentId,
                                           String otherPartyId) {
        ResultVo<Object> resultVo = new ResultVo();
        List<PersonVo> list;
        try {
            list = service.queryPeopleByCondition(name, partyId, departmentId, otherPartyId);
            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }


}
