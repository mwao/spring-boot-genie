<template>
    <div class="main_visual">
        <h1><a href="#">프로그램명</a></h1>
        <swiper 
            v-bind="swiperOption"
            class="mySwiper"
        >
            <swiper-slide v-for="(mainSwipe, index) in mainSwipes" :key="index">
                <a href=""><img :src= "mainSwipe.thumbnail " alt=""></a>
            </swiper-slide>
        </swiper>
    </div>
</template>
<script>
    // Import Swiper Vue.js components
    import { Swiper, SwiperSlide } from "swiper/vue";
    // import required modules
    import SwiperCore, { Autoplay, Navigation, Pagination } from "swiper";
    SwiperCore.use([Autoplay, Pagination, Navigation]);

    // Import Swiper styles
    import 'swiper/swiper-bundle.css'
    import 'swiper/swiper-bundle.min.css'
    import 'swiper/swiper.min.css'
    import 'swiper/components/navigation/navigation.min.css'
    import 'swiper/components/pagination/pagination.min.css'

    export default {
        data() {
            return {
                mainSwipes: [
                    {
                        thumbnail : '//image.genie.co.kr/ND_F/globalplatform/2022/7/25/7ff334e1-8c44-4eed-bb64-754a60a03977.png',
                    },
                    {
                        thumbnail : '//image.genie.co.kr/ND_F/globalplatform/2022/7/25/79d27a23-cf46-4f15-9a43-9a5119c87467.png',
                    },
                    {
                        thumbnail : '//image.genie.co.kr/ND_F/globalplatform/2022/7/25/d5d27d67-15dc-4e80-8023-0e53b9c375b9.png',
                    },
                    {
                        thumbnail : '//image.genie.co.kr/ND_F/globalplatform/2022/7/25/ff889a39-a861-4c2c-833d-eb568e35f901.png',
                    },
                    {
                        thumbnail : '//image.genie.co.kr/ND_F/globalplatform/2022/7/25/58aeeab0-1619-4270-a77a-9d28c8a34512.png',
                    },
                ],
                swiperOption: {
                    slidesPerView: 1,
                    loop: true,
                    autoplay: {
                        delay: 3000,
                        disableOnInteraction: false,
                    },
                    // 네비게이션
                    navigation: true,
                    // 페이지네이션
                    pagination: {
                        type: 'fraction'
                    }
                }
            }
        },
        components: {
            Swiper,
            SwiperSlide,
        },
        setup() {
            return {
                modules: [Autoplay, Navigation, Pagination],
            };
        },
    };
</script>
<style lang="scss">
    .swiper-pagination-bullets {
        background-color: red !important;
    }
    .main_visual {
        width: 100%;
        height: auto;
        text-align: center;
        margin: 0 auto!important;
        position: relative;
        z-index: 0;
        background: #000 url(//image.genie.co.kr/ND_F/globalplatform/2021/3/22/9aa5ba6b-509b-46a1-93f1-10ab04b0c308.jpg) no-repeat center top;
        background-size: auto;
        h1 {
            width: 100%;
            height: 100%;
            font-size: 0;
            z-index: 2;
        }
        .swiper-pagination {
            bottom: 68px;
            width: 145px;
            left: 50%;
            transform: translateX(-50%);
            text-align: center;
            color: rgb(103, 103, 103);
            font-size: 1.25rem;
            .swiper-pagination-current {
                font-weight: 400;
            }
        }
        .swiper-button-next, .swiper-button-prev {
            top: unset;
            bottom: 70px;
            left: 50%;
        }
        .swiper-button-next {
            margin-left: 25px;
        }
        .swiper-button-prev {
            margin-left: -52px;
        }
    } 
    
    .swiper {
        width: 100%;
        height: 100%;
    }

    .swiper-slide {
        text-align: center;
        font-size: 18px;

        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
    }

    .swiper-slide img {
        display: block;
        width: 100%;
        height: 100%;
        object-fit: cover;
    }

</style>