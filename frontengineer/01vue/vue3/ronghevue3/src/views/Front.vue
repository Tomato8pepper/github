<template>
  <div class="front-container">
    <header class="header-nav">
      <div class="header-left-warp">
        <div class="logo-warp">
          <div class="logo">
            <el-icon class="logo-pic" :size="30"><Setting /></el-icon>
            <!-- <img src="../../config/logo.svg" alt="logo" /> -->
          </div>
          <div class="logo-text">{{ projectName }}</div>
        </div>
        <div class="header-navs">
          <el-menu
            router
            :default-active="activeMenu"
            mode="horizontal"
            :ellipsis="false">
            <el-menu-item index="/front/home">前台首页</el-menu-item>
          </el-menu>
        </div>
      </div>
      <div class="user-warp">
        <!-- 未登录状态显示登录注册按钮 -->
        <template v-if="!account.id">
          <div class="btn-login">
            <el-button @click="router.push('/login')">登录</el-button>
          </div>
          <div class="btn-login" style="">
            <el-button @click="router.push('/register')">注册</el-button>
          </div>
        </template>

        <el-dropdown v-else class="custom-dropdown">
          <div class="user-avatar">
            <img :src="account.avatarUrl" />
          </div>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>{{ account.nickname }}</el-dropdown-item>
              <el-dropdown-item>
                <router-link to="/front/person" class="dropdown-link">
                  <el-icon><User /></el-icon>
                  <span>个人信息</span>
                </router-link>
              </el-dropdown-item>
              <el-dropdown-item>
                <router-link to="/front/password" class="dropdown-link">
                  <el-icon><Lock /></el-icon>
                  <span>修改密码</span>
                </router-link>
              </el-dropdown-item>
              <el-dropdown-item>
                <div @click="logout" class="dropdown-link">
                  <el-icon><SwitchButton /></el-icon>
                  <span>退出登录</span>
                </div>
              </el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </header>
    <div class="main-content">
      <router-view @update-account="handleUpdateAccount"></router-view>
    </div>

    <footer class="front-footer">
      <p>@{{new Date().getFullYear()}} {{projectName}}. 保留所有权利</p>
    </footer>
  </div>
</template>

<script setup>
import { ElMessage } from "element-plus"
import { computed, ref } from "vue"
import { useRoute, useRouter } from "vue-router"
import { DataAnalysis, Key, Lock, User, Tools, Setting, SwitchButton} from '@element-plus/icons-vue'


const router = useRouter()
const route = useRoute()

const account = ref(
  localStorage.getItem('account') ? JSON.parse(localStorage.getItem('account')) : {}
)

const activeMenu = computed(() => route.path)

const logout = () => {
  localStorage.removeItem('account')
  ElMessage.success('退出成功')
  router.push('/login')
}

const handleUpdateAccount = (updateAccount) => {
  account.value = updateAccount
}
</script>

<style lang="scss" scoped>
$front-back-color: #fff;
$front-font-color: #4084d9;

.front-container{
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}
.header-nav {
  z-index: 1800;
  position: sticky;
  top: 0;
  height: 70px;
  background-color: $front-back-color;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 40px;
  box-shadow: 0 2px 10px 0 rgba(0, 0, 0, 0.1);
  overflow: visible;
  .header-left-warp{
    display: flex;
    align-items: center;
    height: 100%;
    .logo-warp{
      display: flex;
      align-items: center;
      margin-left: 20px;
      .logo{
        width: 30px;
        height: 30px;
        margin-right: 10px;
        .logo-pic{
          width: 100%;
          height: 100%;
          object-fit: cover;
        }
        // img{
        //   width: 100%;
        //   height: 100%;
        //   object-fit: cover;
        // }
      }
      .logo-text{
        font-size: 22px;
        font-weight: 500;
        color: $front-font-color;
      }
      .header-nav{
        margin-left: 80px;
        height: 100%;
        .el-menu{
          background-color: $front-back-color !important;
          border: none !important;
          // 高一直保持70px，不受任何因素影响
          height: 70px !important;
        }
        .el-menu-item{
          height: 70px !important;
          line-height: 70px !important;
        }
        .el-menu-item:hover{
          color: $front-font-color !important;
          background-color: transparent !important;
          border: none !important;
        }
        .el-menu-item.is-active{
          color: $front-font-color !important;
          background-color: transparent !important;
        }
      }

    }
  }
  .user-warp{
    display: flex;
    align-items: center;
    margin-right: 20px;
    height: 100%;
    .btn-login{
      margin-top: 0;
    }
    .user-avatar{
      width: 40px;
      height: 40px;
      border-radius: 50%;
      overflow: hidden;
      border: 1px solid $front-font-color;
      padding: 2px;
      cursor: pointer;
      outline: none !important;
      img{
        width: 100%;
        height: 100%;
        object-fit: cover;
        border-radius: 50%;
      }
    }
    .dropdown-link{
      display: flex;
      align-items: center;
      color: inherit;
      text-decoration: none;
      .el-icon{
        margin-right: 8px;
      }

    }
    
  }
}
.main-content{
  flex: 1;
  background-color: #fff;
}
.front-footer{
  padding: 16px 24px;
  text-align: center;
  background-color: #fff;
  color: #666;
  font-size: 12px;
  border-top: 1px solid #eee;
}
</style>