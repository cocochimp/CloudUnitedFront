<template>
  <div class="LoginContainer">
    <div class="headBox">
      <p>广东海洋大学云端统战部</p>
    </div>
    <div class="mainContainer">
      <div class="photoBox">
           <img src="../../assets/img/logo.png" alt="" />
        <img src="../../assets/img/LoginImg/云统战.png" class="img2" alt="" />
      </div>
      <div class="LoginBox">
        <div class="logoBox">
          <img src="../../assets/img/LoginImg/学校logo.png" alt="" />
        </div>
        <div class="formBox">
          <el-form
            :label-position="labelPosition"
            label-width="80px"
            class="input"
            ref="loginForm" :model="loginForm" :rules="loginRules"  auto-complete="on"
          >
           <!-- :model="formLabelAlign" -->
            <!-- <el-form-item label="权限" class="setFormColor">
              <el-select v-model="formLabelAlign.level" placeholder="请选择">
                <el-option label="一级权限" value="yiji"></el-option>
                <el-option label="二级权限" value="erji"></el-option>
              </el-select>
            </el-form-item> -->
            <el-form-item label="账号" class="setFormColor" prop="username">
              <el-input type="text"  v-model="loginForm.username" name="username"  auto-complete="on" placeholder="username"></el-input>
            </el-form-item>
            <el-form-item label="密码" class="setFormColor"  prop="password">
              <el-input
                 :type="pwdType"
          v-model="loginForm.password"
          name="password"
          auto-complete="on"
          placeholder="password"
          @keyup.enter.native="handleLogin"
              ></el-input>
              <span class="show-pwd" @click="showPwd">
          <svg-icon icon-class="eye" />
        </span>
            </el-form-item>
            <el-form-item class="submitBox">
              <el-button type="warning" class="submitBtn"  :loading="loading"   @click="handleLogin">
                提交
              </el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { isvalidUsername } from '@/utils/validate'

export default {
  name: 'LoginPage',
  data() {
     const validateUsername = (rule, value, callback) => {
      if (!isvalidUsername(value)) {
        callback(new Error('请输入正确的用户名'))
      } else {
        callback()
      }
    }
    const validatePass = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error('密码不能小于6位'))
      } else {
        callback()
      }
    }
    return {
        loginForm: {
        username: '',
        password: ''
      },
      loginRules: {
        username: [{ required: true, trigger: 'blur', validator: validateUsername }],
        password: [{ required: true, trigger: 'blur', validator: validatePass }]
      },
      loading: false,
      pwdType: 'password',
      redirect: undefined,
      labelPosition: "left",
      // formLabelAlign: {
      //   ID: "",
      //   password: "",
      //   level: "",
      // },
    };
  },
  methods: {
    submit() {
      // axios
      //   .post("http://localhost:3000/search", {
      //     level: this.formLabelAlign.level,
      //     ID: this.formLabelAlign.ID,
      //     password: this.formLabelAlign.password,
      //   })
      //   .then((res) => {
      //     console.log(res);
      //   });
      location.href = "#/appMainIndex";
    },
     showPwd() {
      if (this.pwdType === 'password') {
        this.pwdType = ''
      } else {
        this.pwdType = 'password'
      }
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          // debugger
          this.loading = true
          this.$store.dispatch('Login', this.loginForm).then(() => {
            this.loading = false
          this.$router.push('/appMainIndex')
          }).catch(() => {
            this.loading = false
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    }
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    },
   
  },
  beforeCreate() {
    document
      .querySelector("body")
      .setAttribute("style", "background-color:#872624");
  },
  beforeDestroy() {
    document.querySelector("body").setAttribute("style", "background-color:''");
  },
};
</script>



<style scoped>
.LoginContainer {
  position: absolute;
  width: 100%;
  height: 100%;
  min-width: 1220px;
  background: url("../../assets/img/IndexImg/13.gif");
  background-size: 100% 100%;
}

.headBox {
  /* background-image: url("../../assets/img/IndexImg/4.png");
  background-size: 100% 80px;
  background-repeat: no-repeat; */
  min-width: 1220px;
  max-width: 100%;
  height: 80px;
  font-size: 18pt;
  text-align: center;
  color: #f7d7b6;
  font-weight: bold;
  line-height: 55px;
}

.mainContainer {
  width: 1220px;
  height: 400px;
  margin: auto;
  margin-top: 150px;
}

.photoBox {
  float: left;
  width: 600px;
  height: 400px;
}

.photoBox img {
  width: 600px;
  height: 400px;
}

.LoginBox {
  position: relative;
  float: right;
  width: 600px;
  height: 400px;
  /* background-image: url("../../assets/img/LoginImg/框2.png");
  background-repeat: no-repeat;
  background-size: 100% 400px; */
}

.logoBox {
  position: absolute;
  left: calc(50% - 60px);
  top: -40px;
}

.formBox {
  padding: 20px;
  margin-top: 80px;
}

::v-deep .setFormColor .el-form-item__label {
  color: #f7d7b6;
  font-size: 18px;
}

::v-deep .submitBox .el-form-item__content {
  margin-left: 0 !important;
}

.submitBtn {
  font-size: 18px;
  display: block;
  margin: auto;
}
/* 杨政恒 */
.photoBox{
  display: flex;
  align-items: center;
}
.photoBox img{
  width: 250px;
  height: 250px;
}
.photoBox img.img2{
   width: 330px;
   height: 230px;
   
}
.input{
  padding-top: 40px;
}
</style>