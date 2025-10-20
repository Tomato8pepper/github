<template>
  <div>
    <van-search
      v-model="value"
      show-action
      placeholder="请输入搜索关键词"
      @search="onSearch"
      @cancel="onCancel"
    />
    <ul v-if="value">
        <li v-for="item in computedList" :key="item.cinemaId">
            <div class="li-left">
                <div class="li-left-top">{{item.name}}</div>
                <div class="li-left-bottom">{{item.address}}</div>
            </div>
            <div class="li-right" >
                <span> ￥</span>{{item.lowPrice / 100}}<span>起</span>
                <div :style="{fontSize: '11px', textAlien: 'center', color:'#797d82', marginTop: '5px'}">距离未知</div>
            </div>
        </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      value: ''
    }
  },
  mounted() {
    if(this.$store.state.cinemasList.length === 0) {
        this.$store.dispatch('getCinemasData', this.$store.state.cityId)
    }else {
        console.log('缓存')
    }
  },
  methods: {
    onSearch() {},
    onCancel() {
      this.$router.back()
    }
  },
    computed: {
        computedList() {
            return this.$store.state.cinemasList.filter(item => item.name.toUpperCase()
                .includes(this.value.toUpperCase()) || item.address.toUpperCase().includes(this.value.toUpperCase()))
        }
    }
}
</script>

<style lang="scss" scoped>
li{
    display: flex;
    padding: 15px;
    .li-left{
        width: 265px;
        padding-right: 15px;
        height: 45px;
        &-top{
            width: 212px;
            height: 22.5px;
            line-height: 22.5px;
            color: #191a1b;
            font-size: 15px;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }
        &-bottom{
            width: 212px;
            height: 18px;
            line-height: 18px;
            margin-top: 5px;
            color: #797d82;
            font-size: 12px;
            text-overflow: ellipsis;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }
    }
    .li-right{
        width: 70px;
        height: 44px;
        text-align: center;
        color: #ff5f16;
        font-size: 15px;
        span{
            font-size: 10px;
        }
    }
}
</style>