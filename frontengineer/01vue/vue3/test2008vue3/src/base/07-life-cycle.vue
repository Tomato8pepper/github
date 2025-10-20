<template>
  <div>
    life-cycle
    <ul v-if="dataList">
        <li v-for="item in dataList" :key="item" >
            {{item}}
        </li>
    </ul>
  </div>
</template>

<script>
import { onBeforeMount, onMounted, ref } from 'vue'
// beforeCreate   setup
// created        setup
// beforeMount    onBeforeMount
// mounted        onMounted
// beforeUpdate   onBeforeUpdate
// updated        onUpdated
// beforeDestroy  onBeforeUnmount
// destroyed      onUnmounted

export default {
    
    setup() {
        const dataList = ref([])
        onBeforeMount(() => {
            console.log('onBeforeMount')
        })
        onMounted(() => {
            console.log('onMounted', dataList.value)
            setTimeout(() => {
                console.log('end...')
                dataList.value = ['bbb', 'ccc', 'aaa']
            }, 4000)
        })

        return {
            dataList
        }
    }
}
</script>

<style>

</style>