<template>
  <div>
    <!-- header -->
    <div style="height: 80px; line-height: 80px; background-color: white; width: 100%; margin-bottom: 2px; display: flex">
      <!-- logo and title -->
      <div style="width: 800px">
        <img src="@/assets/logo.png" alt="" style="width: 50px; height: 50px; position: relative; top: 15px; left: 10px">
        <span style="margin-left: 20px; font-size: 40px; font-family: Arial">圖書借閱系統</span>
      </div>
      <!-- admins' info -->
      <div style="flex: 1; text-align: right; margin-right: 40px">
        <el-dropdown style="cursor: pointer">
          <span class="el-dropdown-link">
            Welcome {{ admin.username }}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <!-- dropdown -->
          <el-dropdown-menu slot="dropdown" style="margin-top: -15px; width: 150px; text-align: left">
            <el-dropdown-item><div @click="logout">登出</div></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
    <!-- side and main -->
    <div style="display: flex">
      <!-- side -->
      <div style="min-width: 230px; min-height: calc(100vh - 82px); height: 200px; overflow: hidden; margin-right: 2px; background-color: white;">
        <el-menu :unique-opened="true" :default-active="$route.path" :default-opens="['book']" router>
          <!-- book -->
          <el-menu-item index="/home">
            <i class="el-icon-collection"></i>
            <span style="font-family: Arial; font-size: 15px;">書籍列表</span>
          </el-menu-item>
          <el-menu-item index="/borrowList">
            <i class="el-icon-tickets"></i>
            <span style="font-family: Arial; font-size: 15px;">已借閱書籍</span>
          </el-menu-item>
        </el-menu>
      </div>
      <!-- main -->
      <div style="flex: 1; background-color: white;">
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
import Cookies from "js-cookie";
import request from "@/utils/request";

export default {
  name: "Layout",
  data() {
    return {
      admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')): {}
    }
  },

  methods: {
    logout() {
      Cookies.remove('admin');
      this.$router.push('/login');
    }
  }
}
</script>

<style scoped>

</style>
