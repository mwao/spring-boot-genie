<template>
    <div class="frame">
        <h2 class="tit" >{{title}}</h2>
        <swiper
            v-bind="swiperOption"
            class="mySwiper frame-wrap"
        >
            <swiper-slide class="list" >
                <div class="item" v-for="(listSwipes, index) in listSwipes" :key="index">
                    <div class="frame-box">
                        <a href="" class="thumb">
                            <img :src= "listSwipes.thumbnail " alt="">
                            <span class="time">{{listSwipes.time}}</span>
                            <span class="mask">
                                <span class="ic"></span>
                            </span>
                        </a>
                        <div class="desc">
                            <a href="">
                                <span>{{listSwipes.desc}}</span>
                            </a>
                            <span class="date">{{listSwipes.date}}</span>
                        </div>
                    </div>
                </div>
            </swiper-slide>
            <swiper-slide class="list" >
                <div class="item" v-for="(listSwipes, index) in listSwipes" :key="index">
                    <div class="frame-box">
                        <a href="" class="thumb">
                            <img :src= "listSwipes.thumbnail " alt="">
                            <span class="time">{{listSwipes.time}}</span>
                            <span class="mask">
                                <span class="ic"></span>
                            </span>
                        </a>
                        <div class="desc">
                            <a href="">
                                <span>{{listSwipes.desc}}</span>
                            </a>
                            <span class="date">{{listSwipes.date}}</span>
                        </div>
                    </div>
                </div>
            </swiper-slide>
            <swiper-slide class="list" >
                <div class="item" v-for="(listSwipes, index) in listSwipes" :key="index">
                    <div class="frame-box">
                        <a href="" class="thumb">
                            <img :src= "listSwipes.thumbnail " alt="">
                            <span class="time">{{listSwipes.time}}</span>
                            <span class="mask">
                                <span class="ic"></span>
                            </span>
                        </a>
                        <div class="desc">
                            <a href="">
                                <span>{{listSwipes.desc}}</span>
                            </a>
                            <span class="date">{{listSwipes.date}}</span>
                        </div>
                    </div>
                </div>
            </swiper-slide>
        </swiper>
    </div>
</template>

<script src="">

    // Import Swiper Vue.js components
    import { Swiper, SwiperSlide } from "swiper/vue";
    // import required modules
    import SwiperCore, { Navigation, Pagination } from "swiper";
    SwiperCore.use([ Pagination, Navigation]);

    // Import Swiper styles
    import 'swiper/swiper-bundle.css'
    import 'swiper/swiper-bundle.min.css'
    import 'swiper/swiper.min.css'
    import 'swiper/components/navigation/navigation.min.css'
    import 'swiper/components/pagination/pagination.min.css'

    export default {
        props: {
            title: String,
        },
        data() {
            return {
                listSwipes: [
                    {
                        thumbnail : '//image.genie.co.kr//Y/IMAGE/IMG_MUSICVIDEO/000/210/770/210770_1_320x240.JPG',
                        date: "2021.06.03",
                        time : "04:09",
                        desc : "[Full Cam] ♬ 소년의 일기 - 은광, 동혁, 인성, 현재, 승민, 종호 @스페셜 무대",
                    },
                    {
                        thumbnail : '//image.genie.co.kr//Y/IMAGE/IMG_MUSICVIDEO/000/210/769/210769_1_320x240.JPG',
                        date: "2021.06.03",
                        time : "04:55",
                        desc : "[Full Cam] ♬ 피날레 (Show And Prove) - 비투비(BTOB) @파이널 경연",
                    },
                    {
                        thumbnail : '//image.genie.co.kr//Y/IMAGE/IMG_MUSICVIDEO/000/210/768/210768_1_320x240.JPG',
                        date: "2021.06.03",
                        time : "05:12",
                        desc : "[Full Cam] ♬ KINGDOM COME - 더보이즈(THE BOYZ) @파이널 경연",
                    },
                    {
                        thumbnail : '//image.genie.co.kr//Y/IMAGE/IMG_MUSICVIDEO/000/210/767/210767_1_320x240.JPG',
                        date: "2021.06.03",
                        time : "03:53",
                        desc : "[Full Cam] ♬ 열중쉬어 (At ease) - 아이콘(iKON) @파이널 경연",
                    },
                ],
                swiperOption: {
                    slidesPerView: 1,
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
                modules: [Pagination, Navigation],
            };
        },
    };
</script>

<style lang="scss">
.frame {
    width: 980px;
    margin: 0 auto;
    padding-bottom: 56px;
    .tit {
        text-align: left;
        color: rgb(103, 103, 103);
        font-size: 30px;
        font-weight: 300;
        line-height: 60px;
    }
    .frame-wrap {
        position: relative;
        overflow: hidden;
        text-align: center;
        margin: 0 auto;
        vertical-align: middle;
        font-size: 0;
        padding-top: 50px;
        margin-top: -50px;
    }
    .item {
        display: inline-block;
        width: 230px;
        vertical-align: top;
        margin: 0 0 0 19.6px;
        &:first-child {
            margin-left: 0;
        }
        .thumb {
            width: 100%;
            height: 130px;
            display: block;
            position: relative;
            overflow: hidden;
            outline: none;
            &:hover img {
                transform: scale(1.07);
            }
            img {
                width: 100%;
                height: 100%;
                filter: blur(0);
                -webkit-filter: blur(0);
                image-rendering: optimizeSpeed;
                -ms-interpolation-mode: nearest-neighbor;
                transition: transform .3s ease-in-out;
                vertical-align: top;
                object-fit: fill;
            }
            .time {
                position: absolute;
                right: 4px;
                bottom: 4px;
                padding: 0 4px;
                line-height: 18px;
                font-family: arial;
                font-size: 11px;
                color: #fff;
                text-align: center;
                background-color: rgba(0,0,0,.5);
                min-width: 38px;
                height: 18px;
                border-radius: 2px;
            }
        }
    }
    .mask {
        position: absolute;
        width: 100%;
        height: 100%;
        border: 1px solid #000;
        opacity: .1;
        left: 0;
    }
    .desc {
        overflow: hidden;
        padding-top: 5px;
        text-align: left;
        margin: 0;
        line-height: 20px;
        a {
            height: 40px;
            display: block;
            max-height: 40px;
            display: -webkit-box;
            -webkit-line-clamp: 2;
            -webkit-box-orient: vertical;
            word-wrap: break-word;
            overflow: hidden;
            text-overflow: ellipsis;
            text-decoration: none;
            font-family: Spoqa Han Sans;
            font-size: 16px;
            color: #27282d;
            font-weight: 400;
            letter-spacing: -.25px;
            margin: 15px 0 10px;
        }
        span {
                color: rgb(103, 103, 103);
            }
        >span {
            font-size: 14px;
            font-weight: 400;
        }
    }
    .swiper-pagination {
        top: 7px;
        left: unset;
        right: 0;
        width: 107px;
        text-align: center;
        color: rgb(103, 103, 103);
        font-size: 1.25rem;
        .swiper-pagination-current {
            font-weight: 400;
        }
    }
}
.swiper-button-next, .swiper-button-prev {
    position: absolute;
    top: 10px;
    right: auto;
    height: auto;
    margin-top: 0;
    text-align: center;
    background: none;
    cursor: pointer;
    z-index: 100;
    opacity: 1;
    color: rgb(103, 103, 103) !important;
    &::before, &::after {
        font-size: 1.5rem;
        font-weight: 600;
    }
}
.swiper-button-prev {
    left: unset;
    right: 80px;
}
.swiper-button-next {
    right: 0;
}
</style>