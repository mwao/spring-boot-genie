<template>
    <div class="mini-header">
        <div class="mini-header-inner">
          <a href="#" title="지니홈 바로가기 새창열기" class="home">지니홈 바로가기</a>
          <ul>
            <li>
              <a href="#" target="_blank" title="회원가입 새창열기">회원가입</a>
            </li>
            <li>
              <a href="#" title="로그인">로그인</a>
            </li>
          </ul>
        </div>
      </div>
      <Banner :file="require('../../public/images/main_logo.png')" :className="`banner header-banner`"></Banner>
      <div ref="nav" class="nav">
        <ul class="nav-inner">
            <li v-for="(gnb, index) in gnbLists" :key="index">
                <router-link :to="`/${gnb.link}`">
                    <span>{{ gnb.name }}</span> 
                </router-link>
            </li>
        </ul>
      </div>
</template>

<script>
import Banner from "./Banner.vue"

export default {
    components: {
        Banner,
    },
    data() {
        return {
            showNavbar: true,
            lastScrollPosition: 0,
            gnbLists: [
                {
                name: '프로그램 소개',
                link: 'program',
                },
                {
                name: 'MC소개',
                link: 'mc',
                },
                {
                name: '출연진 소개',
                link: 'lineup',
                },
                {
                name: '다시보기',
                link: 'clip',
                },
                {
                name: '공지사항',
                link: 'notice',
                },
            ],
        }
    },
    mounted () {
        window.addEventListener('scroll', this.handleScroll)
        console.log('scrolling Injected')
    },
    beforeUnmount () {
        window.removeEventListener('scroll', this.handleScroll)
        console.log('scrolling Destroyed')
    },
    methods: {
        handleScroll () {
            let st = window.pageYOffset || document.documentElement.scrollTop
            console.log('scrolling..', st, this.$refs)
            let navEl = this.$refs.nav

            if (navEl.offsetTop < st) {
                navEl.className = 'nav fixed'
            } else {
                navEl.className = 'nav'
            }
        }

   },
}
</script>

<style lang="scss" scoped>
.mini-header {
    display: block;
    width: 100%;
    padding: 5px;
    background-color: #000;
    box-sizing: border-box;
    &-inner {
        width: 1018px;
        height: 30px;
        margin: auto;
        text-align: left;
        line-height: 30px;
        > a {
        float: left;
        width: 30px;
        &:hover {
            background-position: 0 -30px;
        }
        }
        a {
        height: 30px;
        background: url(//image.genie.co.kr/imageg/web/promo_2019/template/mini_gnb_20201014.png) no-repeat 0 0;
        font-size: 0;
        }
        ul {
        margin: 0;
        float: right;
        list-style: none;
        li {
            float: left;
            line-height: 28px;
            &:last-child {
            a::before {
                content: "";
                display: inline-block;
                width: 1px;
                height: 12px;
                background-color: #333;
                margin: 0 10px;
            }
            }
            a {
            display: inline-block;
            font-size: 12px;
            color: grey;
            background: none;
            text-decoration: none;
            &:hover {
                color: #fff;
            }
            }

        }
        }
    }
}
.header-banner {
    padding: 30px 0;
    width: 100%;
    background-image: url(//image.genie.co.kr/ND_F/globalplatform/2021/3/22/1884cc37-9bc0-4054-ad35-e826bb8855c0.jpg);
    background-size: auto;
    background-repeat: no-repeat;
    background-position: center top;
    background-color: rgb(3, 4, 6);
    &-inner {
        width: 980px;
        margin: 0 auto!important;
    }
}
.nav {
    display: block;
    width: 100%;
    margin-top: 0!important;
    position: relative;
    background-color: rgba(0,0,0,.2);
    box-sizing: border-box;
    z-index: 50;
    transition: all .4s;
    &.fixed {
        background-color: #ccc;
        position: sticky;
        top: -1px;
        z-index: 2;
    }
    >ul {
        display: flex;
        justify-content: space-between;
        width: 1020px;
        height: 70px;
        margin: auto;
        text-align: center;
        z-index: 0;
        >li {
            flex: 1;
            &.active, &.on, &:hover {
                border-bottom: 3px solid #fff;
            }
            span {
                display: inline-block;
                width: 100%;
                height: 70px;
                font-size: 22px;
                color: inherit;
                line-height: 70px;
                box-sizing: border-box;
                color: #fff;
            }
        }
    }
}
</style>