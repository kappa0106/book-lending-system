<template>
  <div>

    <!-- table area -->
    <el-table :data="tableData" style="width: 100%" stripe>
      <el-table-column prop="name" label="書名" width="150"></el-table-column>
      <el-table-column prop="isbn" label="ISBN" width="120"></el-table-column>
      <el-table-column prop="author" label="作者" width="100"></el-table-column>
      <el-table-column prop="description" label="書籍內容簡介"></el-table-column>
      <el-table-column label="書籍狀態">
        <template slot-scope="scope">
          <span>{{ scope.row.status === 'available' ? '在庫' : '借出' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="120">
        <template slot-scope="scope">
          <el-button v-if="scope.row.status === 'available'" type="success" size="mini" @click="borrow(scope.row)">借閱</el-button>
          <el-button v-else type="text" size="mini" disabled>借閱</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- page -->
    <el-pagination
        style="margin-top: 20px;"
        background
        :current-page="params.pageNum"
        :page-size="params.pageSize"
        @current-change="changePageNum"
        layout="prev, pager, next"
        :total="total">
    </el-pagination>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "BookList",

  data() {
    return {
      tableData: [],
      total: 0,
      params: {
        pageNum: 1,
        pageSize: 10,
      },
    };
  },

  created() {
    this.load();
  },

  methods: {
    load() {
      request.get('books', { params: this.params }).then(res => {
        if (res.code === '200') {
          this.tableData = res.data.list;
          this.total = res.data.total;
        }
      });
    },

    borrow(book) {
      console.log('借閱書籍:', book.name);
    },

    reset() {
      this.params = {
        pageNum: 1,
        pageSize: 10,
      };
      this.load();
    },

    changePageNum(pageNum) {
      this.params.pageNum = pageNum;
      this.load();
    },
  },
};
</script>

<style>
</style>
