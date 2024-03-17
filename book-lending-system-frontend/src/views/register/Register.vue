<template>
  <div class="register-container">
    <div class="register-form">
      <!-- title -->
      <div class="register-title">註冊</div>
      <!-- 提示 -->
      <div class="register-hint">
        <p>註冊後將生成專屬使用者ID</p>
      </div>
      <!-- form -->
      <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-form-item>
          <el-input v-model="form.username" placeholder="請輸入使用者名稱" prefix-icon="el-icon-user" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="form.password" type="password" placeholder="請輸入密碼" show-password prefix-icon="el-icon-lock"
            clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="form.phone" placeholder="請輸入手機號碼" prefix-icon="el-icon-phone" clearable></el-input>
        </el-form-item>
      </el-form>
      <!-- button -->
      <div class="register-button">
        <el-button type="primary" @click="save">下一步</el-button>
      </div>

    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Register",
  data() {
    const checkPhone = (rule, value, callback) => {
      if (!value) {
        callback(new Error("請輸入手機號碼"));
      }
      if (!/^[1,2,3,4,5,6,7,8,9][0-9]{9}$/.test(value)) {
        callback(new Error("非法的手機號碼"));
      }
      callback();
    };

    return {
      form: {},
      rules: {
        username: [
          { required: true, message: "請輸入使用者名稱", trigger: "blur" },
        ],
        password: [{ required: true, message: "請輸入密碼", trigger: "blur" }],
        phone: [{ required: true, validator: checkPhone, trigger: "blur" }],
      },
    };
  },

  methods: {
    save() {
      this.$refs["ruleForm"].validate((valid) => {
        if (valid) {
          request.post("user/save", this.form).then((res) => {
            if (res.code === "200") {
              this.$notify.success("送出成功");
              this.$refs["ruleForm"].resetFields();
            } else {
              this.$notify.error(res.msg);
            }
          });
        }
      });
    },
  },
};
</script>

<style scoped>
.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.register-form {
  width: 500px;
  height: 400px;
  background-color: white;
  border-radius: 10px;
  padding: 50px;
  margin: 150px auto;
}

.register-title {
  margin-bottom: 30px;
  text-align: center;
  font-size: 40px;
  font-weight: bold;
  font-family: Arial;
  color: mediumblue;
}

.register-button {
  width: 100%;
  margin-top: 20px;
  text-align: center;
}

.register-hint {
  margin-top: 10px;
  text-align: center;
  font-size: 14px;
  color: darkgray;
}
</style>