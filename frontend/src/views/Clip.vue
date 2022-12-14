<template>
<!--    <div class="loading" >-->
<!--        <Loading />-->
<!--    </div>-->
    <div class="clip" >
        <div class="page">
            <p class="p-tit">다시보기</p>
            <div class="p-cnt">
                <div class="fp-recom_box" v-for="(clip, index) in Lists" :key="index" >
                    <a :href="clip.playUrl" class="thumb" target="_blank">
                        <img :src="clip.thumbnail" :alt="clip.title">
<!--                        <span class="time">{{clip.time}}</span>-->
                        <span class="mask">
                            <span class="ic"></span>
                        </span>
                    </a>
                    <div class="desc">
                        <a :href="clip.playUrl" >
                            <span class="ellipsis">{{clip.title}}</span>
                            <p class="ellipsis">
                                {{clip.description}}<br><br>전설이 되어라, WHO IS THE KING?<br>＜킹덤(KINGDOM : LEGENDARY WAR)＞
                            </p>
                        </a>
                        <span class="date">{{ clip.updateDate.substr(0,10) }}</span>
                    </div>
                </div>
                <ul class="page-nav">
                  <li class="disabled "><a tabindex="-1" class="page-btn" id="1" @click.stop="pageBtn(1)">＜＜</a></li>
                  <li class="disabled"><a tabindex="-1" class="page-btn" :id="this.prePage" @click.stop="pageBtn(this.prePage)">＜</a></li>
                  <li v-for="item in navigatepageNums" :key="item" :class="[item===this.pageNum?'current':'disabled']"><a tabindex="0" :id="item" @click.stop="pageBtn(item)">{{ item }}</a></li>
                  <li class="disabled"><a tabindex="-1" class="page-btn" :id="this.nextPage"  @click.stop="pageBtn(this.nextPage)">＞</a></li>
                  <li class="disabled"><a tabindex="-1" class="page-btn" :id="this.navigateLastPage" @click.stop="pageBtn(this.navigateLastPage)">＞＞</a></li>

                </ul>
            </div>
        </div>
        <Banner :file="require('../../public/images/banner_notice.jpg')"></Banner>
    </div>
</template>

<script>
import Banner from "../components/Banner.vue"
// import Loading from "../components/Loading.vue"
export default {
    components: {
        Banner
      // , Loading
    },
    data() {
        return {
            clipLists: [
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
                {
                    thumbnail : '//image.genie.co.kr//Y/IMAGE/IMG_MUSICVIDEO/000/210/770/210770_1_320x240.JPG',
                    date: "2021.06.03",
                    time : "04:09",
                    desc : "[Full Cam] ♬ 소년의 일기 - 은광, 동혁, 인성, 현재, 승민, 종호 @스페셜 무대",
                },

            ],
            Lists:[],
            pageNum:1,
            size:5,
            pages:1, // 총 페이지
            prePage:0,
            nextPage:2,
            navigatepageNums:[], // 총 페이지 어레이
            navigateLastPage:1, //마지막 페이지 넘버
            isLastPage:true,
            pageArray:[] // 변형 어레이
        }
    },
    mounted () {
      // this.axios.get('/api/clip/list')
      //     .then( (res) =>{
      //       // that.clipLists = res.data.data
      //       // this.apiClipLists=res.data;
      //
      //       console.log(res.data);
      //       this.Lists=res.data;
      //       console.log(this.Lists);
      //     })
      //     .catch(function (error) {
      //       console.log(error)
      //     })
      this.loadPage(this.pageNum,true);

    },
  methods:{
      calPages(){
        var array=new Array();
        var calPage=Math.floor((this.pageNum-1)/10); // 1-10 : 0 , 11-20 : 1
        var lastArrPage=0;  // array 의 마지막 숫자

        //paging array 의 마지막 숫자 계산
        if(((calPage+1)*10)>this.pages) {
          lastArrPage = this.pages;
        }else{
          lastArrPage=((calPage+1)*10);
        }

        //paging array생성
        for(var i =(calPage*10+1);i<=lastArrPage;i++) {
          array.push(i)
        }
        return array;
    },
    pageBtn(param){
      if(param!==this.pageNum) {
        // console.log("param: "+param);
        // console.log("this.pageNum: "+this.pageNum);
        this.loadPage(param,false);
        console.log("pageBtn: "+param);
      }
    },
    loadPage(param,first) {
      const params={pageNum:param,pageSize:this.size}
      //console.log(params);
      if(first){
        this.axios.get("/api/clip/page",{params})
            .then((res)=>{
              this.Lists=res.data.list;
              this.pages=res.data.pages;
              this.prePage=res.data.prePage;
              this.nextPage=res.data.nextPage;
              this.navigateLastPage=res.data.pages;
              console.log("navigateLastPage: "+this.navigateLastPage );
              this.pageNum=res.data.pageNum;
              this.navigatepageNums=this.calPages();
              console.log(this.Lists);
              console.log(typeof(res.data.list));
            })
            .catch((e)=>console.log(e))
      }else{
        this.axios.get("/api/clip/page",{params})
            .then((res)=>{
              this.Lists=res.data.list;
              this.prePage=res.data.prePage;
              this.nextPage=res.data.nextPage;
              this.pageNum=res.data.pageNum;
              this.navigatepageNums=this.calPages();
              console.log(res.data);
              /*console.log(res.data.list)*/})
            .catch((e)=>console.log(e))
      }
    }
  }

    //     window['$']('#videoTopView').initPOCPlayer({
    //         // memberid: 'lifestyler',
    //         // idpath: '286840',
    //         serviceid: 'tvn',
    //         clipid: 'EA_206457',
    //         isfullvod: 'N',
    //         autoplay: 'Y',
    //         ismobile: 'Y',
    //         istitle: 'N',
    //         ischarge: 'N',
    //         ispay: 'N',
    //         usead: 'Y',
    //         pocVODState: 0,
    //         // Inspection : '',
    //         configPath: '/VOD/getFlashVodconfig',
    //         pocVODReturn: 'http://tvn.m.tving.com/tvn/Data/ReturnVod'
    //     })
    // },

}
</script>
<style lang="scss" scoped>
.fp-recom_box {
    width: 100%;
    padding: 16px 0;
    margin: 0;
    .thumb {
        position: relative;
        overflow: hidden;
        display: inline-block;
        width: 130px;
        height: 100px;
        img{
            width: 100%;
            height: 100%;
            filter: blur(0);
            -webkit-filter: blur(0);
            image-rendering: optimizeSpeed;
            image-rendering: -moz-crisp-edges;
            image-rendering: -o-crisp-edges;
            image-rendering: -webkit-optimize-contrast;
            image-rendering: optimize-contrast;
            -ms-interpolation-mode: nearest-neighbor;
            transition: transform .3s ease-in-out;
            -webkit-transition: transform .3s ease-in-out;
            -moz-transition: transform .3s ease-in-out;
            vertical-align: top;
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
        .mask {
            width: 180px;
            position: absolute;
            width: 100%;
            height: 100%;
            border: 1px solid #000;
            opacity: .1;
            left: 0;
        }
    }
    .desc {
        overflow: hidden;
        text-align: left;
        margin: 0;
        line-height: 20px;
        display: inline-block;
        width: 780px;
        padding-top: 0;
        margin-left: 20px;
        a {
            display: block;
            display: -webkit-box;
            -webkit-line-clamp: 2;
            text-decoration: none;
            font-family: Spoqa Han Sans;
            font-size: 16px;
            color: #27282d;
            font-weight: 400;
            letter-spacing: -.25px;
            display: block;
            max-height: 64px;
            -webkit-box-orient: unset;
            word-wrap: break-word;
            overflow: visible;
            text-overflow: unset;
            margin: 6px 0 2px;
            >span {
                display: block;
                max-height: 20px;
                line-height: 20px;
                font-weight: 700;
            }
            >p {
                max-height: 40px;
                font-size: 14px;
                color: #8b8b8b;
                line-height: 20px;
                display: -webkit-box;
                -webkit-line-clamp: 2;
                -webkit-box-orient: vertical;
                word-wrap: break-word;
                white-space: normal;
                margin: 5px 0;
            }
            .ellipsis {
                width: 100%;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    padding-right: 1px;
            }
        }
    }
}

.page-nav {
    min-height: 25px;
    text-align: center;
    margin: 0 0 10px;
    position: relative;
    li {
        display: inline-block;
        width: 25px;
        height: 25px;
        vertical-align: middle;
        text-align: center;
        font: normal 12px/23px Tahoma,Helvetica,sans-serif;
        color: #666;
        border: 1px solid #ccc;
        &:first-child {
            background-position: 0 50%;
        }
        &:nth-child(2) {
            background-position: -23px 50%;
        }
        &:last-child {
            background-position: -69px 50%;
        }
        &:nth-last-child(2) {
            background-position: -46px 50%;
        }
        &:hover {
            border-color: #9f9f9f;
            background-color: rgba(0,0,0,.07);
        }
    }
    >li:first-child, >li:last-child, >li:nth-child(2), >li:nth-last-child(2) {
        font: 0/0 a;
        background-image: url(/images/pageing.gif);
        background-repeat: no-repeat;
    }
    li+li {
        margin-left: 5px;
    }
    .current {
        border-color: #000;
        font-weight: 700;
        color: #000;
        &:hover {
            background-color: #fff;
            border-color: #000;
        }
    }
    a {
        display: block;
        width: 100%;
        height: 100%;
        cursor: pointer;
    }
}
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
.clip >.banner {
    margin-top: 70px !important;
}
</style>