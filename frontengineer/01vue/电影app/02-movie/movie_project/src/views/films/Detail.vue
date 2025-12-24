<template>
  <div v-if="filmDetail">
    <detail-header class="header" v-scroll="50">{{filmDetail.name}}</detail-header>
    <!-- <img :src="filmDetail.poster" /> -->
    <div class="poster" :style="{backgroundImage:'url('+filmDetail.poster+')'}"></div>
    <div class="content">
        <div class="film-item">
            <div class="film-name">
                <span>{{filmDetail.name}}</span>
                <span class="film-name-item">{{filmDetail.filmType.name}}</span>
            </div>
            <div class="film-grade">
                <span>{{filmDetail.grade}} </span>
                <span class="film-grade-word"> 分</span>
            </div>
             
        </div>
        <div>
            <div class="detail-text">{{filmDetail.category}}</div>
            <div class="detail-text">{{filmDetail.premiereAt | dateFilter}}上映</div>
            <div class="detail-text">{{filmDetail.nation}} | {{filmDetail.runtime}}分钟</div>
             <div class="detail-text"
             style="line-height:15px;margin-top:12px" :class="isHidden?'hidden':''">{{filmDetail.synopsis}}</div>

             <div style="text-align:center;">
                <van-icon :name="isHidden ? 'arrow-down' : 'arrow-up'" @click="isHidden=!isHidden" />
            </div>
        </div>
         
        <div class="detail-footer">
            <div>演职人员:</div>
            <detail-swiper :preview="3" name="actors">
                <detail-swiper-item v-for="(data, index) in filmDetail.actors" :key="index">
                    <div class="avatar" :style="{backgroundImage:'url('+data.avatarAddress+')'}"></div>
                    <div class="actorWord">{{data.name}}</div>
                    <div class="actorWord">{{data.role}}</div>
                </detail-swiper-item>
            </detail-swiper>
        </div>
        <div class="detail-footer">
            <div>剧照:</div>
            <detail-swiper :preview="2" name="photos">
                <detail-swiper-item v-for="(data, index) in filmDetail.photos" :key="index" >
                    <div class="avatar" @click="handlePreview(index)" :style="{backgroundImage:'url('+data+')'}"></div>
                    <div class="actorWord">{{data.name}}</div>
                    <div class="actorWord">{{data.role}}</div>
                </detail-swiper-item>
            </detail-swiper>
        </div>
         
    </div>
  </div>
</template>

<script>
import http from '../../util/http'
import moment from 'moment'
import { ImagePreview  } from 'vant'
import Vue from 'vue'
import 'moment/locale/zh-cn'
import DetailSwiper from './DeatilSwiper.vue'
import DetailSwiperItem from './DeatilSwiperItem.vue'
import DetailHeader from './DetailHeader.vue'
// 设定moment区域为中国
moment.locale('zh-cn');
Vue.filter('dateFilter', (date) => {
    return moment(date * 1000).format('YYYY-MM-DD')
})

Vue.directive('scroll', {
    // 指令创建生命周期
    inserted(el, binding) {
        // 原生dom节点
        console.log(el)
        console.log(binding.value)

        el.style.display = 'none'
        window.onscroll = () => {
            console.log('scroll')
            if((document.documentElement.scrollTop || document.body.scrollTop) < binding.value) {
                el.style.display = 'block'
            } else {
                el.style.display = 'none'
            }
        }
    },

    //  指令销毁生命周期
    unbind () {
        window.onscroll = null
    }
})
   

export default {
    
    data() {
        return {
            filmId: '',
            filmDetail: null,
            isHidden: true
        }
    },
    created() {
        
        this.filmId = this.$route.params.filmId
    },
    methods: {
        handlePreview(index) {
            ImagePreview({images:this.filmDetail.photos, startPosition: index, closeable: true})
        }
    },
    mounted() {
        http({
            url: `gateway?filmId=${this.filmId}&k=4846387`,
            headers: {
                'X-Host': 'mall.film-ticket.film.info'
            }
        }).then(res => {
                console.log(res)
                this.filmDetail = res.data.data.film
                
        })
    },
    components: {
        DetailSwiper,
        DetailSwiperItem,
        DetailHeader
    }
}
</script>

<style lang="scss" scoped>
// img{
//     width: 100%;
//     height: 200px;
// }
.header{
    width: 100%;
    position: fixed;
    top: 0;
}
.poster{
    width: 100%;
    height: 220px;
    background-position: center;
    background-size: cover;
}
.content{
    padding: 15px;
    margin-top: 4px;
    color: #191a1b;
    .film-item{
        display: flex;
        justify-content: flex-start;
        align-items: center;
        .film-name{
            .film-name-item{
                font-size: 9px;
                color: #fff;
                background-color: #d2d6dc;
                height: 14px;
                line-height: 14px;
                border-radius: 2px;
                display: inline-block;
                margin-left: 10px;
            }
        }
        .film-grade{
            font-size: 18px;
            font-style: italic;
            color: #ffb232;
            position: absolute;
            right: 15px;
            .film-grade-word{
                font-size: 10px;
            }
        }
    }
    .detail-text{
        margin-top: 4px;
        color: #797d82;
        font-size: 13px;
    }
}
.hidden{
    overflow: hidden;
    height: 30px;
}
.avatar{
    width: 100%;
    height: 117px;
    background-position: center;
    background-size: cover;
    margin: 10px 0;
}
.actorWord{
    font-size: 12px;
    color:#191a1b;
    text-align: center;
}
.detail-footer{
    width: 100%;
    overflow: hidden;
    margin-top: 20px;
}
</style>