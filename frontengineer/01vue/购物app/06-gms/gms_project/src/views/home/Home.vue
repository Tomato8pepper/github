<template>
  <div class="home">
    <div class="home-image">
      <mt-swipe :auto="1000">
        <mt-swipe-item v-for="item in imgs" :key="item.id">
          <img :src="item.content" />
        </mt-swipe-item>
      </mt-swipe>
    </div>
    
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
            "https://img0.baidu.com/it/u=132109662,2974978733&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500",
        },
        {
          id: 2,
          content: 'https://img2.baidu.com/it/u=2644633810,1844202298&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=319'
        },
        {
          id: 3,
          content:
            "https://img2.baidu.com/it/u=549882333,972383674&fm=253&fmt=auto&app=138&f=JPEG?w=751&h=500",
        },
        {
          id: 4,
          content:
            "https://img0.baidu.com/it/u=1226411821,570469579&fm=253&fmt=auto&app=138&f=JPEG?w=767&h=500",
        }
      ],
      modules: [
        { title: '新闻资讯', className: 'back-news', route: {name: 'NewsList'}},
        { title: '图文分享', className: 'back-picShare', route: {name: 'PhotoList'}, query:{categoryId:0}},
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

<style scoped>
.home-image{
  width: 100%;
  height: 200px;
}
.home-image img{
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
  background-image: url('../../assets/news.png');
}
.back-picShare{
  background-image: url('../../assets/picShare.png');
}
.back-goodsShow{
  background-image: url('../../assets/goodsShow.png');
}
.back-feedback{
  background-image: url('../../assets/feedback.png');
}
.back-search{
  background-image: url('../../assets/search.png');
}
.back-callme{
  background-image: url('../../assets/callme.png');
}
li{
  float: left;
  width: 33.333%;
  text-align: center;
}

</style>