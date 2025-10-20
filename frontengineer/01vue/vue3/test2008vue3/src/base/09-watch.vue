<template>
  <div>
    <input type="text" v-model="obj.mytext" />
    <ul>
        <li v-for="item in obj.dataList" :key="item">
            {{item}}
        </li>
    </ul>
 
  </div>
</template>

<script>
import { reactive, watch } from 'vue'
export default {
    setup() {
        const obj = reactive({
            mytext: '',
            dataList: ['aaa', 'bbb', 'ccc', 'abc', 'aab', 'aac', 'bbc'],
            oldList: ['aaa', 'bbb', 'ccc', 'abc', 'aab', 'aac', 'bbc']
        })

        watch(() => obj.mytext, () => {
            obj.dataList = obj.oldList.filter(item => item.includes(obj.mytext))
        })
         
        return {
            obj
        }
    }
}
</script>

<style>

</style>