<template>
  <div class="informationContainer">
    <div class="leftTittle">
      <h6 style="margin: 0 1%">{{ title }}</h6>
    </div>
    <div class="classBox">
      <div class="classBoxSon">
        <h3>海大总支</h3>
      </div>
      <div class="classBoxSon">
        <h3>民革第一支部</h3>
      </div>
      <div class="classBoxSon">
        <h3>民革第二支部</h3>
      </div>
    </div>
    <div class="detailBox">
      <div class="detailBoxSon">
        <div class="textBox">
          <div class="part colorst">
            <div class="position">主委：</div>
            <el-button
              type="text"
              @click="dialogTableVisible = true"
              class="name"
              ><a href="javascript:;">韩维栋</a></el-button
            >
            <el-dialog title="用户信息" :visible.sync="dialogTableVisible">
              <el-descriptions :column="3" border>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-user"></i>
                    姓名
                  </template>
                  韩维栋
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    党派
                  </template>
                  <el-tag size="small">中国国民党革命委员会</el-tag>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-location-outline"></i>
                    所属支部
                  </template>
                  海大总支
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-school"></i>
                    学院
                  </template>
                  农学院
                </el-descriptions-item>
                <el-descriptions-item :span="2">
                  <template slot="label">
                    <i class="icon icon-post"></i>
                    党内职务
                  </template>
                  主委
                </el-descriptions-item>
                <el-descriptions-item :span="3">
                  <template slot="label">
                    <i class="icon icon-prize"></i>
                    奖项
                  </template>
                  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                </el-descriptions-item>
                <el-descriptions-item :span="3">
                  <template slot="label">
                    <i class="el-icon-notebook-2"></i>
                    发表论文
                  </template>
                  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                </el-descriptions-item>
              </el-descriptions>
            </el-dialog>
          </div>
          <div class="part colornd">
            <div class="position">副主委：</div>
            <div class="name">张雪敏</div>
          </div>
          <div class="part">
            <div class="position">委员：</div>
            <div class="nameBox">
              <div class="name">张文华</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
            </div>
          </div>
        </div>
      </div>
      <div class="detailBoxSon">
        <div class="textBox">
          <div class="part colorst">
            <div class="position">主委：</div>
            <div class="name">韩维栋</div>
          </div>
          <div class="part colornd">
            <div class="position">副主委：</div>
            <div class="name">张雪敏</div>
          </div>
          <div class="part">
            <div class="position">委员：</div>
            <div class="nameBox">
              <div class="name">张文华</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
            </div>
          </div>
        </div>
      </div>
      <div class="detailBoxSon">
        <div class="textBox">
          <div class="part colorst">
            <div class="position">主委：</div>
            <div class="name">韩维栋</div>
          </div>
          <div class="part colornd">
            <div class="position">副主委：</div>
            <div class="name">张雪敏</div>
          </div>
          <div class="part">
            <div class="position">委员：</div>
            <div class="nameBox">
              <div class="name">张文华</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
              <div class="name">朱宏波</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      default: "中国国民党革命委员会",
    },
  },

  data() {
    return {
      dialogTableVisible: false,
    };
  },
};
</script>

<style scoped>
.informationContainer {
  width: 100%;
  height: 100%;
}

.leftTittle {
  float: left;
  height: 100%;
  width: 10%;
  writing-mode: tb-rl;
  text-align: center;
  color: #f1cd92;
  font-size: 2.5vw;
}

.classBox {
  float: left;
  height: 100%;
  width: 10%;
  font-size: 1.2vw;
}

.classBoxSon {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 33.3%;
  writing-mode: tb-rl;
  text-align: center;
  color: #f1cd92;
}

.detailBox {
  float: left;
  height: 100%;
  width: 80%;
}

.detailBoxSon {
  display: flex;
  align-items: center;
  width: 100%;
  height: 33.3%;
  color: #fff;
  padding: 0 2%;
}

.part {
  font-size: 1vw;
}

.position {
  float: left;
  width: 20%;
}
.name {
  display: inline-block;
  width: 80%;
  word-wrap: break-word;
  word-break: break-all;
}

.nameBox {
  float: left;
  width: 80%;
  height: 20%;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 6;
  -webkit-box-orient: vertical;
}

.nameBox .name {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  height: 1.1vw;
}

.colorst {
  color: #ed646c;
}

.colornd {
  color: #f0c966;
}

a {
  color: #ed646c;
  font-size: 1vw;
}

.el-button {
  border: 0px;
  text-align: left;
  padding: 0px;
}
.icon {
  width: 0.912vw;
  height: 0.886vw;
  display: inline-block;
  vertical-align: middle;
}
.icon-prize {
  background: url(../../assets/img/Icon/奖项.png) no-repeat;
}

.icon-post {
  background: url(../../assets/img/Icon/党内职务.png) no-repeat;
}

a:hover {
  text-decoration: underline;
}

::v-deep .el-dialog {
  min-width: 650px;
}
</style>