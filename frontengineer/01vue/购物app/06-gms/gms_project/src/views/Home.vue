<template>
  <div class="home">
    <mt-swipe :auto="1000">
      <mt-swipe-item v-for="item in imgs" :key="item.id">
        <img :src="item.content" />
      </mt-swipe-item>
    </mt-swipe>
    <div class="grid">
      <ul>
        <li v-for="(module, index) in modules" :key="index">
            <router-link :to="module.route">
                <span :class="module.className"></span>
                <div>{{module.title}}</div>
            </router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      imgs: [
        {
          id: 1,
          content:
            "https://img2.baidu.com/it/u=2360297995,3511690021&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500",
        },
        {
          id: 2,
          content: 'https://img1.baidu.com/it/u=3088623578,2284871675&fm=253&fmt=auto&app=138&f=JPEG?w=1911&h=800'
        },
        {
          id: 3,
          content:
            "https://img1.baidu.com/it/u=549660128,2751598091&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500",
        },
        {
          id: 4,
          content:
            "https://img0.baidu.com/it/u=1162672670,4222951671&fm=253&fmt=auto&app=120&f=JPEG?w=664&h=374",
        },
        {
          id: 5,
          content:
            "https://img1.baidu.com/it/u=1925440351,2217858683&fm=253&fmt=auto&app=138&f=JPEG?w=752&h=500",
        },
        {
          id: 6,
          content:
            "https://img2.baidu.com/it/u=1180194578,1247959243&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500",
        },
        {
          id: 7,
          content:
            "https://img0.baidu.com/it/u=2358257367,3115002835&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500",
        }
        
      ],
      modules: [
        { title: '新闻资讯', className: 'back-news', route: {name: 'NewsList'}},
        { title: '图文分享', className: 'back-picShare', route: {name: ''}},
        { title: '商品展示', className: 'back-goodsShow', route: {name: ''}},
        { title: '留言反馈', className: 'back-feedback', route: {name: ''}},
        { title: '搜索资讯', className: 'back-search', route: {name: ''}},
        { title: '联系我们', className: 'back-callme', route: {name: ''}}
      ]
    };
  },
  created() {
    // this.$axios.get('getlunbo')
    // .then(res => {
    //   console.log(res)
    // })
    // .catch(err => {
    //   console.log(err)
    // })
  },
};
</script>

<style>
.home {
  width: 100%;
  height: 200px;
}
img{
  width: 100%;
  height: 100%;
}
.grid{
  margin: 20px 0;
}
.grid span{
  display: inline-block;
  margin: 10px 0;
  width: 50px;
  height: 50px;
  background-repeat: round;
}
.back-news{
  background-image: url('../assets/news.png');
}
.back-picShare{
  background-image: url('../assets/picShare.png');
}
.back-goodsShow{
  background-image: url('../assets/goodsShow.png');
}
.back-feedback{
  background-image: url('../assets/feedback.png');
}
.back-search{
  background-image: url('../assets/search.png');
}
.back-callme{
  background-image: url('../assets/callme.png');
}
ul{
  margin: 0;
  padding: 0;
  overflow: hidden;
}
li{
  list-style: none;
  float: left;
  width: 33.333%;
  text-align: center;
}

</style>