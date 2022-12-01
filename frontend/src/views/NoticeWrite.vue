<template>
    <div class="wrtie">
        <div class="page">
            <p class="p-tit">공지사항작성</p>
            <div class="p-cnt">
                <div class="write_wrap">
                    <div class="write_area">
                        <div class="board_tit">
                            <label for="temp_id_1" class="required">제목</label>
                            <input type="text" id="temp_id_1" v-model="boardContents.title">
                        </div>
                        <div class="board_cont">
                            <label for="temp_id_2" class="required">아래 공지사항을 작성해주세요.</label>
                            <textarea cols="30" rows="5" id="temp_id_2" v-model="boardContents.contents"></textarea>
<!--                          <input type="text" style="width:100%;height:200px;" id="temp_id_2">-->
                            <span class="count"><em>0</em> / 3,000자 이하</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="btns">
              <button class="btn btn-regist" v-on:click="btnRegister">등록</button>
              <router-link :to="{path: `/Notice`}">
                <button class="btn btn-cancel">취소</button>
              </router-link>
              <button class="btn btn-delete" v-on:click="btnDelete">삭제</button>
<!--              <router-link :to="{path: `/Notice`}">
                  <button class="btn btn-regist" v-on:click="btnRegister">등록</button>
              </router-link>
                <router-link :to="{path: `/Notice`}">
                    <button class="btn btn-cancel">취소</button>
                </router-link>
              <router-link :to="{path: `/Notice`}">
                <button class="btn btn-delete" v-on:click="btnDelete">삭제</button>
              </router-link>-->
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
            showModal: false,
            boardseq:"",
            boardContents:{}
        }
    },created() {
      this.getBoard()
    },watch:{
      '$route':'getBoard'
    },
    methods:{
      getBoard(){
        if(this.$route.query.seq==0){
          // console.log(this.$route.query.seq);
          this.boardseq=this.$route.query.seq;
          this.boardContents.name="Admin";
          console.log(this.boardseq);
        }else{
          this.axios.get('/api/board/view',{params:{boardseq:this.$route.query.seq}})
              .then((res=>{this.boardContents=res.data;
                console.log(this.boardContents);

              }))
              .catch((e)=>console.log(e))
        }
      },
      btnRegister(){
        if(confirm("등록하시겠습니까?")){
          this.axios.post('/api/board/write',{
            boardseq:this.boardContents.boardseq,
            title:this.boardContents.title,
            contents:this.boardContents.contents,
            name:this.boardContents.name,
            deleteYn:"N"
          });
          location.href="/Notice";
        }else{
          return false;
        }

      },btnDelete(){
        if(confirm("삭제하시겠습니까?")){
          this.axios.post('/api/board/write',{
            boardseq:this.boardContents.boardseq,
            title:this.boardContents.title,
            contents:this.boardContents.contents,
            name:this.boardContents.name,
            deleteYn:"Y"
          });
          location.href="/Notice";
        }else{
          return false
        }
      }

  }
}
</script>
<style lang="scss" scoped>
.btns {
    margin-top: 3rem;
    text-align: center;
    .btn {
        margin: 0 0.5rem;
        height: 38px;
        cursor: pointer;
        display: inline-block;
        width: auto;
        box-sizing: border-box;
        appearance: none;
        background-color: transparent;
        border: 2px solid rgb(28,30,38);
        border-radius: 0.6em;
        color: rgb(28,30,38);
        cursor: pointer;
        font-size: 1rem;
        font-weight: 600;
        line-height: .15;
        padding: 1em 2em;
        text-decoration: none;
        text-align: center;
        text-transform: uppercase;
        font-family: 'Montserrat', sans-serif;
        transition: box-shadow 300ms ease-in-out, color 300ms ease-in-out;
        &:hover,
        &:focus {
            box-shadow: 0 0 40px 40px rgb(28,30,38) inset;
            outline: 0;
            color: rgb(217,220,232);
        }
        &.btn-cancel {
            border-color: rgb(186,191,206);
            color: rgb(186,191,206);
            &:hover,
            &:focus {
                box-shadow: 0 0 40px 40px rgb(186,191,206) inset;
                color: rgba(255, 255, 255, 1);
            }
        }
    }
}
.write_wrap {
    input[type=text], textarea {
        display: block;
        width: 100%;
        height: 38px;
        padding: 6px 10px;
        appearance: none;
        box-shadow: none;
        box-sizing: border-box;
        border: 2px solid #eae9e9;
        border-radius: 0;
        color: rgb(17, 18, 24);
        background-color: rgb(255, 255, 255);
        font-size: 1rem;
        font-family: "Spoqa Han Sans", -apple-system, BlinkMacSystemFont, "Malgun Gothic", "Segoe UI", Roboto, Oxygen, Ubuntu, Cantarell, "Fira Sans", "Droid Sans", "Helvetica Neue", "Noto Sans KR", sans-serif;
    }
    label {
        display: block;
        margin: 0.7rem 0;
        color: #333;
        font-weight: 400;
        &.required:after {
            content: "*";
            color: #f5457b;
            font-weight: 600;
        }
    }
    textarea {
        min-height: 3rem;
    }
}
.board_tit {
    font-family: Spoqa Han Sans;
    color: #000;
    font-size: 16px;
    color: #27282d;
    line-height: 24px;
    border-top: 2px solid #e5e5e5;
    text-align: left;
}
.board_cont {
    position: relative;
    font-family: Spoqa Han Sans;
    color: #000;
    display: block;
    font-size: 16px;
    border: solid #f2f2f2;
    border-width: 1px 0;
    padding-top: 15px !important;
    word-break: break-word;
    text-align: left;
    > textarea {
        height: 9.6rem;
        padding: 1.6rem 2rem;
    }
    .count {
        position: absolute;
        bottom: 0;
        right: 0;
        margin: 0 2rem 1rem 0;
        color: #ababab;
        font-weight: 300;
        font-size: .875rem;
        pointer-events: none;
        > em {
            font-style: normal;
        }
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
.wrtie >.banner {
    margin-top: 70px !important;
}
</style>