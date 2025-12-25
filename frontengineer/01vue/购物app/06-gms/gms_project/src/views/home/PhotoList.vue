<template>
  <div class="photolist">
    <Navbar title="图文分享"></Navbar>
    <div class="video">
      <video src="./video/2.mp4" autoplay controls loop></video>
    </div>
  </div>
</template>

<script>
import Navbar from '../../components/Navbar.vue'
export default {
    components: {
      Navbar
    }
}
</script>

<style scoped>
.video{
  height: 200px;
  padding: 10px;
  background-color: gray;
}
video{
  width: 100%;
  height: 100%;
}
</style>