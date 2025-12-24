<template>
  <div>
    <Navbar title="新闻列表"></Navbar>

    <div class="list">
      <ul>
        <li v-for="item in newsList" :key="item.id" @click="jumpDetail">
          <img :src="item.imgSrc" alt="">
          <div class="list-content">
            <div class="content-title">{{item.title}}</div>
            <div class="content-desc">
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
            "https://img0.baidu.com/it/u=1635447820,2457558664&fm=253&app=138&f=JPEG?w=800&h=1372",
          title: "习近平总书记重要指示为做好中央企业工作指明方向  文脉华章｜从这里读懂中华文明",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 2,
          imgSrc:
            "https://pic.rmb.bdstatic.com/bjh/cms/250828/25fe94ef126990399d53b008ffdcdfaf_1756374128.5892_228.jpeg",
          title: "每3度电就有1度是绿电，我们是怎样做到的？",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 3,
          imgSrc:
            "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimage109.360doc.com%2FDownloadImg%2F2024%2F02%2F1109%2F279562181_2_20240211091336301&refer=http%3A%2F%2Fimage109.360doc.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1769172582&t=cfa548374df68e51c0c1460f1758e5d2",
          title: "新闻1+1｜托育服务，既是家事也是国事！",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 4,
          imgSrc:
            "https://img1.baidu.com/it/u=1085792732,2878563975&fm=253&app=138&f=JPEG?w=800&h=1372",
          title: "“十项行动”看发展：科创兴城 向产育才 为高质量发展再赋能",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 5,
          imgSrc:
            "https://img2.baidu.com/it/u=148552999,551458368&fm=253&app=138&f=JPEG?w=800&h=1372",
          title: "走过2025｜为每一次期待的见面热泪盈眶",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 6,
          imgSrc:
            "https://q4.itc.cn/images01/20240627/ffc8a70bc65e4fdbaa6aa7619d14e875.jpeg",
          title: "新生儿住院治疗黄疸期间去世 家长:监控显示孩子脸朝下被闷",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 7,
          imgSrc:
            "https://pic.rmb.bdstatic.com/bjh/down/T8wbXwgHVr0zZv6d8WU8ww3df4c5fab846cea6c78b8e8b6fbd2e5d.jpg?for=bg",
          title: "利比亚军事领导人坠机身亡：正在土耳其访问 飞机残骸散落",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 8,
          imgSrc:
            "https://ww2.sinaimg.cn/mw690/60ed0cf7ly1i74ukg3cqmj21pm2yob2a.jpg",
          title: "京东巴黎仓库圣诞前遭洗劫 超五万件电子产品被盗损失逾3亿",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 9,
          imgSrc:
            "https://ww4.sinaimg.cn/mw690/60ed0cf7ly1i7nn6nn0vfj21cw2yokjl.jpg",
          title: "全省首个！贵州“数据精准开发推动全域旅游‘淡季",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 10,
          imgSrc:
            "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimage109.360doc.com%2FDownloadImg%2F2025%2F11%2F1913%2F303662475_5_20251119012254883.jpeg&refer=http%3A%2F%2Fimage109.360doc.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1769172582&t=6045ec2493d4c1237244bafa1137597f",
          title: "羽球时尚化：第四大品牌薰风KUMPOO如何借世界",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 11,
          imgSrc:
            "https://ww3.sinaimg.cn/mw690/60ed0cf7ly1i7ora2cmr2j21e82yo1kx.jpg",
          title: "“你好，工匠”系列报道之一 电焊特级操作师张辉峰",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 12,
          imgSrc:
            "https://wx4.sinaimg.cn/mw690/60ed0cf7ly1i7ulfc11dvj21co2ynhdt.jpg",
          title: "为高危作业提供确定性：中感智能清仓机器人如何用",
          number: 3,
          time: "2025-12-20",
        },
      ],
    };
  },
  methods: {
    jumpDetail() {
      this.$router.push({ name: 'DetailList' })
    }
  },
  components: {
    Navbar,
  },
  created() {
    // this.$axios.get('getnewslist')
    // .then(res => {
    //   this.newsList = res.data.message
    // })
    // .catch(err => {
    //   console.log(err)
      
    // })
  },
};
</script>

<style scoped>
/* .list{
    width: 100%;
} */
ul{
    margin: 0 0 60px 0;
    padding: 0;
    overflow: hidden;
}
ul li {
  display: flex;
  align-items: center;
  border-bottom: 1px solid #ebedf0;
  padding: 10px 10px;
  font-size: 15px;
  font-family: -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, Segoe UI, Arial, Roboto, 'PingFang SC', miui, 'Hiragino Sans GB', 'Microsoft Yahei', sans-serif;
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
}
li img{
  width: 40px;
  height: 60px;
  margin-right: 15px;
  border-radius: 5px;
}
.content-desc{
  display: flex;
  align-items: center;
  justify-content: start;
}
.content-desc p{
  margin: 8px 20px 0 0;
}
</style>