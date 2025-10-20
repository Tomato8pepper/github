<template>
  <div>
    <input type="text" ref="mytext"/>
    <button @click="handleAdd">Add</button>

    <ul>
      <li v-for="(item, index) in datalist" :key="item" >
        {{item}}<button @click="handleDel(index)">del</button>
      </li>
    </ul>
  </div>
</template>

<script>
import { ref } from 'vue'
export default {
     

    setup() {
        const mytext = ref()

        const datalist = ref(['111', '222'])

        const handleAdd = () => {
            /* mytext.value = 'xiaoming' */
            if(mytext.value.value) datalist.value.push(mytext.value.value)
            mytext.value.value = ''
        }

        const handleDel = (index) => {
          datalist.value.splice(index, 1)
        }
        
        return {
            mytext,
            datalist,
            handleAdd,
            handleDel
        }
    }
}
</script>

<style>

</style>