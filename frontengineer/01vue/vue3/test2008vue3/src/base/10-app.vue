<template>
    <div>
        <ul>
            <li v-for="item in obj.dataList" :key="item.name" >
                {{item.name}}
            </li>
        </ul>
        <ul>
            <li v-for="item in obj1.dataList1" :key="item.title" >
                {{item.title}}
            </li>
        </ul>
    </div>
</template>

<script>
import { getData, getData1 } from './module/app.js'
export default {
    setup() {
        const obj  = getData()
        const obj1 = getData1()
        console.log('obj', obj)
        console.log('obj1', obj1)

        return {
            obj,
            obj1
        }
    }
}
</script>

<style>

</style>