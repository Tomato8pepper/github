<template>
  <div class="detail">
    <Navbar title="新闻详情"></Navbar>
    <div class="detail-img">
      <img :src="newsInfo.imgSrc" alt="">
    </div>
    <div class="detail-content">
      <div class="content-title">
        {{newsInfo.title}}
      </div>
      <div class="content-info">
        <div class="info-number">点击数：{{newsInfo.number}}</div>
        <div class="info-time">发表时间：{{newsInfo.time}}</div>
      </div>
      <div class="info-cont">
          {{newsInfo.content}}
        </div>
    </div>
  </div>
</template>

<script>
import Navbar from '../../components/Navbar.vue'
export default {
  data() {
    return {
      newsInfo: {}
    }
  },
  created() {
    console.log(this.$route.params)
    this.newsInfo = this.$route.params.item
    
    // let { id } = this.$route.params
    // let url = 'getnew/' + id
    // this.$axios.get(url)
    // .then(res => {
    //   this.newsInfo = res.data.message[0]
    // })
    // .catch(err => {
    //   console.log(err)
    // })
  },
    components: {
        Navbar
    }
}
</script>

<style scoped>
.detail{
  background-color: #ebedf0;
}
.detail-img{
  text-align: center;
}
img{
  width: 140px;
  height: 200px;
}
.content-info{
  display: flex;
  justify-content: space-around;
}
.content-info{
  border-bottom: 1px solid #ebedf0;
  margin-bottom: 10px;
}
.info-cont{
  color: #797d82;
  font-size: 13px;
}
</style>