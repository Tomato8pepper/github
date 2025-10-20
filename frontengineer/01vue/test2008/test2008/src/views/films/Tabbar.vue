<template>
  <div>
    <van-tabbar v-model="active" class="bottom">
        <van-tabbar-item name="home" icon="home-o">首页</van-tabbar-item>
        <van-tabbar-item name="movie" icon="search">影院</van-tabbar-item>
        <van-tabbar-item name="mine" icon="friends-o">我的</van-tabbar-item>
        <!-- <van-tabbar-item icon="setting-o">标签4</van-tabbar-item> -->
    </van-tabbar>
  </div>
</template>

<script>
export default {
    
    watch: {
        active(newV) {
            console.log('===')
            if(newV === 'home') {
                this.$router.push('/home')
            }else if(newV === 'movie') {
                this.$router.push('/cinemas')
            }else if(newV === 'mine') {
                this.$router.push('/mine')
            }
        }
    },
    data() {
        return {
            active: ''
        }
    },
    created() {
        console.log('===' ,this.$route.path)
        if(this.$route.path === '/home') {
            this.active = 'home'
        }else if(this.$route.path === '/cinemas') {
            this.active = 'movie'
        }else if(this.$route.path === '/mine') {
            this.active = 'mine'
        
        }
    }
}
</script>

<style lang="scss" scoped>

</style>