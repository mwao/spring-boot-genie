<template>
    <div class="lineup">
        <div class="page">
            <p class="p-tit">출연진 소개</p>
            <div class="tabs">
                <div class="tabs__nav">
                    <div class="tabs__nav_tab"
                        v-for="(lineup, index) in lineupLists" :key="index"
                        :class="[index === active ? 'tabs__nav_tab--active' : '']"
                        @click="activate(index)">
                        <!-- Tab {{index + 1}} -->
                        <img :src="lineup.tabOff"/>
                        <img :src="lineup.tabOn"/>
                    </div>
                </div>
            </div>
            <div class="p-cnt">
                <img :src="`${content}`" alt=""/>
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
    props: {
        fillUrl: String,
    },
    data() {
        return {
            active: 0,
            cntImg: 'lineup_01.jpg',
            lineupLists: [
                {
                    name: '비투비',
                    tabOn: '/images/lineup_banner_01_on.png',
                    tabOff: '/images/lineup_banner_01_off.png',
                    content: '/images/lineup_01.jpg',
                },
                {
                    name: '아이콘',
                    tabOn: '/images/lineup_banner_02_on.png',
                    tabOff: '/images/lineup_banner_02_off.png',
                    content: '/images/lineup_02.jpg',
                },
                {
                    name: '에스에프나인',
                    tabOn: '/images/lineup_banner_03_on.png',
                    tabOff: '/images/lineup_banner_03_off.png',
                    content: '/images/lineup_03.jpg',
                },
                {
                    name: '더보이즈',
                    tabOn: '/images/lineup_banner_04_on.png',
                    tabOff: '/images/lineup_banner_04_off.png',
                    content: '/images/lineup_04.jpg',
                },
                {
                    name: '스트레이키즈',
                    tabOn: '/images/lineup_banner_05_on.png',
                    tabOff: '/images/lineup_banner_05_off.png',
                    content: '/images/lineup_05.jpg',
                },
                {
                    name: '에이티즈',
                    tabOn: '/images/lineup_banner_06_on.png',
                    tabOff: '/images/lineup_banner_06_off.png',
                    content: '/images/lineup_06.jpg',
                },
            ], 
        }
    },
    computed: {
        content () {
            return this.lineupLists[this.active].content;
        }
    },
    methods: {
        activate (index) {
            this.active = index;
            console.log(this.lineupLists[this.active]);
        }
    }
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
.lineup >.banner {
    margin-top: 70px !important;
}
.tabs {
  position: relative;
  width:100%;
  box-sizing:border-box;
  &__nav {
    display: flex;
    flex-wrap: wrap;
    margin: 0 -5px;
    &_tab {
        position: relative;
        padding: 5px;
        width: 33.333%;
        background:#fff;
        border-radius:0.5rem 0.5rem 0 0;
        box-shadow:inset 0 -1rem 0.75rem -1rem rgba(0,0,0,0.25);
        cursor:pointer;
        // opacity:0.75;
        transition:100ms linear all;
        &--active {
            opacity:1;
            box-shadow:none;
            img:last-child {
                display: block !important;
            }
        }
        img:last-child {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
            width: fit-content;
            height: fit-content;
            display: none;
        }
    }
  }
  &__content {
    background:#fff;
    padding:1rem;
    border-radius:0 0.5rem 0.5rem 0.5rem;
  }
}
.lineup .p-cnt {
    margin-top: 18px;
}
</style>