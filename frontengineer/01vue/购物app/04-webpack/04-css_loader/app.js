import imgSrc from './girl.jpg'
export default {
    template: `
        <div>
            <img :src="imgSrc" />
        </div>
    `,
    data() {
        return {
            imgSrc: imgSrc
        }
    }
}