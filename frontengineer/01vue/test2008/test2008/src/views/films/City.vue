<template>
  <div>
    <van-index-bar :index-list="computedList" @select="handleChange" :style="{marginBottom: height}">
        <div v-for="(item) in cityList" :key="item.type">
            <van-index-anchor :index="item.type"/>
            <van-cell :title="val.name" @click="handleClick(val)" v-for="val in item.list" :key="val.cityId" />
        </div>
    </van-index-bar>
  </div>
</template>

<script>
import { Toast } from 'vant'
import http from '../../util/http'
import mixin from '../../util/mixin.js'
export default {
    mixins: [mixin],
    data() {
        return {
            cityList: [],
            height: '0px'
        }
    },
    mounted() {
        console.log(document.querySelector('.bottom').offsetHeight)
        this.height = document.querySelector('.bottom').offsetHeight + 'px'
        http({
            url: `/gateway?k=6198950`,
            headers: {
                'X-Host': 'mall.film-ticket.city.list'
            }
        }).then(res => {
            console.log(res.data.data.cities)
            this.cities = res.data.data.cities
            this.renderCity(res.data.data.cities)
        })
    },
    computed: {
        computedList() {
            return this.cityList.map(item => item.type)
        }
    },
    methods: {
        handleClick(data) {
            console.log('dianjishijian',data)  
            
            //   传统多页面方案
            //   location.href = '#/cinemas?cityname=' + data.name
            //   cookie, localStorage

            // 单页面方案
            // 1. 中间人模式
            // 2. bus事件总线 $on, $emit


            // vuex  状态管理模式

            this.$store.commit('changeCityName', data.name)
            this.$store.commit('changeCityId', data.cityId)
            this.$router.back()

            
        },
        handleChange(data) {
            // console.log('change', data)
            Toast(data)
        },
        renderCity(list) {
            // console.log(list)
            var letterList = []
            for(var i=65; i<=90; i++) {
                letterList.push(String.fromCharCode(i))
            }
            // console.log(letterList)
            letterList.forEach(letter => {
                var newList = list.filter(item => item.pinyin.substring(0, 1).toUpperCase() === letter)
                this.cityList.push({
                    type: letter,
                    list: newList
                })  
            })
            console.log('cityList', this.cityList)
        }
    }
}
</script>

<style lang="scss">
.van-toast--html, .van-toast--text{
    min-width: 30px;
}
</style>