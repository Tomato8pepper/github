<template>
  <!-- <div></div> -->
  <div>
    {{obj.mytext}}
    <input type="text" v-model="obj.mytext" ref="mytextref" />
    <button @click="handleAdd">Add</button>
    <ul>
        <li v-for="item in obj.myList" :key="item">
            {{item}}
        </li>
    </ul>

    <ul>
        <li v-for="item in datalist" :key="item">
            {{item}}
        </li>
    </ul>
  </div>
</template>

<script>
import { reactive, ref } from 'vue'  
export default {
    // data() {
    //     return {}
    // },

    // mounted() {
    //     console.log('created')
    //      console.log(this.$refs.mytextref)
    // },

    // vue3老写法， 原vue中beforeCreated、created  生命周期=== setup


    setup() {
        const obj = reactive({
            mytext: '',
            myList: []
        })

        const str = reactive('')
        const datalist = reactive([])

        const mytextref = ref()

        const handleAdd = () => {
            console.log(mytextref.value)
            obj.myList.push(obj.mytext)

            datalist.push(obj.mytext)

            obj.mytext = ''
        }

        return {
            obj,
            handleAdd,
            datalist,
            str,
            mytextref
        }
    }
}
</script>

<style>

</style>