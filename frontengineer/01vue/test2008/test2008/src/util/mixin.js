var obj = {
    created() {
        console.log('hide')
        this.$store.commit('hide')
    },
    destroyed() {
        this.$store.commit('show')
    }
}

export default obj