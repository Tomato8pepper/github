<template>
  <div>
    <ul>
      <li v-for="item in obj.dataList" :key="item.filmId" 
      @click="handleChangePage(item.filmId)">
        {{item.name}}
        <div>{{actorFilter(item.actors)}}</div>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'
import { onMounted, reactive } from 'vue'
import { useRouter } from 'vue-router'
export default {
  setup() {

    const router = useRouter()  // router === this.$router

    const obj = reactive({
      dataList: []
    })

    onMounted(() => {
      axios({
        url: 'https://m.maizuo.com/gateway?cityId=440300&pageNum=1&pageSize=10&type=1&k=1361788',
        headers: {
          'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.2.1","e":"1745218806485863880392705"}',
          'X-Host': 'mall.film-ticket.film.list'
        }
      }).then(res => {
        console.log('res.data', res.data.data.films)
        obj.dataList = res.data.data.films
      })
    })

    const handleChangePage = (id) => {
      console.log(id, 'id')
      // this.$router.push({
      //   name: 'Detail',
      //   params: { id }
      // })
      router.push(`/detail/:${id}`)
    }

    
    const actorFilter = (data) => {
      if(data === undefined) return "暂无主演"
      return data.map(item => item.name).join(' ')
    }

    return {
      obj,
      handleChangePage,
      actorFilter
    }
  }
}
</script>

<style>

</style>