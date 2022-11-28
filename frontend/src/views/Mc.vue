<template>
    <div class="mc">
        <div class="page">
            <p class="p-tit">MC 소개</p>
            <div class="p-cnt">
                <img src="../../public/images/mc_info.jpg" alt="">
            </div>
        </div>
        <Banner :file="require('../../public/images/banner_lineup.jpg')"></Banner>
    </div>
</template>

<script>
import Banner from "../components/Banner.vue"
export default {
    components: {
        Banner,
    },
}
</script>
<style lang="scss" scoped>
.page {
    position: relative;
    margin: 50px auto 0;
    padding: 0 40px 40px;
    width: 1060px;
    background-color: #fff;
    box-sizing: border-box;
    .p-tit {
        padding: 21px 0;
        text-align: left;
        color: #000;
        font-size: 30px;
        font-weight: 500;
        letter-spacing: -2px;
    }
    .banner {
        padding-bottom: 0 !important;
        a {
            cursor: default;
            display: block;
        }
    }
}
.mc >.banner {
    margin-top: 70px !important;
}
</style>