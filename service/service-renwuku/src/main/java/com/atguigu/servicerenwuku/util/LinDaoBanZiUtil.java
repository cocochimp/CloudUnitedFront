package com.atguigu.servicerenwuku.util;

import com.atguigu.servicerenwuku.entity.LinDaoBanZiVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinDaoBanZiUtil {
    public static Map<String,Map<String, List<String>> > build(List<LinDaoBanZiVo> linDaoBanZiVoList){
        Map<String,Map<String, List<String>> >map=new HashMap<>();
        Map minGe=new HashMap();
        Map minMeng=new HashMap();
        Map minJian=new HashMap();
        Map minJin=new HashMap();
        Map nongGong=new HashMap();
        Map zhiGong=new HashMap();
        Map jiuSan=new HashMap();
        List<String> minGeZhuWei=new ArrayList<>();
        List<String> minGeFuZhuWei=new ArrayList<>();
        List<String> minGeWeiYuan=new ArrayList<>();

        List<String> minMengZhuWei=new ArrayList<>();
        List<String> minMengFuZhuWei=new ArrayList<>();
        List<String> minMengWeiYuan=new ArrayList<>();

        List<String> minJianZhuWei=new ArrayList<>();
        List<String> minJianFuZhuWei=new ArrayList<>();
        List<String> minJianWeiYuan=new ArrayList<>();

        List<String> minJinZhuWei=new ArrayList<>();
        List<String> minJinFuZhuWei=new ArrayList<>();
        List<String> minJinWeiYuan=new ArrayList<>();

        List<String> nongGongZhuWei=new ArrayList<>();
        List<String> nongGongfuZhuWei=new ArrayList<>();
        List<String> nongGongWeiYuan=new ArrayList<>();

        List<String> zhiGongZhuWei=new ArrayList<>();
        List<String> zhiGongFuZhuWei=new ArrayList<>();
        List<String> zhiGongWeiYuan=new ArrayList<>();

        List<String> jiuSanZhuWei=new ArrayList<>();
        List<String> jiuSanFuZhuWei=new ArrayList<>();
        List<String> jiuSanWeiYuan=new ArrayList<>();
        for (LinDaoBanZiVo linDaoBanZiVo:linDaoBanZiVoList){
            switch (linDaoBanZiVo.getParty()){
                case "民革":
                    if("主委".equals(linDaoBanZiVo.getCommittee())){
                        minGeZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("副主委".equals(linDaoBanZiVo.getCommittee())){
                        minGeFuZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("委员".equals(linDaoBanZiVo.getCommittee())){
                        minGeWeiYuan.add(linDaoBanZiVo.getName());
                    }
                    break;

                case "民盟":
                    if("主委".equals(linDaoBanZiVo.getCommittee())){
                        minMengZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("副主委".equals(linDaoBanZiVo.getCommittee())){
                        minMengFuZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("委员".equals(linDaoBanZiVo.getCommittee())){
                        minMengWeiYuan.add(linDaoBanZiVo.getName());
                    }
                    break;

                case "民建":
                    if("主委".equals(linDaoBanZiVo.getCommittee())){
                        minJianZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("副主委".equals(linDaoBanZiVo.getCommittee())){
                        minJianFuZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("委员".equals(linDaoBanZiVo.getCommittee())){
                        minJianWeiYuan.add(linDaoBanZiVo.getName());
                    }
                    break;

                case "民进":
                    if("主委".equals(linDaoBanZiVo.getCommittee())){
                        minJinZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("副主委".equals(linDaoBanZiVo.getCommittee())){
                        minJinFuZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("委员".equals(linDaoBanZiVo.getCommittee())){
                        minJinWeiYuan.add(linDaoBanZiVo.getName());
                    }
                    break;

                case "农工":
                    if("主委".equals(linDaoBanZiVo.getCommittee())){
                        nongGongZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("副主委".equals(linDaoBanZiVo.getCommittee())){
                        nongGongfuZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("委员".equals(linDaoBanZiVo.getCommittee())){
                        nongGongWeiYuan.add(linDaoBanZiVo.getName());
                    }
                    break;

                case "致公":
                    if("主委".equals(linDaoBanZiVo.getCommittee())){
                        zhiGongZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("副主委".equals(linDaoBanZiVo.getCommittee())){
                        zhiGongFuZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("委员".equals(linDaoBanZiVo.getCommittee())){
                        zhiGongWeiYuan.add(linDaoBanZiVo.getName());
                    }
                    break;

                case "九三":
                    if("主委".equals(linDaoBanZiVo.getCommittee())){
                        jiuSanZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("副主委".equals(linDaoBanZiVo.getCommittee())){
                        jiuSanFuZhuWei.add(linDaoBanZiVo.getName());
                    }
                    if("委员".equals(linDaoBanZiVo.getCommittee())){
                        jiuSanWeiYuan.add(linDaoBanZiVo.getName());
                    }
                    break;
            }
        }
        minGe.put("zhuWei",minGeZhuWei);
        minGe.put("fuZhuWei",minGeFuZhuWei);
        minGe.put("weiYuan",minGeWeiYuan);

        minMeng.put("zhuWei",minMengZhuWei);
        minMeng.put("fuZhuWei",minMengFuZhuWei);
        minMeng.put("weiYuan",minMengWeiYuan);

        minJian.put("zhuWei",minJianZhuWei);
        minJian.put("fuZhuWei",minJianFuZhuWei);
        minJian.put("weiYuan",minJianWeiYuan);

        minJin.put("zhuWei",minJinZhuWei);
        minJin.put("fuZhuWei",minJinFuZhuWei);
        minJin.put("weiYuan",minJinWeiYuan);

        nongGong.put("zhuWei",nongGongZhuWei);
        nongGong.put("fuZhuWei",nongGongfuZhuWei);
        nongGong.put("weiYuan",nongGongWeiYuan);

        zhiGong.put("zhuWei",zhiGongZhuWei);
        zhiGong.put("fuZhuWei",zhiGongFuZhuWei);
        zhiGong.put("weiYuan",zhiGongWeiYuan);

        jiuSan.put("zhuWei",jiuSanZhuWei);
        jiuSan.put("fuZhuWei",jiuSanFuZhuWei);
        jiuSan.put("weiYuan",jiuSanWeiYuan);

        map.put("minGe",minGe);
        map.put("minMeng",minMeng);
        map.put("minJian",minJian);
        map.put("minJin",minJin);
        map.put("nongGong",nongGong);
        map.put("zhiGong",zhiGong);
        map.put("jiuSan",jiuSan);
        return map;
    }
}
