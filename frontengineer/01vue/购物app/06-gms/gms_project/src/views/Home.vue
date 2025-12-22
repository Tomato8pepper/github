<template>
  <div class="home">
    <mt-swipe :auto="4000">
      <mt-swipe-item v-for="item in imgs" :key="item.id">
        <img :src="item.content" />
      </mt-swipe-item>
    </mt-swipe>

    <div class="grid">
      <ul>
        <li>
            <a href="">
                <div>111</div>
            </a>
        </li>
        <li>
            <a href="">
                <div>222</div>
            </a>
        </li>
        <li>
            <a href="">
                <div>333</div>
            </a>
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
          content:
            "https://img1.baidu.com/it/u=549660128,2751598091&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500",
        },
        {
          id: 3,
          content:
            "https://img1.baidu.com/it/u=1925440351,2217858683&fm=253&fmt=auto&app=138&f=JPEG?w=752&h=500",
        },
      ],
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
</style>