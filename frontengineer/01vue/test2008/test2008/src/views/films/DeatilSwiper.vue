<template>
  <div class="swiper-container" :class="name">
    <div class="swiper-wrapper">
        <slot></slot>
    </div>
  </div>
</template>

<script>
import Swiper from 'swiper/bundle'
import 'swiper/swiper-bundle.css'
 
export default {
    props: {
        loop: {
            type: Boolean,
            default: true
        },
        preview: {
            type: Number,
            default: 1
        },
        name: {
            type: String,
            default: 'kerwin'
        }
    },
    mounted() {
        new Swiper('.' +this.name, {
            loop: this.loop,
            slidesPerView: this.preview,
            spaceBetween: 30,
            freeMode: true,
            autoplay: {
                delay: 2500,
                disableOnInteraction: false
            }
        })
    }
}

</script>