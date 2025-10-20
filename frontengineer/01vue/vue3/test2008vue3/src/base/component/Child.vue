<template>
  <div>
    <button @click="handleClick">left</button>
    {{myname}}
    <button>right</button>
  </div>
</template>

<script>
export default {
    props: ['myname'],
    // mounted() {
    //     console.log(this.myname)
    // },

    setup(props, { emit }) {
        console.log(props)
        props.myname

        const handleClick = () => {
            emit('event')
        }

        return {
            handleClick
        }
        
    }
}
</script>

<style>

</style>