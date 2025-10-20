<template>
    <div>
        <img class="top" src="https://img1.baidu.com/it/u=153359460,691572602&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500" />
        <van-tabs v-model="activeName">
            <van-tab title="正在热映" name="a">
                <van-list 
                :style="{marginBottom: height}"
                finished-text="没有更多了"
                :finished="finished"
                v-model="loading"
                @load="onLoad"
                :immediate-check="false">
                    <van-cell v-for="(item, index) in datalist" :key="index" @click="handleClick(item.filmId)">
                        <img :src="item.poster" />
                        <div>
                            <div class="title">
                                {{item.name}}
                            </div>
                            <div class="content">
                                <div :class="item.grade ? '' : 'hidden'">
                                    观众评分: <span style="color: red">{{item.grade}}</span>
                                </div>
                                <div class="actors">
                                    主演：{{item.actors | actorsFilter}}
                                </div>
                                <div>
                                    {{item.nation}} | {{item.runtime}}分钟
                                </div>
                            </div>
                        </div>
                    </van-cell>
                </van-list>
            </van-tab>
            <van-tab title="即将上映" name="b">
                <!-- <van-list 
                :style="{marginBottom: height}"
                finished-text="没有更多了"
                :finished="finished"
                v-model="loading"
                @load="otheronLoad"
                :immediate-check="false">
                    <van-cell v-for="(item) in otherdatalist" :key="item.filmId" @click="handleClick(item.filmId)">
                        <img :src="item.poster" />
                        <div>
                            <div class="title">
                                {{item.name}}
                            </div>
                            <div class="content">
                                <div :class="item.grade ? '' : 'hidden'">
                                    观众评分: <span style="color: red">{{item.grade}}</span>
                                </div>
                                <div class="actors">
                                    主演：{{item.actors | actorsFilter}}
                                </div>
                                <div>
                                    {{item.nation}} | {{item.runtime}}分钟
                                </div>
                            </div>
                        </div>
                    </van-cell>
                </van-list> -->
            </van-tab>
        </van-tabs>
    </div>
</template>

<script>
import http from '../../util/http'
import Vue from 'vue'
Vue.filter('actorsFilter', (data) => {
    console.log('')
    if(data === undefined) return '暂无主演'
    return data.map(item => item.name).join(' ')
})
export default {
    data() {
        return {
            datalist: [],
            height: '0px',
            loading: false,
            finished: false,
            count: 1,
            total: 0,
            activeName: 'a'
        }
    },
    mounted() {
        this.height = document.querySelector('.bottom').offsetHeight + 'px';
        
        console.log(this.height)
        
        http({
            url: `gateway?cityId=${this.$store.state.cityId}&pageNum=1&pageSize=10&type=1&k=4767705`,
            headers: {
                'X-Host': 'mall.film-ticket.film.list'
            }
        }).then(res => {
            console.log(res.data.data.films)
            this.datalist = res.data.data.films
            this.total = res.data.data.total
            console.log('===1', this.total)
        })
 
        
    },
    methods: {
        onLoad() {
            console.log('==', this.datalist.length, this.total)
            if(this.datalist.length === this.total && this.total !== 0) {
                this.finished = true
                return
            }

            console.log('到底了')
            this.count++
            http({
                url: `gateway?cityId=${this.$store.state.cityId}&pageNum=${this.count}&pageSize=10&type=2&k=1645379`,
                headers: {
                    'X-Host': 'mall.film-ticket.film.list'
                }
            }).then(res => {
                console.log('======',  res.data.data.films)
                this.datalist = [...this.datalist, ...res.data.data.films]
                this.loading = false
                console.log(this.loading, this.datalist)
            })
        },
        handleClick(filmId) {
            console.log(filmId)
            this.$router.push({
                name: 'Detail',
                params: {
                    filmId
                }
            })
        }
    }
}
</script>

<style lang='scss' scoped>

.top{
    width: 100%;
    height: 200px;
}
.tabnav{
    text-align: center;
    position: sticky;
    top: 0;
    background: white;
    span{
        margin: 100px 50px;
    }
    .chosed{
        color: red;
    }
}
.van-cell{
    list-style: none;
    overflow: hidden;
    padding: 10px;
    img{
        width: 60px;
        float: left;
        padding-right: 10px;
    }
    .title{
        font-size: 16px;
    }
    .content{
        font-size: 13px;
        color: grey;
        .actors {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
    }
}
.hidden{
    visibility: hidden;
}

</style>