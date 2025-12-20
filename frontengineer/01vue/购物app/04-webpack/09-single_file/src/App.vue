<template>
    <div>
        <img src="./girl.jpg" />
    </div>
</template>
<script>

export default{
    data() {
        return {
            msg: 'hello app.vue'
        }
    }
}
</script>
<style>
    body{
        background-color: #aaa;
    }
    img{
        width: 400px;
        height: 600px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }
</style>