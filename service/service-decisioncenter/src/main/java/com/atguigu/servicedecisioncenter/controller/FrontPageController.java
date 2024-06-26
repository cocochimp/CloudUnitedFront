package com.atguigu.servicedecisioncenter.controller;

import com.atguigu.servicedecisioncenter.entity.ResultVo;
import com.atguigu.servicedecisioncenter.service.FrontPageService;
import com.atguigu.servicedecisioncenter.service.MinZuDangPaiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;


@RestController
@RequestMapping("/service/servicedecisioncenter/FrontPage")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "1、首页接口")
public class FrontPageController {

    @Autowired
    FrontPageService service;

    @Autowired
    MinZuDangPaiService minzudangpaiservice;

    ResultVo resultVo = new ResultVo();

    //1-1、少数民族老师和学生比例(不带参)
    @ApiOperation(value = "1-1、少数民族老师和学生比例(主页)")
    @PostMapping("/queryNational")
    public ResultVo queryNational() {
        try {
            Integer totalOfTeacher = service.queryNationalDistributionOfTeacher(); //查询少数民族老师数量
            Integer totalOfStudent = service.queryNationalDistributionOfStudent(); //查询少数民族学生数量
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> teacherMap=new HashMap<String, String>();
            teacherMap.put("type","老师");
            teacherMap.put("totalOfTeacher",String.valueOf(totalOfTeacher));
            Map<String, String> studentMap=new HashMap<String, String>();
            studentMap.put("type","学生");
            studentMap.put("totalOfStudent",String.valueOf(totalOfStudent));
            Map<String, String> totalMap=new HashMap<String, String>();
            totalMap.put("total",String.valueOf(totalOfTeacher+totalOfStudent));
            list.add(studentMap);
            list.add(teacherMap);
            list.add(totalMap);
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

    //1-2、少数民族老师和学生比例(带参)
    @ApiOperation(value = "1-2、少数民族老师和学生比例(点击学院分)")
    @PostMapping("/queryNational/{department}")
    public ResultVo queryNationalByDepartment(@PathVariable("department") String department) {
        try {
            Integer totalOfTeacher = service.queryNationalDistributionOfTeacherByDepartment(department); //查询少数民族老师数量
            Integer totalOfStudent = service.queryNationalDistributionOfStudentByDepartment(department); //查询少数民族学生数量
            List<Map<String, String>> list = new ArrayList<>();
            Map<String, String> teacherMap=new HashMap<String, String>();
            teacherMap.put("type","老师");
            teacherMap.put("totalOfTeacher",String.valueOf(totalOfTeacher));
            Map<String, String> studentMap=new HashMap<String, String>();
            studentMap.put("type","学生");
            studentMap.put("totalOfStudent",String.valueOf(totalOfStudent));
            Map<String, String> totalMap=new HashMap<String, String>();
            totalMap.put("total",String.valueOf(totalOfTeacher+totalOfStudent));
            list.add(studentMap);
            list.add(teacherMap);
            list.add(totalMap);
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

    //2-1、港澳台分布(不带参)
    @ApiOperation(value = "2-1、港澳台(主页)")
    @PostMapping("/queryGangAoTai")
    public ResultVo queryGangAoTai() {
        try {
            Map<String, List<String>> map = new HashMap<>();
            List<String> area = new ArrayList<>();
            List<String> total = new ArrayList<>();
            List<Integer> total1;
            List<String> totalCount = new ArrayList<>();
            Integer count = 0;
            area.add("大陆");
            area.add("台湾区域");
            area.add("澳门区域");
            area.add("香港区域");
            area.add("台属");
            total1 = service.queryGangAoTaiDistribution();

            for (Integer integer : total1) {
                total.add(String.valueOf(integer));
                count += integer;
            }
            totalCount.add(String.valueOf(count));
            map.put("area", area);
            map.put("total", total);
            map.put("count", totalCount);
            resultVo.setT(map);

//            resultVo.setT(integerList);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //2-2、港澳台分布(带参)
    @ApiOperation(value = "2-2、港澳台(点击学院分)")
    @PostMapping("/queryGangAoTai/{department}")
    public ResultVo queryDegreeByDepartment(@PathVariable("department") String department) {
        try {
//            List<Map<String,Integer>> integerList=service.queryGangAoTaiDistributionByDepartment(department);

            Map<String, List<String>> map = new HashMap<>();
            List<String> area = new ArrayList<>();
            List<String> total = new ArrayList<>();
            List<Integer> total1;
            List<String> totalCount = new ArrayList<>();
            Integer count = 0;
            area.add("大陆");
            area.add("台湾区域");
            area.add("澳门区域");
            area.add("香港区域");
            area.add("台属");

            total1 = service.queryGangAoTaiDistributionByDepartment(department);

            for (Integer integer : total1) {
                total.add(String.valueOf(integer));
                count += integer;
            }
            totalCount.add(String.valueOf(count));
            map.put("area", area);
            map.put("total", total);
            map.put("count", totalCount);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }
        return resultVo;
    }

    //3、获奖情况
    @ApiOperation(value = "3、获奖情况")
    @PostMapping("/queryAward")
    public ResultVo queryAward() {
        ResultVo resultVo = new ResultVo();
        Map<String, List<Integer>> map = new HashMap<>();
        try {
            List<Integer> integerList9 = service.queryAwardCountryLevel();
            map.put("AwardCountryLevel", integerList9);

            List<Integer> integerList10 = service.queryAwardProvincialLevel();
            map.put("AwardProvincialLevel", integerList10);

            List<Integer> integerList = new ArrayList<>();
            Integer integer = integerList9.stream().mapToInt(Integer::intValue).sum() + integerList10.stream().mapToInt(Integer::intValue).sum();
            integerList.add(integer);
            map.put("count", integerList);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMess("查询失败");
            resultVo.setT(false);
        }

        return resultVo;
    }

    //4-1、统战工作对象(不带参)
    @ApiOperation(value = "4-1、统战工作对象(主页)")
    @PostMapping("/WorkObject")
    public ResultVo WorkObject() {
        ResultVo resultVo = new ResultVo();
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Integer totalOfStudent = service.queryNationalDistributionOfStudent(); //查询少数民族学生数量
        try {
            list = service.queryWorkObject();
            map.put("民主党派", list.get(0));
            map.put("无党派人士", list.get(1)+list.get(2));
            map.put("知联会", list.get(2));
            map.put("少数民族", list.get(3)+totalOfStudent);
            map.put("留学归国人员", list.get(4));
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //4-2、统战工作对象(带参)
    @ApiOperation(value = "4-2、统战工作对象(点击学院分)")
    @PostMapping("/WorkObject/{department}")
    public ResultVo WorkObject(@PathVariable("department") String department) {
        ResultVo resultVo = new ResultVo();
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Integer totalOfStudent = service.queryNationalDistributionOfStudentByDepartment(department); //查询少数民族学生数量
        try {
            list = service.queryWorkObjectByDepartment(department);
            map.put("民主党派", list.get(0));
            map.put("无党派人士", list.get(1)+list.get(2));
            map.put("知联会", list.get(2));
            map.put("少数民族", list.get(3)+totalOfStudent);
            map.put("留学归国人员", list.get(4));
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //5-1、党外干部(不带参)
    @ApiOperation(value = "5-1、党外干部(主页)")
    @PostMapping("/NonPartyCadres")
    public ResultVo NonPartyCadres() {
        ResultVo resultVo = new ResultVo();
        List<Map<String, Integer>> list;
        try {
            list = service.queryNonPartyCadres();
            Integer count = 0;
            Map<String, Integer> map = new HashMap<>();
            for (Map ma1 : list) {
                count += Integer.parseInt(String.valueOf(ma1.get("count")));
            }
            map.put("total", count);
            list.add(map);
            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //5-2、党外干部(带参)
    @ApiOperation(value = "5-2、党外干部(点击学院分)")
    @PostMapping("/NonPartyCadres/{department}")
    public ResultVo NonPartyCadres(@PathVariable("department") String department) {
        ResultVo resultVo = new ResultVo();
        List<Map<String, Integer>> list = new ArrayList<>();
        try {
            list = service.queryNonPartyCadresByDepartment(department);
            Integer count = 0;
            Map<String, Integer> map = new HashMap<>();
            for (Map ma1 : list) {
                count += Integer.parseInt(String.valueOf(ma1.get("count")));
            }
            map.put("total", count);
            list.add(map);
            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //6-1、民主党派(不带参)
    @ApiOperation(value = "6-1、民主党派(主页)")
    @PostMapping("/MemberShip")
    public ResultVo MemberShip() {
        ResultVo resultVo = new ResultVo();
        Map<String, Object> map = new HashMap<>();
        List<String> parties = new ArrayList<>();
        List<String> memberShip = new ArrayList<>();
        List<Integer> memberShip1 = new ArrayList<>();
        try {
            parties = minzudangpaiservice.queryParties();
            memberShip1 = minzudangpaiservice.queryMemberShip();
            for (Integer integer : memberShip1) {
                memberShip.add(String.valueOf(integer));
            }
            Integer minZhuCount = minzudangpaiservice.queryCount();
            map.put("parties", parties);
            map.put("memberShip", memberShip);
            map.put("count", minZhuCount);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //6-2、民主党派(带参)
    @ApiOperation(value = "6-2、民主党派(点击学院分)")
    @PostMapping("/MemberShip/{department}")
    public ResultVo MemberShip(@PathVariable("department") String department) {
        ResultVo resultVo = new ResultVo();
        Map<String, Object> map = new HashMap<>();
        List<String> parties = new ArrayList<>();
        List<String> memberShip = new ArrayList<>();
        List<Integer> memberShip1 = new ArrayList<>();
        try {
            parties = minzudangpaiservice.queryParties();
            memberShip1 = minzudangpaiservice.queryMemberShipByDepartment(department);
            for (Integer integer : memberShip1) {
                memberShip.add(String.valueOf(integer));
            }
            Integer minZhuCount = minzudangpaiservice.queryCountByDepartment(department);
            map.put("parties", parties);
            map.put("memberShip", memberShip);
            map.put("count", minZhuCount);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //7-1、无党派，知联会，留学归国人员(不带参)
    @ApiOperation(value = "7-1、无党派，知联会，留学归国人员(不带参)")
    @PostMapping("/wuDangPai")
    public ResultVo WuDangPai() {
        ResultVo resultVo = new ResultVo();
        List<Map<String, Integer>> list;
        try {
            Integer wuDangPaiCount = 0;
            Map<String, Integer> map = new HashMap<>();
            list = service.queryWuDangPai();
            Map<String, Integer> zhiLianHui = list.get(1);//知联会
            Map<String, Integer> wuDangPai = list.get(0);//无党派人士
            wuDangPai.put("count",Integer.valueOf(String.valueOf(wuDangPai.get("count")))+Integer.valueOf(String.valueOf(zhiLianHui.get("count"))));
            list.set(0,wuDangPai);
            for (Map map1 : list) {
                wuDangPaiCount +=Integer.parseInt(String.valueOf(map1.get("count"))) ;
            }
            map.put("total", wuDangPaiCount);
            list.add(map);
            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //7-2、无党派，知联会，留学归国人员(带参)
    @ApiOperation(value = "7-2、无党派，知联会，留学归国人员(带参)")
    @PostMapping("/wuDangPai/{department}")
    public ResultVo WuDangPai(@PathVariable("department") String department) {
        ResultVo resultVo = new ResultVo();
        List<Map<String, Integer>> list;
        try {
            Integer wuDangPaiCount = 0;
            Map<String, Integer> map = new HashMap<>();
            list = service.queryWuDangPaiByDepartment(department);
            Map<String, Integer> zhiLianHui = list.get(1);//知联会
            Map<String, Integer> wuDangPai = list.get(0);//无党派人士
            wuDangPai.put("count",Integer.valueOf(String.valueOf(wuDangPai.get("count")))+Integer.valueOf(String.valueOf(zhiLianHui.get("count"))));
            list.set(0,wuDangPai);
            for (Map map1 : list) {
                Integer count=
                wuDangPaiCount += Integer.parseInt(String.valueOf(map1.get("count")));
            }
            map.put("total", wuDangPaiCount);
            list.add(map);
            resultVo.setT(list);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //8-1、两代表一委员(不带参)
    @ApiOperation(value = "8-1、两代表一委员(主页)")
    @PostMapping("/liangDaiBiao")
    public ResultVo LiangDaiBiao() {
        ResultVo resultVo = new ResultVo();
        Map<String, List<String>> map;
        List<String> quanGuoRenDaList;
        List<String> shiRenDaList;
        List<String> shiJiZhengXie;
        List<String> shenJiZhengXie;
        List<String> countList;
        try {
            map = new HashMap<>();
            countList = service.queryCountListOfLiangDaiBiao();
            quanGuoRenDaList = service.queryQuanGuoRenDa();   //全国人大代表
            shiRenDaList=service.queryShiRenDa();             //市人大代表
            shenJiZhengXie = service.queryShenJiZhengXie();   //省政协委员
            shiJiZhengXie = service.queryShiJiZhengXie();     //市政协委员

            countList.add(String.valueOf(quanGuoRenDaList.size()));
            countList.add(String.valueOf(shiRenDaList.size()));
            countList.add(String.valueOf(shenJiZhengXie.size()));
            countList.add(String.valueOf(shiJiZhengXie.size()));

            map.put("全国人大代表", quanGuoRenDaList);
            map.put("市人大代表",shiRenDaList);
            map.put("省政协委员", shenJiZhengXie);
            map.put("市政协委员", shiJiZhengXie);
            map.put("count", countList);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //8-2、两代表一委员(带参)
    @ApiOperation(value = "8-2、两代表一委员(带参)")
    @PostMapping("/liangDaiBiao/{department}")
    public ResultVo LiangDaiBiao(@PathVariable("department") String department) {
        ResultVo resultVo = new ResultVo();
        Map<String, List<String>> map;
        List<String> quanGuoRenDaList;
        List<String> shiRenDaList;
        List<String> shiJiZhengXie;
        List<String> shenJiZhengXie;
        List<String> countList;
        try {
            map = new HashMap<>();
            countList = service.queryCountListOfLiangDaiBiaoByDepartment(department);
            quanGuoRenDaList = service.queryQuanGuoRenDaByDepartment(department);   //全国人大代表
            shiRenDaList=service.queryShiRenDaByDepartment(department);             //市人大代表
            shiJiZhengXie = service.queryShiJiZhengXieByDepartment(department);     //省政协委员
            shenJiZhengXie = service.queryShenJiZhengXieByDepartment(department);   //市政协委员

            countList.add(String.valueOf(quanGuoRenDaList.size()));
            countList.add(String.valueOf(shiRenDaList.size()));
            countList.add(String.valueOf(shenJiZhengXie.size()));
            countList.add(String.valueOf(shiJiZhengXie.size()));

            map.put("全国人大代表", quanGuoRenDaList);
            map.put("市人大代表",shiRenDaList);
            map.put("市政协委员", shiJiZhengXie);
            map.put("省政协委员", shenJiZhengXie);
            map.put("count", countList);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }

    //9 全校统战人数
    @ApiOperation(value = "9 全校统战人数")
    @PostMapping("/totalCount")
    public ResultVo totalCount() {
        ResultVo resultVo = new ResultVo();
        List<Map<String,Integer>> list=new ArrayList<>();
        Integer count=0;
        try {
            list = service.totalCount();
            for (Map map:list){
                count+=Integer.parseInt(String.valueOf(map.get("count")));;
            }
            resultVo.setT(count);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }


    //10-1 参政议政情况
    @ApiOperation(value = "10-1 参政议政情况")
    @PostMapping("/politics")
    public ResultVo politics() {
        ResultVo resultVo = new ResultVo();
        Map<String, List<Integer>> map;
        List<Integer> countList;
        List<Integer> yearList;
        List<Integer> countOfAllYears = new ArrayList<>();
        Integer integer = 0;
        try {
            map = new HashMap<>();
            countList = service.politics();
            yearList = minzudangpaiservice.queryYearOfPolitics();
            for (Integer integer1 : countList) {
                integer += integer1;
            }
            countOfAllYears.add(integer);
            map.put("countList", countList);
            map.put("yearList", yearList);
            map.put("count", countOfAllYears);
            resultVo.setT(map);
            resultVo.setMess("查询成功");
            resultVo.setOk(true);
        } catch (Exception e) {
            resultVo.setMess("查询失败");
            resultVo.setOk(true);
            e.printStackTrace();
        }
        return resultVo;
    }


}
