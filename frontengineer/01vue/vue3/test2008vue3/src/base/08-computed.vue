<template>
  <div>
    <input type="text" v-model="obj.mytext" />
    <ul>
        <li v-for="item in filterList" :key="item">
            {{item}}
        </li>
    </ul>

    <ul>
        <li v-for="item in filterListMethod()" :key="item">
            {{item}}
        </li>
    </ul>
  </div>
</template>

<script>
import { reactive, computed } from 'vue'
export default {
    setup() {
        const obj = reactive({
            mytext: '',
            dataList: ['aaa', 'bbb', 'ccc', 'abc', 'aab', 'aac', 'bbc']
        })

        const filterListMethod = () => {
            return obj.dataList.filter(item => item.includes(obj.mytext))
        }

        const filterList = computed(() => {
            return obj.dataList.filter(item => item.includes(obj.mytext))
        })

        return {
            obj,
            filterList,
            filterListMethod
        }
    }
}
</script>

<style>

</style>