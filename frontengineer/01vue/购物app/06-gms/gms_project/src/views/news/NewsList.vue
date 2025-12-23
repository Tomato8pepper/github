<template>
  <div>
    <Navbar title="新闻列表"></Navbar>

    <div class="list">
      <ul>
        <li v-for="item in newsList" :key="item.id">
          <img :src="item.imgSrc" alt="">
          <div class="list-content">
            <span>{{item.title}}</span>
            <div class="list-desc">
              <p>点击数：{{item.number}}</p>
              <p>发表时间：{{item.time}}</p>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import Navbar from "../../components/Navbar.vue";
export default {
  data() {
    return {
      newsList: [
        {
          id: 1,
          imgSrc:
            "https://img1.baidu.com/it/u=3088623578,2284871675&fm=253&fmt=auto&app=138&f=JPEG?w=1911&h=800",
          title: "机阿里山放量杀跌浪费",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 2,
          imgSrc:
            "https://img1.baidu.com/it/u=549660128,2751598091&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500",
          title: "机阿里山的空间跌浪费",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 3,
          imgSrc:
            "https://img0.baidu.com/it/u=1162672670,4222951671&fm=253&fmt=auto&app=120&f=JPEG?w=664&h=374",
          title: "机阿里山的空间放量杀跌",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 4,
          imgSrc:
            "https://img0.baidu.com/it/u=1162672670,4222951671&fm=253&fmt=auto&app=120&f=JPEG?w=664&h=374",
          title: "机阿里山的空间放浪费",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 5,
          imgSrc:
            "https://img1.baidu.com/it/u=3088623578,2284871675&fm=253&fmt=auto&app=138&f=JPEG?w=1911&h=800",
          title: "机的空间放量杀跌浪费",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 6,
          imgSrc:
            "https://img0.baidu.com/it/u=1162672670,4222951671&fm=253&fmt=auto&app=120&f=JPEG?w=664&h=374",
          title: "机阿里山的空间放跌浪费",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 7,
          imgSrc:
            "https://img1.baidu.com/it/u=3088623578,2284871675&fm=253&fmt=auto&app=138&f=JPEG?w=1911&h=800",
          title: "机阿里山的空间跌浪费",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 8,
          imgSrc:
            "https://img0.baidu.com/it/u=1162672670,4222951671&fm=253&fmt=auto&app=120&f=JPEG?w=664&h=374",
          title: "机阿里山的空间放量费",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 9,
          imgSrc:
            "https://img0.baidu.com/it/u=1162672670,4222951671&fm=253&fmt=auto&app=120&f=JPEG?w=664&h=374",
          title: "机阿里山的空间放浪费",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 10,
          imgSrc:
            "https://img0.baidu.com/it/u=1162672670,4222951671&fm=253&fmt=auto&app=120&f=JPEG?w=664&h=374",
          title: "机阿里山的空间放浪费",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 11,
          imgSrc:
            "https://img0.baidu.com/it/u=1162672670,4222951671&fm=253&fmt=auto&app=120&f=JPEG?w=664&h=374",
          title: "机阿里山的空间放量费",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 12,
          imgSrc:
            "https://img1.baidu.com/it/u=3088623578,2284871675&fm=253&fmt=auto&app=138&f=JPEG?w=1911&h=800",
          title: "机阿里山的空间放量费",
          number: 3,
          time: "2025-12-20",
        },
      ],
    };
  },
  components: {
    Navbar,
  },
  created() {
    this.$axios.get('getnewslist')
    .then(res => {
      this.newsList = res.data.message
    })
    .catch(err => {
      console.log(err)
      
    })
  },
};
</script>

<style scoped>
.list{
    width: 100%;
}
ul{
    margin: 0;
    padding: 0;
    overflow: hidden;
}
ul li {
  display: flex;
  align-items: center;
  border-bottom: 1px solid #aaa;
  padding: 5px 5px;
  font-size: 15px;
}
li img{
  width: 60px;
  height: 60px;
  margin-left: 5px;
}
.list span{
  margin-left: 20px;
}
.list-desc{
  display: flex;
  align-items: center;
}
.list-desc p{
  margin: 8px 20px;
}
</style>