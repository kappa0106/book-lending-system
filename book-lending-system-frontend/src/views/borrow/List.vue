<template>
  <div>
    <!-- table area -->
    <el-table :data="tableData" style="width: 100%" stripe>
      <el-table-column prop="name" label="書名" show-overflow-tooltip width="300"></el-table-column>
      <el-table-column prop="isbn" label="ISBN" width="150"></el-table-column>
      <el-table-column prop="borrow_date" label="借閱時間" width="200"></el-table-column>
      <el-table-column prop="return_date" label="歸還時間" width="200"></el-table-column>
      <el-table-column label="Operation">
        <template v-slot="scope">
          <el-button v-if="scope.row.returned" disabled>Returned</el-button>
          <el-button v-else @click="returnBook(scope.row)">Return</el-button>
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
  name: "UserBorrowList",

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
      // Simulating user-specific data loading
      // You should replace this with your actual API request
      this.tableData = [
        { name: "Book 1", isbn: "1234567890", borrow_date: "2024-03-17", returned: false },
        { name: "Book 2", isbn: "0987654321", borrow_date: "2024-03-16", returned: true },
        { name: "Book 3", isbn: "9876543210", borrow_date: "2024-03-15", returned: false }
      ];
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
    
    returnBook(row) {
      // Simulating return book action
      // You should replace this with your actual API request
      row.returned = true;
      // Call API to update return date and book status
      request.post(`/books/${row.isbn}/return`)
        .then(() => {
          this.$message.success('Book returned successfully.');
        })
        .catch(error => {
          this.$message.error(`Failed to return book: ${error.message}`);
        });
    }
  }
};
</script>
