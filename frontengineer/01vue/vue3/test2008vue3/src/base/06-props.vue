<template>
  <div>
    通信
    <Child myname="父子" @event="change"></Child>

    <Sidebar v-show="isShow"></Sidebar>
  </div>
</template>

<script>
import Child from './component/Child.vue'
import Sidebar from "./component/Sidebar.vue"
import { reactive, toRefs } from 'vue'
export default {
    components: {
        Child,
        Sidebar
    },
    setup() {
        const obj = reactive({
            isShow: true
        })
        
        const change = () => {
            obj.isShow = !obj.isShow
        }

        return {
            ...toRefs(obj),
            change
        }
    }
}
</script>

<style>

</style>