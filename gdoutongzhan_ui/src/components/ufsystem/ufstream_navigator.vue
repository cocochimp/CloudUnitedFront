<template>
  <div class="facNav-container">
    <div class="navigator">
      <div class="title1"><span>民主党派</span></div>
      <div class="nav">
        <ul class="nav_ul">
          <li v-for="(item, index) in items" :key="index" class="item">
            <router-link
              :to="{
                path: '/ufsystem/content',
                query: {
                  content: item.content,
                  name: item.name,
                  regimen: item.regimen,
                  brief: item.brief,
                },
              }"
            >
              <p @click="showToggle(item, index)">{{ item.name }}</p>
              <ul class="sec_ul" :ref="index">
                <li class="sec_li item" @click="sendTip(index)">
                  领导班子与简介
                </li>
                <li class="sec_li item" @click="showNews(index)">党派新闻</li>
              </ul>
            </router-link>
            <!--            <ul v-show="item.isSubShow" class="nav_ul_ul">-->
            <!--              <li v-for="subItem in item.subItems" :key="subItem.id" class="subItem">-->
            <!--                <router-link-->
            <!--                  :to="{-->
            <!--                    path: '/ufsystem/content',-->
            <!--                    query: {-->
            <!--                      people: subItem.people,-->
            <!--                      duty: subItem.duty,-->
            <!--                      regimen: subItem.regimen,-->
            <!--                      brief: subItem.brief,-->
            <!--                    },-->
            <!--                  }"-->
            <!--                >-->
            <!--                  <p class="subTitle">{{ subItem.name }}</p>-->
            <!--                </router-link>-->
            <!--              </li>-->
            <!--            </ul>-->
          </li>
        </ul>
      </div>
    </div>

    <!-- <router-view class="view"></router-view> -->
  </div>
</template>

<script>
import router from "../../router/index";
export default {
  name: "navigator",
  data() {
    return {
      items: [
        {
          name: "中国国民党革命委员会",
          isSubShow: false,
          content: [
            {
              title: "中国国民党革命委员会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国国民党革命委员会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国国民党革命委员会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
          regimen:
            "民革上海交通大学委员会的前身是民革上海交通大学支部，是民革上海市委的直属支部。支部建立前有2名党员：郑家俊和凌霜。1986年4月9日建立民革上海交大支部，至2012年9月已换届7次。\n       第一届（1986年）支委会由凌霜任主委。委员：毛增滇。当时支部成员5人，即凌霜、何绍诗、毛增滇、顾婉华与郑怡红；\n       第二届（1990年-1993年）支部委员3人，主任委员：毛增滇，委员：马波、何晋璋，当时支部成员13人；\n       第三届（1993年-1996年）支部委员3人，主任委员：毛增滇，委员：何晋璋、梁美训，当时支部成员16人；\n       第四届（1996年-2000年）支部委员3人，主任委员：毛人杰，委员：梁美训、罗次申，当时支部成员19人；\n       第五届（2000年-2003年）支部委员4人，主任委员：毛人杰，副主任委员：梁美训，委员罗次申、沈璋华，当时支部成员22人；\n       第六届（2003年2月-2012年9月）支部委员4人，主任委员罗次申，副主任委员沈璋华，委员黄飚、林涛，当时支部成员28人；",
          brief:
            "中国国民党革命委员会（简称“民革”）是具有政治联盟性质的、致力于建设中国特色社会主义和祖国统一事业的政党，是中国共产党领导的多党合作和政治协商制度中的中国特色社会主义参政党，由原中国国民党民主派和其他爱国人士所创建，于1948年1月1日在香港成立。",
        },
        {
          name: "中国民主同盟",
          isSubShow: false,
          content: [
            {
              title: "中国民主同盟XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主同盟XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主同盟XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
          regimen:
            "1950年中国民主同盟交通大学成立，有2名成员。1952年中国民主同盟上海市委直属交通大学小组成立，负责人为沈德滋、张滋伟、桑国光，有19名成员。1956年中国民主同盟交通大学支部委员会成立，主委为王绍先，有48名成员。1957年交通大学部分西迁，民盟也跟随部分西迁，负责人为蓝章夏、程宣。\n       1979年，第一届中国民主同盟上海交通大学支部委员会成立，负责人为薛绍清、王祖佑、蒋公惠，有31名成员。\n       1980年5月，第二届民盟上海交通大学支部委员会主委戴宗信，副主委王祖佑、蒋公惠、王端骧，盟员50人。\n       1985年9月，第三届民盟上海交通大学支部委员会主委戴宗信，副主委王祖佑、尉迟斌，盟员70人。\n       1987年10月，成立第一届民盟上海交通大学总支委员会，主委戴宗信，副主委尉迟斌、桑国光，盟员99人。\n       1991年4月，成立第一届民盟上海交通大学委员会，主委戴宗信，副主委尉迟斌、顾世洧、陈伯真，盟员106人。\n       1993年12月，成立第二届民盟上海交通大学委员会，主委张圣坤，副主委顾世洧、夏承芳、廖培福，盟员115人。\n       1997年6月，张圣坤当选民盟上海市委主委，10月辞去民盟交大委员会主委，韩正之担任民盟交大委员会主委。\n       2000年9月，选举产生第四届民盟上海交大委员会主委韩正之，副主委吴冲锋、顾稚浓、黄旭东，盟员198人。\n       2006年11月，选举产生第五届民盟上海交大委员会，主委吴冲锋，副主委连琏、姚雷、朱本华，盟员242人。\n       2011年9月，选举产生第六届民盟上海交大委员会，主委吴冲锋，副主委连琏、姚雷、刘洪、孔向阳，盟员239人。\n       2016年9月，选举产生第七届民盟上海交通大学委员会，主委姚雷，副主委刘洪、周军、李卫东，盟员327。\n       2021年8月，选举产生第八届民盟上海交通大学委员会，主委齐飞，副主委李卫东、周军、丁显廷、刘杰，盟员343（截止到2021年8月数据）",
          brief:
            "中国民主同盟（简称“民盟”）是主要由从事文化教育以及科学技术工作的高、中级知识分子组成的，具有政治联盟特点的，接受中国共产党领导、同中国共产党通力合作，进步性与广泛性相统一、致力于中国特色社会主义事业的参政党，于1941年3月19日在重庆秘密成立。",
        },
        {
          name: "中国民主建国会",
          isSubShow: false,
          content: [
            {
              title: "中国民主建国会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主建国会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主建国会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
          regimen:
            "1982年杨锡山同志调入上海交通大学管理学院，从此上海交大有了民主建国会成员。1984年5月成立了中国民主建国会上海交通大学支部（筹），由杨锡山任召集人。\n       1987年3月18日成立上海交通大学第一届支部委员会。主任潘介人，副主任殷善锷，组织委员朱洪德。1987年12月31日增补丁仁才为副主任。\n       1991年9月换届选举，产生了第二届支部委员会。主任殷善锷，副主任丁仁才、李国振，组织委员朱洪德。\n       1995年1月26日成立了第三届支部委员会。主任李国振，副主任殷善锷、朱洪德，委员屠梅曾、袁伟民。\n       2004年10月，民建上海交通大学第一届委员会成立，陈宏民任主任委员，屠梅曾、赵旭任副主任委员。交大成为上海市第三家成立民建委员会的高校，也是上海交通大学第三个成立委员会的民主党派。\n       2006年12月，选举民建上海交大第二届委员会，主任委员陈宏民，副主任委员赵旭、朱向阳。\n       2011年9月，选举产生民建上海交大第三届委员会，主任委员赵旭，副主任委员顾孟迪、苏剑波、缪永红。\n       2015年10月，选举产生民建上海交大第四届委员会，主任委员赵旭，副主任委员苏剑波、顾孟迪，委员卫淑芝、王亦鸣、朱向阳、陈欣、刘群彦。\n       2021年7月，选举产生民建上海交大第五届委员会，主任委员陈方若，副主任委员陆铭、施圣贤，委员皮玲、张哲敏、陈鑫、刘群彦、戴芳、朱向阳。",
          brief:
            "中国民主建国会（简称“民建”）是主要由经济界人士组成的、具有政治联盟特点的政党，是接受中国共产党领导，与中国共产党通力合作的中国特色社会主义参政党，于1945年12月由爱国的民族工商业者和有联系的知识分子发起，在重庆成立。",
        },
        {
          name: "中国民主促进会",
          isSubShow: false,
          content: [
            {
              title: "中国民主促进会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主促进会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国民主促进会XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
          regimen:
            "1958年8月钱家生、胡海秋调至上海交通大学任教，王亨时、支厚康则在上海交大预科，是交大最早的民进会员，组织关系隶属于当时的民进上海市北郊区联合支部。“文化大革命”期间，民进停止组织活动。\n       1979年起上海交大民进小组恢复活动及发展工作。1982年3月上海交大民进小组的会员已有7人，经民进上海市委批准成立上海交通大学直属支部。主任委员为钱家声，支部委员为王亨时，有7名成员。",
          brief:
            "中国民主促进会（简称“民进”）是以从事教育文化出版工作的高中级知识分子为主、具有政治联盟性质的政党，是同中国共产党通力合作的中国特色社会主义参政党，于1945年12月30日在上海正式成立。",
        },
        {
          name: "中国农工民主党",
          isSubShow: false,
          content: [
            {
              title: "中国农工民主党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国农工民主党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国农工民主党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
          regimen:
            " 中国农工民主党上海交大支部是农工党上海市委的直属支部。最早成员是1953年2月加入农工民主党的李泰云。1957年三校合并时，张祖錩将组织关系由南洋工学院转到交大。1984年发展到7位党员，成立了党小组。",
          brief:
            "中国农工民主党（简称“农工党”）是以医药卫生、人口资源和生态环境领域高中级知识分子为主，由一部分社会主义劳动者、社会主义事业建设者和拥护社会主义的爱国者组成的，具有政治联盟特点的中国特色社会主义参政党，于1930年8月9日在上海成立。",
        },
        {
          name: "中国致公党",
          isSubShow: false,
          content: [
            {
              title: "中国致公党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国致公党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "中国致公党XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
          regimen:
            "1981年1月上海交大有中国致公党成员1人，至1995年发展成员共7人，未成立支部，直接参加致公党市委的学习和活动。\n       1995年7月3日成立了中国致公党上海交大筹备组，组长为张宝康。",
          brief:
            "中国致公党（简称“致公党”）是以归侨、侨眷中的中上层人士和其他有海外关系的代表性人士为主组成的、具有政治联盟特点的政党，是中国共产党领导的多党合作和政治协商制度中的中国特色社会主义参政党，由华侨社团美洲致公堂发起，1925年10月在美国旧金山成立。",
        },
        {
          name: "九三学社",
          isSubShow: false,
          content: [
            {
              title: "九三学社XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "九三学社XXXXXXXXXXXX",
              time: "2022-4-23",
            },
            {
              title: "九三学社XXXXXXXXXXXX",
              time: "2022-4-23",
            },
          ],
          regimen:
            "1953年九三学社在交大成立了支社筹备委员会，由副教务长朱物华负责筹备工作。   \n       1955年4月30日选举产生了九三交大支社第一届委员会，社员19名。   \n       由于迁校任务，1956到1958年陆续有30多名社员去西安交大工作，到1958年底社员有49名。   \n       1958年，第二届支社委员会成立，主委为杨槱，副主委为程福秀、林宏铨。委员人数是8人。   ",
          brief:
            "九三学社是以科学技术界高、中级知识分子为主的具有政治联盟特点的政党，是接受中国共产党领导、同中国共产党通力合作的中国特色社会主义参政党。抗日战争后期，一批文化教育、自然科学学者在重庆发起民主科学座谈会，1945年9月3日，民主科学座谈会更名为九三座谈会，1946年5月4日，九三座谈会改建为九三学社。",
        },
      ],
      list: [],
      typeList: ["民革", "民盟", "民建", "民进", "农工", "致公", "九三"],
      leaderShip: [],
    };
  },
  created() {
    this.$axios
      .get(
        "http://localhost:9102/servicearticle/article/article/queryArticleByPosition?position=民主党派"
      )
      .then((res) => {
        this.list = res.data.t;
      });

    this.$axios
      .get("http://localhost:9101/servicedangpai/dangpai/dangpai/queryPosition")
      .then((res) => {
        // console.log(res.data.t);
        for (let i = 0; i < res.data.t.length; i++) {
          if (res.data.t[i].partyName === "minge") {
            this.leaderShip[0] = res.data.t[i];
          } else if (res.data.t[i].partyName === "minmeng") {
            this.leaderShip[1] = res.data.t[i];
          } else if (res.data.t[i].partyName === "minjian") {
            this.leaderShip[2] = res.data.t[i];
          } else if (res.data.t[i].partyName === "minjin") {
            this.leaderShip[3] = res.data.t[i];
          } else if (res.data.t[i].partyName === "nonggong") {
            this.leaderShip[4] = res.data.t[i];
          } else if (res.data.t[i].partyName === "zhigong") {
            this.leaderShip[5] = res.data.t[i];
          } else if (res.data.t[i].partyName === "jiusan") {
            this.leaderShip[6] = res.data.t[i];
          }
        }
        this.$emit("shareList", "");
        this.$emit("shareLeader", this.leaderShip[0]);
      });
  },
  mounted() {
    this.$router.replace(
      "?content=%5Bobject%20Object%5D&content=%5Bobject%20Object%5D&content=%5Bobject%20Object%5D&name=中国国民党革命委员会&regimen=民革上海交通大学委员会的前身是民革上海交通大学支部，是民革上海市委的直属支部。支部建立前有2名党员：郑家俊和凌霜。1986年4月9日建立民革上海交大支部，至2012年9月已换届7次。%0A%20%20%20%20%20%20%20第一届（1986年）支委会由凌霜任主委。委员：毛增滇。当时支部成员5人，即凌霜、何绍诗、毛增滇、顾婉华与郑怡红；%0A%20%20%20%20%20%20%20第二届（1990年-1993年）支部委员3人，主任委员：毛增滇，委员：马波、何晋璋，当时支部成员13人；%0A%20%20%20%20%20%20%20第三届（1993年-1996年）支部委员3人，主任委员：毛增滇，委员：何晋璋、梁美训，当时支部成员16人；%0A%20%20%20%20%20%20%20第四届（1996年-2000年）支部委员3人，主任委员：毛人杰，委员：梁美训、罗次申，当时支部成员19人；%0A%20%20%20%20%20%20%20第五届（2000年-2003年）支部委员4人，主任委员：毛人杰，副主任委员：梁美训，委员罗次申、沈璋华，当时支部成员22人；%0A%20%20%20%20%20%20%20第六届（2003年2月-2012年9月）支部委员4人，主任委员罗次申，副主任委员沈璋华，委员黄飚、林涛，当时支部成员28人；&brief=中国国民党革命委员会（简称“民革”）是具有政治联盟性质的、致力于建设中国特色社会主义和祖国统一事业的政党，是中国共产党领导的多党合作和政治协商制度中的中国特色社会主义参政党，由原中国国民党民主派和其他爱国人士所创建，于1948年1月1日在香港成立。"
    );
    this.$refs[0][0].style.display = "block";

    // this.$axios
    //   .get(
    //     "http://localhost:9102/servicearticle/article/article/queryArticleByType?type=" +
    //       this.typeList[0]
    //   )
    //   .then((res) => {
    //     this.$emit("shareList", res.data.t);
    //   });
  },
  destroyed() {},
  methods: {
    showToggle: function (item, index) {
      for (const i in this.$refs) {
        this.$refs[i][0].style.display = "none";
      }
      this.$refs[index][0].style.display = "block";
      item.isSubShow = !item.isSubShow;

      this.sendTip(index);
    },
    showNews(index) {
      this.$axios
        .get(
          "http://localhost:9102/servicearticle/article/article/queryArticleByType?type=" +
            this.typeList[index]
        )
        .then((res) => {
          this.list = res.data.t;
          this.$emit("shareList", res.data.t);
        });
    },
    sendTip(index) {
      this.$emit("shareList", "");
      this.$emit("shareLeader", this.leaderShip[index]);
    },
    visual(a, b) {
      if (b == 2) {
        // 传递参数
        let routerJump = this.$router.resolve({ path: "/visual" });
        window.open(routerJump.href, "_black");
      }
    },
  },
};
</script>

<style scoped>
.facNav-container {
  display: flex;
}
.navigator {
  display: inline-block;
}

.title1 {
  border: #99a9bf solid 2px;
  width: 14rem;
  color: white;
  background: #861600;
}
.title1 > span {
  padding-left: 2.5rem;
  font-size: 20px;
  height: 50px;
  line-height: 50px;
}
p:hover {
  color: #861600;
  background-color: #eeeeee;
}
.nav {
  width: 14rem;
  border: 2px solid #ddd;
  /* overflow: scroll; */
  overflow-x: hidden;
}
.subTitle {
  font-size: 15px;
}
ul {
  height: auto;
}
.item {
  border-bottom: #ddd solid 1px;
}
.subItem {
  border-top: #ddd solid 1px;
}
.nav .nav_ul p {
  border: 1px solid #fff;
  padding: 0.7rem 0;
  padding-left: 0.6rem;
  text-indent: 30px;
}

.nav .nav_ul .nav_ul_ul p {
  text-indent: 50px;
}
.subItem:hover {
  background: #eeeeee;
}
.sec_ul {
  display: none;
  border-top: #ddd solid 1px;
}
.sec_li {
  height: 30px;
  background: #eeeeee;
  display: flex;
  justify-content: center;
  align-items: center;
}

.sec_li:hover {
  color: #861600;
  background-color: #eeeeee;
}
</style>
