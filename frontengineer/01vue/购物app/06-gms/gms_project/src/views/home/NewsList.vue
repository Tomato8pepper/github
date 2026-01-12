<template>
  <div class="newslist">
    <Navbar title="新闻列表"></Navbar>

    <div class="list">
      <ul>
        <li v-for="item in newsList" :key="item.id" @click="jumpDetail(item)">
          <div class="list-img">
            <img :src="item.imgSrc" alt="">            
          </div>
          <div class="list-content">
            <div class="content-title">{{item.title}}</div>
            <div class="content-desc">
              <p class="p1">点击数：{{item.number}}</p>
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
            "https://img0.baidu.com/it/u=2681013384,1978468569&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=1896",
          title: "习近平总书记重要指示为做好中央企业工作指明方向  文脉华章｜从这里读懂中华文明",
          number: 3,
          time: "2025-12-20",
          content: '2024年3月，习近平总书记来到湖南省常德市鼎城区谢家铺镇粮食生产万亩综合示范片区，走进水稻田边，察看秧苗培育和土地翻耕情况，并同种粮大户、农技人员、基层干部和村民亲切交流，详细询问春耕备耕等情况。总书记强调，我国有14亿多人口，粮食安全必须靠我们自己保证，中国人的饭碗应该主要装中国粮。作为全国粮食主产区之一，2025年，湖南围绕打造更高水平“洞庭粮仓”发力，克服多种不利因素，通过科技赋能、设施完善等举措，促进粮食生产高产再高产。三湘大地的每一寸耕土、每一粒稻穗，都在书写着“中国人的饭碗装中国粮”的生动答卷。(徐志雄 张雪盈 龚顺)'
        },
        {
          id: 2,
          imgSrc:
            "https://img0.baidu.com/it/u=269587204,3994517811&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1345",
          title: "每3度电就有1度是绿电，我们是怎样做到的？",
          number: 3,
          time: "2025-12-20",
          content: '近日，一段日本防卫大学学生冒雨集体参拜靖国神社的视频在日本社交媒体广泛流传。看着这段气氛肃杀的视频，“日本军国主义复活”既视感呼之欲出。'
        },
        {
          id: 3,
          imgSrc:
            "https://img2.baidu.com/it/u=286478407,787649312&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=1084",
          title: "新闻1+1｜托育服务，既是家事也是国事！",
          number: 3,
          time: "2025-12-20",
          content: '新华社北京12月24日电（记者袁睿、邵艺博）针对美方拟自2027年起对中国半导体产品征收关税，外交部发言人林剑12月24日在例行记者会上表示，中方坚决反对美方滥施关税，无理打压中国产业。美方做法扰乱全球产供链稳定，阻碍各国半导体产业发展，损人害己。'
        },
        {
          id: 4,
          imgSrc:
            "https://img2.baidu.com/it/u=3813958042,3249698157&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=664",
          title: "“十项行动”看发展：科创兴城 向产育才 为高质量发展再赋能",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 5,
          imgSrc:
            "https://img0.baidu.com/it/u=2112571248,4231323136&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=1422",
          title: "走过2025｜为每一次期待的见面热泪盈眶",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 6,
          imgSrc:
            "https://img2.baidu.com/it/u=1233694094,176168593&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1778",
          title: "新生儿住院治疗黄疸期间去世 家长:监控显示孩子脸朝下被闷",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 7,
          imgSrc:
            "https://img2.baidu.com/it/u=2224558647,39425997&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=1422",
          title: "利比亚军事领导人坠机身亡：正在土耳其访问 飞机残骸散落",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 8,
          imgSrc:
            "https://img2.baidu.com/it/u=111054584,2743230861&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=889",
          title: "京东巴黎仓库圣诞前遭洗劫 超五万件电子产品被盗损失逾3亿",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 9,
          imgSrc:
            "https://img2.baidu.com/it/u=2908633079,2948585188&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=751",
          title: "全省首个！贵州“数据精准开发推动全域旅游‘淡季",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 10,
          imgSrc:
            "https://img1.baidu.com/it/u=4177127779,15416765&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=667",
          title: "羽球时尚化：第四大品牌薰风KUMPOO如何借世界",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 11,
          imgSrc:
            "https://img2.baidu.com/it/u=570534185,2137476261&fm=253&fmt=auto?w=123&h=161",
          title: "“你好，工匠”系列报道之一 电焊特级操作师张辉峰",
          number: 3,
          time: "2025-12-20",
        },
        {
          id: 12,
          imgSrc:
            "https://img1.baidu.com/it/u=2315874529,2489808026&fm=253&fmt=auto&app=138&f=JPEG?w=333&h=499",
          title: "为高危作业提供确定性：中感智能清仓机器人如何用",
          number: 3,
          time: "2025-12-20",
        },
      ],
    };
  },
  methods: {
    jumpDetail(item) {
      this.$router.push({ name: 'DetailList', params:{ item }})
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
ul{
    margin-bottom: 60px;
}
ul li {
  display: flex;
  align-items: center;
  border-bottom: 1px solid #ebedf0;
  padding: 5px 5px;
  color: grey;
  font-family: -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, Segoe UI, Arial, Roboto, 'PingFang SC', miui, 'Hiragino Sans GB', 'Microsoft Yahei', sans-serif;
  overflow: hidden;
}
.list-img{
  width: 40px;
  height: 60px;
  margin-right: 10px;
}
.list-img img{
  width: 40px;
  height: 60px;
  border-radius: 5px;
}
.content-title{
  font-size: 13px;
  overflow: hidden;
  text-overflow: ellipsis;
  /* white-space: nowrap; */
}
.content-desc{
  font-size: 10px;
  display: flex;
  align-items: center;
  justify-content: start;
}
.content-desc .p1{
  margin-right: 50px;
}
</style>