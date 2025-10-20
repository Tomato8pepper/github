import axios from "axios";
import { onMounted, reactive } from "vue";


function getData() {
    const obj = reactive({
        dataList: []
    })

    onMounted(() => {
        axios.get('/test.json').then(res => {
            // console.log('===res', res)
            obj.dataList = res.data.list
        })
    })

    return obj
}

function getData1() {
    const obj1 = reactive({
        dataList1: []
    })

    onMounted(() => {
        axios.get('/test1.json').then(res => {
            obj1.dataList1 = res.data.list
        })
    })

    return obj1
}

export { getData, getData1 }