<template>
  <div>
        <el-menu
          style="width: 200px; min-height: calc(100vh - 50px)"
          :default-active="this.$route.path"
          router
          class="el-menu-vertical-demo">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>系统管理</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="/user">用户管理</el-menu-item>
              <el-menu-item index="/goods">商品管理</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <template slot="title">分组二</template>
              <el-menu-item index="/order">订单管理</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group>
              <template slot="title">分组三</template>
              <el-menu-item index="/category">分类管理</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item index="2" v-if="user.role === 1">
            <i class="el-icon-menu"></i>
            <span index="data" route="{path:'/'}">数据管理</span>
<!--            <el-menu-item index="data" route="{path:'/'}">数据管理</el-menu-item>-->
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
          </el-menu-item>
          <el-menu-item index="4" v-if="user.role === 2">
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
          </el-menu-item>
        </el-menu>
  </div>
</template>

<script>
export default {
  name: 'Aside',
  data () {
    return {
      user: {},
      // 设置默认高亮的菜单
      path: this.$route.path
    }
  },
  created () {
    console.log(this.$route.path)
    let userStr = sessionStorage.getItem('user') || '{}'
    this.user = JSON.parse(userStr)
    // 请求服务端，确认当前登录用户的合法信息
    this.$axios.get('/user/' + this.user.id).then(res => {
      if (res.data.code === '0') {
        this.user = res.data.data
      }
    })
  }
}
</script>

<!--<script>-->
<!--export default {-->
<!--  methods: {-->
<!--    handleOpen(key, keyPath) {-->
<!--      console.log(key, keyPath);-->
<!--    },-->
<!--    handleClose(key, keyPath) {-->
<!--      console.log(key, keyPath);-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

<style scoped>

</style>
