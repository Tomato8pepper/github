<template>
    <div>
        <van-nav-bar ref="navbar" title="影院" @click-left="handleLeft" @click-right="handleRight">
            <template #left>
                {{$store.state.cityName}}
                <van-icon name="arrow-down" />
            </template>
            <template #right>
                <van-icon name="search" size="24" />
            </template>
        </van-nav-bar>
        <div class="box" :style="{height: height}">
            <ul>
                <li v-for="item in cinemasList" :key="item.cinemaId">
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
    </div>
</template>
    
<script>

import BetterScroll from 'better-scroll'
import { mapState, mapActions, mapMutations } from 'vuex'
export default {
    data() {
        return {
            height: '0px'
        }
    },
    computed: {
        ...mapState(['cinemasList', 'cityId'])
    },
    mounted() {
        this.height = document.documentElement.clientHeight - document.querySelector('.bottom').offsetHeight - 
        this.$refs.navbar.$el.offsetHeight + 'px';

        if(this.cinemasList.length === 0) {
            this.getCinemasData(this.cityId)
            .then(res => {
                console.log('数据完事儿了')
                this.$nextTick(() => {
                    new BetterScroll(".box", {
                        scrollbar: true
                    })
                })
            })
        }else {
            console.log('缓存')
            // dom挂载后执行
            this.$nextTick(() => {
                new BetterScroll(".box", {
                    scrollbar: true
                })
            })
        }
     
    },
    methods: {
        ...mapActions(['getCinemasData']),
        ...mapMutations(['clearCinemasList']),
        handleLeft() {
            this.$router.push('/city')
            this.clearCinemasList()
        },
        handleRight() {
            console.log('缓存')
            this.$router.push('/search')
        }
    }
}
</script>

<style lang="scss" scoped>
.box{
    overflow: hidden;
    height: 600px;
    position: relative;
}
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