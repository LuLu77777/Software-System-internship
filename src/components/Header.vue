<template>
  <div style="height: 50px; line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
    <div style="width: 200px;padding-left: 30px;font-weight: bold;color: black">
      后台管理
    </div>
    <div style="flex: 1"></div>
    <div style="width: 100px">
      <el-dropdown @command="handleCommand">
      <span class="el-dropdown-link">
        {{user.username}}
        <i class="el-icon-arrow-down el-icon--right"></i>
      </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="b">个人信息</el-dropdown-item>
<!--          <el-button plain @click="$router.push('/login')">退出系统</el-button>-->
          <el-dropdown-item command="a">退出系统</el-dropdown-item>
<!--          <el-dropdown-item>螺蛳粉</el-dropdown-item>-->
<!--          <el-dropdown-item disabled>双皮奶</el-dropdown-item>-->
<!--          <el-dropdown-item divided>蚵仔煎</el-dropdown-item>-->
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import User from '../views/User'
export default {
  name: 'Header',
  data () {
    return {
      user: {}
    }
  },
  created () {
    let str = sessionStorage.getItem('user') || '{}'
    this.user = JSON.parse(str)
  },
  components: {User},
  methods: {
    handleCommand (command) {
      if (command === 'a') {
        this.$router.push('/login')
      } else if (command === 'b') {
        this.$router.push('/person')
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>

<style>
.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}
.el-icon-arrow-down {
  font-size: 12px;
}
</style>
