<template>
    <div class="notice">
        <div class="page">
            <p class="p-tit">공지사항</p>
            <router-link :to="{path: `/NoticeWrite`,query:{seq:0}}">
                <button class="btn-write">글쓰기</button>
            </router-link>
            <div class="p-cnt">
                <table class="board_tbl">
                    <caption >게시판 : 번호, 제목, 작성자, 작성일</caption>
                    <colgroup >
                        <col style="width: 100px;"><col >
                        <col style="width: 110px;">
                        <col style="width: 110px;">
                    </colgroup>
                    <thead >
                        <tr >
                            <th scope="col">
                                No
                            </th>
                            <th scope="col">
                                제목
                            </th>
                            <th scope="col" class="writer">
                                작성자
                            </th>
                            <th scope="col">
                                작성일
                            </th>
                        </tr>
                    </thead>
                    <tbody >
<!--                    <tr v-for="i in boardList" :key="i">{{i}}</tr>-->
                    <tr v-for="line in boardList" v-bind:key="line.boardSeq">
                      <td class="num"><span>{{ line.boardseq }}</span></td>
                      <td class="title"><router-link :to="{name: 'noticeDetail', params: {seq: line.boardseq}}"><a>{{line.title}}</a></router-link></td>
                      <td class="writer">{{line.name}}</td>
                      <td>{{line.updateDate.substr(0,10)}}</td>
                    </tr>
<!--                        <tr >-->
<!--                            <td class="num">-->
<!--                                <span >2</span>-->
<!--                            </td>-->
<!--                            <td class="title">-->
<!--                                <router-link :to="{path: `/NoticeDetail`}">-->
<!--                                    <a href="javascript:void(0);">&lt;킹덤 : 레전더리 워&gt; '동영상 조회 수 평가' 안내</a>-->
<!--                                </router-link>-->
<!--                            </td>-->
<!--                            <td class="writer">운영자</td>-->
<!--                            <td >2021-04-27</td>-->
<!--                        </tr>-->
<!--                        <tr >-->
<!--                            <td class="num">-->
<!--                                <span >1</span>-->
<!--                            </td>-->
<!--                            <td class="title">-->
<!--                                <router-link :to="{path: `/NoticeDetail`}">-->
<!--                                    <a href="javascript:void(0);">2021년! 전설이 되어라! &lt;킹덤:Legendary War&gt;</a>-->
<!--                                </router-link>-->
<!--                            </td>-->
<!--                            <td class="writer">-->
<!--                                운영자-->
<!--                            </td>-->
<!--                            <td >-->
<!--                                2021-03-25-->
<!--                            </td>-->
<!--                        </tr>-->
                    <!---->
                    </tbody>
                </table>
                <ul data-v-a3273838="" class="page-nav" style="margin-top: 30px;">
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
export default {
    components: {
        Banner
    },
    data() {
        return {
          boardList:[],
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
    mounted() {
      /*this.axios.get('/api/board/list')
          .then((res=>{this.boardList=res.data; console.log(res.data);}))
          .catch((e)=>console.log(e))*/
      this.loadPage(this.pageNum,true);
      /*
      const params={pageNum:this.pageNum,pageSize:this.size}
      console.log(params);
      this.axios.get("/api/board/pagetest",{params})
          .then((res)=>{
            this.boardList=res.data.list;
            this.navigatepageNums=this.calPages(res.data.pages);
            this.prePage=res.data.prePage;
            this.nextPage=res.data.nextPage;
            this.navigateLastPage=res.data.navigateLastPage;
             console.log(res.data);
           /!* console.log(res.data.list)*!/})
          .catch((e)=>console.log(e))*/

  },methods:{
      calPages(){
        var array=new Array();
        for(var i =0;i<this.pages;i++) {
          array.push(i+1)
        }
        return array;
      },
      // pageArrayCal(param){
      //   var array=new Array();
      //   var a=Math.trunc((param)/(this.size+1));
      //    console.log("a: "+a);
      //
      //   for(var i =0;i<a;i++) {
      //     array.push(i+1)
      //   }
      //   return array;
      // },
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
        this.axios.get("/api/board/page",{params})
            .then((res)=>{
              this.boardList=res.data.list;
              this.pages=res.data.pages;
              this.navigatepageNums=this.calPages();
              this.prePage=res.data.prePage;
              this.nextPage=res.data.nextPage;
              this.navigateLastPage=res.data.pages;
              this.pageNum=res.data.pageNum;
              console.log(this.boardList);
              console.log(typeof(res.data.list));
            })
            .catch((e)=>console.log(e))
      }else{
      this.axios.get("/api/board/page",{params})
          .then((res)=>{
            this.boardList=res.data.list;
            this.prePage=res.data.prePage;
            this.nextPage=res.data.nextPage;
            this.pageNum=res.data.pageNum;
            console.log(res.data);
            /*console.log(res.data.list)*/})
          .catch((e)=>console.log(e))
      }
    }
  }
  // pageLink(){
  //     this.$router.push({path:'noticeWrite',query:{seq:0}})
  // }
}
</script>
<style lang="scss" scoped>
.btn-write {
    position: absolute;
    top: 25px;
    right: 40px;
    box-sizing: border-box;
    appearance: none;
    background-color: transparent;
    border: 2px solid rgb(186,191,206);
    border-radius: 0.6em;
    color: rgb(186,191,206);
    cursor: pointer;
    display: flex;
    align-self: center;
    font-size: 0.875rem;
    font-weight: 600;
    line-height: 1;
    padding: .7em 1.5em;
    text-decoration: none;
    text-align: center;
    text-transform: uppercase;
    font-family: 'Montserrat', sans-serif;
    transition: box-shadow 300ms ease-in-out, color 300ms ease-in-out;
    &:hover,
    &:focus {
        box-shadow: 0 0 40px 40px rgb(186,191,206) inset;
        outline: 0;
        color: rgba(255, 255, 255, 1);
    }
}
.board_tbl {
    color: #000;
    width: 100%;
    font-size: 14px;
    color: #27282d;
    font-weight: 400;
    text-align: center;
    letter-spacing: -.25px;
    border-collapse: collapse;
    caption, legend {
        visibility: hidden;
        width: 0;
        height: 0;
        font-size: 0;
        line-height: 0;
    }
    colgroup col {
        width: auto!important;
    }
    a {
        text-decoration: none;
        outline: none!important;
        color: #2e3037;
    }
    thead tr {
        line-height: 33px;
        border-top: 1px solid rgba(0,0,0,.05);
        border-bottom: 2px solid rgba(0,0,0,.1);
        td {
            &.num {
                color: #8b8b8b;
            }
            &.title {
                text-align: left;
                a {
                    display: inline-block;
                    width: 95%;
                    white-space: nowrap;
                    overflow: hidden;
                    text-overflow: ellipsis;
                }
            }
        }
    }
    tbody tr {
        font-size: 16px;
        line-height: 60px;
        border-bottom: 1px solid rgba(0,0,0,.05);
        &:hover {
            background-color: #f2f2f2;
        }
        td{
            &.num {
                color: #8b8b8b;
            }
            &.title {
                text-align: left;
                a {
                    display: inline-block;
                    width: 95%;
                    white-space: nowrap;
                    overflow: hidden;
                    text-overflow: ellipsis;
                }
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
.notice >.banner {
    margin-top: 70px !important;
}
</style>