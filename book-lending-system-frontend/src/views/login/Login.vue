<template>
  <div class="login-container">
    <div class="login-form">
      <!-- title -->
      <div class="login-title">圖書借閱系統</div>
      <!-- header -->
      <div class="login-hint">登入</div>
      <!-- form -->
      <div style="margin-top: 22px">
        <el-form :model="admin" :rules="rules" ref="loginForm">
          <el-form-item prop="userID">
            <el-input placeholder="使用者ID" prefix-icon="el-icon-user" v-model="admin.userID" clearable></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input placeholder="密碼" show-password prefix-icon="el-icon-lock" v-model="admin.password" clearable></el-input>
          </el-form-item>
        </el-form>
      </div>
      <!-- buttons -->
      <div>
        <el-button style="width: 100%" type="primary" @click="login">登入</el-button>
      </div>
      <div style="margin-top: 10px; text-align: center; font-size: 14px; color: darkgray">
        還沒有帳號嗎? <router-link to="/register">立即註冊</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie";

export default {
  name: "login",
  data() {
    return {
      admin: {},
      rules: {
        userID: [{ required: true, message: '請輸入使用者ID', trigger: 'blur' }],
        password: [{ required: true, message: '請輸入密碼', trigger: 'blur' }]
      }
    };
  },
  methods: {
    login() {
      this.$refs['loginForm'].validate((valid) => {
        if (valid) {
          request.post('admin/login', this.admin).then(res => {
            if(res.code === '200') {
              this.$notify.success("Sign in successful");
              if(res.data !== null) {
                Cookies.set('admin', JSON.stringify(res.data));
              }

              this.$router.push('/');
            } else {
              this.$notify.error(res.msg);
            }
          });
        }
      });
    }
  }
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-form {
  width: 500px;
  height: 400px;
  background-color: white;
  border-radius: 10px;
  padding: 50px;
  margin: 150px auto;
}

.login-title {
  margin-bottom: 30px;
  text-align: center;
  font-size: 40px;
  font-weight: bold;
  font-family: Arial;
  color: mediumblue;
}

.login-button {
  width: 100%;
  margin-top: 20px;
  text-align: center;
}

.login-hint {
  margin-top: 15px;
  text-align: center;
  font-size: 25px;
  font-weight: bold;
  color: darkgray;
}
.el-button {
  width: 100%;
  margin-top: 20px;
}
</style>
