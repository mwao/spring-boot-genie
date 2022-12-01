<template>
    <div class="detail">
        <div class="page">
            <p class="p-tit">공지사항</p>
            <div class="p-cnt">
                <div class="board_wrap">
                    <!---->
                    <div class="detail_area">
                        <div class="board_tit">
                            <h3>&lt;킹덤 : 레전더리 워&gt; '동영상 조회 수 평가' 안내</h3>
                            <dl>
                                <dt>작성자</dt>
                                <dd>{{boardContents.name}}</dd>
                            </dl>
                            <dl>
                                <dt>등록일</dt>
                                <dd>{{boardContents.updateDate}}</dd>
                            </dl>
                        </div>
                        <div class="board_cont ql-editor">
                            <p class="ql-align-center">
                                <span style="color: black;">{{boardContents.contents}}</span>
<!--                                <span style="color: black;">{{seq}}</span>-->
                            </p>
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">Mnet &lt;킹덤 : 레전더리 워&gt; 에 보내주시는 관심과 애정에 깊은 감사의 말씀 드립니다.</span>-->
<!--                            </p>-->
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">&nbsp;</span>-->
<!--                            </p>-->
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">&lt;킹덤 : 레전더리 워&gt;의 '동영상 조회수 평가' 집계와 관련해 안내 드립니다..</span>-->
<!--                            </p>-->
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">&nbsp;</span>-->
<!--                            </p>-->
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">- 동영상 조회수 평가는 유튜브 Mnet K-POP 채널(</span><a href="http://www.youtube.com/Mnet" rel="noopener noreferrer" target="_blank" style="color: black;">www.youtube.com/Mnet</a><span style="color: black;">)에게시된 '퍼포먼스 풀버전 영상' 조회수만 반영됩니다.</span>-->
<!--                            </p>-->
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">- 모든 퍼포먼스는 방송에 공개된 후 '퍼포먼스 풀버전 영상'이 업로드될 예정이며, 해당 주차 방송에 공개된 동영상에 한해 동일한 기간과 시간동안 조회수가 집계될 예정입니다.</span>-->
<!--                            </p>-->
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">- YouTube 동영상 캠페인 프로모션으로 유입된 영상 조회수 및 각종 어뷰징으로 인한 조회수는 '동영상 조회 수 평가' 집계에 포함되지 않습니다.</span>-->
<!--                            </p>-->
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">&nbsp;</span>-->
<!--                            </p>-->
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">앞으로도 &lt;킹덤 : 레전더리 워&gt;에 많은 관심 부탁드립니다.</span>-->
<!--                            </p>-->
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">&nbsp;</span>-->
<!--                            </p>-->
<!--                            <p class="ql-align-center">-->
<!--                                <span style="color: black;">감사합니다.</span>-->
<!--                            </p>-->
                        </div>
                    </div>
                    <div class="btn_wrap">
                        <router-link :to="{path: `/Notice`}">
                            <a href="javascript:void(0);" class="btn white left">목록</a>
                        </router-link>
                      <router-link :to="{path: `/NoticeWrite`,query:{seq:this.$route.params.seq}}">
                        <a href="javascript:void(0);" class="btn white right">수정</a>
                      </router-link>
                    </div>
                    <div style="margin-top: 30px;">
                        <section class="reply" style="margin-bottom: 0px;">
                        <div class="comment-title tit-box">
                            <h3 style="font-family: &quot;Spoqa Han Sans&quot;;">댓글</h3>
                            <span class="article">총 <strong>0</strong>개</span>
                            <p class="btn_wrap">
                                <button @click="showModal = true" class="def-btn">게시물 운영 정책</button>
                            </p>
                        </div>
                        <div class="input-comment">
                            <fieldset class="comment">
                                <legend>리뷰 쓰기</legend><textarea maxlength="110" title="리뷰 내용 입력" placeholder="리뷰는 최대 110자까지 쓸 수 있습니다." class="textarea"></textarea><button type="button" class="btn-submit">등록</button>
                            </fieldset>
                        </div>
                        <article class="list-comment">
                        <ul>
                        </ul>
                        </article></section>
                        <!---->
                        <transition name="fade" appear>
                            <div class="layer-dim" v-if="showModal"></div>
                        </transition>
                        <transition name="pop" appear>
                            <div id="ly-policy" class="tmpl_layer" v-if="showModal">
                                <div class="layer-header">
                                    <h3>게시물 운영 정책</h3>
                                    <button @click="showModal = false" title="닫기" class="layer-close">닫기</button>
                                </div>
                                <div class="layer-content">
                                    <div class="layer-info">
                                        <strong class="check">지니에서는 아래와 같은 운영 원칙을 적용합니다.</strong>
                                        <dl>
                                            <dt>댓글 숨김</dt>
                                            <dd>타인에 의하여 5회이상 신고가 접수 된 댓글의 경우, 해당 게시글 접근을 임시적으로 차단하는 조치를 할 수 있습니다.</dd><dd>숨김 처리된 댓글의 작성자가 복원 신청을 할 경우 심의 결과에 따라 삭제 또는 복원 될 수 있습니다.</dd>
                                            <dt>댓글 삭제</dt>
                                            <dd>사용자들의 신고 또는 관리자에 의해 아래에 해당하는 내용이 포함 된댓글이 발견 되었을시, 예고없이 삭제 조치를 하겠습니다.</dd><dd class="nodot">
                                            ① 타인의 명예를 손상시키거나 불이익을 주는 행위<br>
                                            ② 음란물을 게재, 공개하거나 음란 사이트를 연결하는 행위<br>
                                            ③ 욕설, 비속어 사용 및 특정대상을 비하하는 행위<br>
                                            ④ 공공질서 및 미풍양속에 위반되는 내용의 정보, 문장, 도형 등을 타인에게 유포하는 행위<br>
                                            ⑤ 상업적 광고 또는 사이트/홈피를 홍보하는 행위<br>
                                            ⑥ 같은 내용의 글을 반복적으로 작성하는 행위<br>
                                            ⑦ 지역 감정 및 정치적으로 민감한 내용으로 회원들간의 분란을 야기하는 행위<br>
                                            ⑧ 기타 관련 법률 및 약관에 위배되는 글을 작성하는 행위 </dd>
                                            <dt>이용 제한</dt>
                                            <dd>관리자에 의하여 3회 이상 삭제 당하였거나, 지속적으로 악의적인 댓글을 작성한 사용자는 댓글 작성 기능에 제한을 받습니다. </dd><dd>제한 기간은, 작성한 글의 내용과 상습적인지 판단하여 결정합니다.</dd>
                                            <dt>신고 제한</dt>
                                            <dd>타인이 작성한 댓글에 허위신고를 하는 사용자는 신고 횟수 제한과 같은 제재를 받을 수 있습니다.</dd>
                                            <dt>관련 문의</dt>
                                            <dd>고객센터 &gt; 문의하기</dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="layer-footer">
                                    <button @click="showModal = false" type="button" title="확인" class="layer-close"><span>확인</span></button>
                                </div>
                            </div>
                        </transition>
                    </div>
                </div>
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
            boardContents:{}
        }
    },computed:{
      seq(){
        return this.$route.params.seq
      }
    },mounted(){
    this.axios.get('/api/board/view',{params:{boardseq:this.$route.params.seq}})
        .then((res=>{this.boardContents=res.data; console.log(res.data);}))
        .catch((e)=>console.log(e))

  }
}
</script>
<style lang="scss" scoped>

/* ---------------------------------- */
.fade-enter-active, .fade-leave-active {
  transition: opacity .4s linear;
}
.fade-enter-from, .fade-leave-to {
  opacity: 0;
}
.fade-enter-to, .fade-leave-from {
  opacity: 1;
}
.pop-enter-active, .pop-leave-active {
  transition: transform 0.4s cubic-bezier(0.5, 0, 0.5, 1), opacity 0.4s linear;
}
.pop-enter-from, .pop-leave-to {
  opacity: 0;
  transform: scale(0.3) translateY(-50%);
}
.pop-enter-to, .pop-leave-from {
  opacity: 1;
  transform: scale(1) translateY(0);
}
/* ---------------------------------- */
.layer-dim {
    content: '';
    position: absolute;
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    z-index: 998;
    background: #000;
    opacity: 0.6;
    cursor: pointer;
}
.tmpl_layer {
    position: absolute;
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    margin: auto;
    text-align: center;
    width: fit-content;
    height: fit-content;
    max-width: 468px;
    box-shadow: 0 5px 5px rgba(0, 0, 0, 0.2);
    background: #FFF;
    z-index: 999;
    // transform: none;
    .layer-header, .layer-content {
        z-index: 10;
    }
    .layer-header {
        position: relative;
        height: 62px;
        background-color: #05b5e5;
        padding: 0;
        text-align: left;
        border: 0;
        h3 {
            margin: 0 0 0 25px;
            display: inline-block;
            line-height: 59px;
            color: #fff;
            font-size: 22px;
            font-weight: 700;
        }.layer-close {
            position: absolute;
            top: 16px;
            right: 20px;
            width: 30px;
            height: 30px;
            background: url(//image.genie.co.kr/imageg/web/promo_2019/template/btn_close_tmpl.png) no-repeat;
            font-size: 0;
            line-height: 0;
            text-indent: -9999px;
        }
    }
    .layer-content {
        background-color: #fff;
        padding: 30px 0;
        font-size: 20px;
        text-align: center;
        color: #888;
        max-height: 520px;
        overflow: auto;
        border-left: 1px solid #e5e5e5;
        min-height: 154px;
        line-height: 92px;
        border-right: 1px solid #e5e5e5;
        .layer-info {
            background-color: #fff!important;
            text-align: left;
            font-size: 14px;
            line-height: 16px;
            padding: 0 10px 0 20px;
            color: #262626;
            .check {
                padding-bottom: 20px;
                padding-right: 20px;
                display: block;
                font-size: 26px;
                font-weight: 400;
                color: #00b5e5;
                line-height: 36px;
                vertical-align: middle;
            }
            dl {
                padding: 7px 20px 0 0;
                word-break: keep-all;
                line-height: 28px;
            }
            dt {
                padding-top: 12px;
                font-size: 17px;
                font-weight: 700;
                color: #000;
                &:first-child {
                    padding: 0;
                }
            }
            dd {
                position: relative;
                padding-left: 12px;
                font-size: 16px;
                font-weight: 400;
                color: #7e858b;
            }
        }
    }
    .layer-footer {
        position: relative;
        height: 65px;
        background-color: #f7f7f7;
        border-top: 1px solid #dedede;
        button {
            display: block;
            color: #262626;
            width: 100%;
            height: 64px;
            font-weight: 700;
            background-color: #f7f7f7;
            text-indent: 0;
            box-sizing: border-box;
            font-size: 22px;
            position: relative;
            span {
                position: absolute;
                top: 0;
                left: 0;
                line-height: 62px;
                width: 100%;
                text-align: center;
            }
        }
    }
}

.board_tit {
    font-family: Spoqa Han Sans;
    color: #000;
    display: flex;
    justify-content: space-between;
    font-size: 16px;
    color: #27282d;
    line-height: 24px;
    border-top: 2px solid #e5e5e5;
    padding: 14px 30px 15.5px;
    h3 {
        display: none;
    }
    dl dt {
        color: #8b8b8b;
        padding-right: 22px;
    }
    dl>* {
        display: inline;
    }
}
.board_cont {
    font-family: Spoqa Han Sans;
    color: #000;
    display: block;
    font-size: 16px;
    border: solid #f2f2f2;
    border-width: 1px 0;
    padding: 30px !important;
    word-break: break-word;
}
.ql-editor {
    box-sizing: border-box;
    line-height: 1.42;
    height: 100%;
    outline: none;
    overflow-y: auto;
    padding: 12px 15px;
    -o-tab-size: 4;
    tab-size: 4;
    -moz-tab-size: 4;
    text-align: left;
    white-space: pre-wrap;
    word-wrap: break-word;
    font-size: 1rem;
    >* {
        cursor: text;
    }
    blockquote, h1, h2, h3, h4, h5, h6, ol, p, pre, ul {
        margin: 0;
        padding: 0;
        counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;
    }
    .ql-align-center {
        text-align: center;
    }
}
.btn_wrap {
    position: relative;
    text-align: right;
    z-index: 1;
    &::after {
        display: block;
        content: "";
        clear: both;
    }
    .btn {
        display: inline-block;
        width: 103px;
        height: 36px;
        background-color: #27282d;
        border: 1px solid #27282d;
        border-radius: 2px;
        font-family: Spoqa Han Sans,HelveticaNeue-Light,AppleSDGothicNeo-Light,sans-serif;
        font-size: 16px;
        color: #fff;
        text-align: center;
        vertical-align: middle;
        line-height: 34px;
        margin-top: 30px;
        &.white {
            background-color: #fff;
            border: 1px solid rgba(0,0,0,.3);
            color: #8b8b8b;
        }
    }
    .left {
        float: left;
    }
}
.reply {
    font-family: Spoqa Han Sans;
    margin: 0 auto 50px;
    .btn_wrap {
        width: auto;
        float: right;
    }
    .input-comment {
        padding: 1.0625em 1em 1em;
        background-color: rgba(0,0,0,.05);
        border-bottom: 0.0625em solid #eef1f4;
    }
    .comment {
        position: relative;
        text-align: left;
    }
    .textarea {
        overflow: hidden;
        height: 2.857142857142857em;
        min-height: 2.857142857142857em;
        padding: 0.6666666666em 3.642857142857em 0.6666666666em 0.8095238095238em;
        resize: none;
        font-family: Spoqa Han Sans;
    }
    .btn-submit {
        display: block;
        position: absolute;
        top: 0;
        bottom: 0;
        right: 0;
        width: 3.1875em;
        line-height: 0;
        text-indent: -9999px;
        z-index: 9;
        &::before {
            content: "";
            display: block;
            position: absolute;
            top: 50%;
            left: 1.0416666666em;
            width: 1.125em;
            height: 1.125em;
            margin-top: -0.5625em;
            background: url(//image.genie.co.kr/imageg/web/promo_2019/template/blt_reply.png) no-repeat 0 0;
            background-size: 5em auto;
        }
    }
    .list-comment>ul {
        border-top: 0.056em solid rgba(0,0,0,.05);
    }
}
button {
    padding: 0;
    border: none;
    background: none;
    font-size: inherit;
    line-height: 1.567em;
    letter-spacing: -.035em;
    cursor: pointer;
    outline: none;
}
fieldset, img {
    border: 0;
    outline: none;
}
caption, legend {
    visibility: hidden;
    width: 0;
    height: 0;
    font-size: 0;
    line-height: 0;
}
.textarea {
    display: inline-block;
    width: 100%;
    height: 4em;
    font-size: .875rem;
    line-height: 1.42857142857em;
    border: 0.07142857em solid #d7dbde;
    border-radius: 0.142857142857em;
    padding: 0.3333333333em 0.523809523809em;
    -webkit-appearance: none;
}
.comment-title {
    position: relative;
    margin-bottom: 10px;
    text-align: left;
}
.def-btn {
    display: inline-block;
    font-size: 13px;
    color: #8b8b8b;
    line-height: 26px;
    background-color: #fff;
    border-radius: 2px;
    border: 1px solid #b2b2b2;
    padding: 0 8px;
}
.tit-box {
    .article, h3 {
        color: #27282d;
        vertical-align: baseline;
    }
    h3 {
        display: inline-block;
        font-size: 18px;
        font-weight: 700;
    } 
    .article {
        display: inline;
        font-size: 13px;
        font-weight: 400;
        line-height: 15px;
        zoom: 1;
        padding-left: 5px;
        strong {
            font-weight: 700;
            vertical-align: baseline;
        }
    }
}
.list-comment {
    margin-top: 30px;
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
.detail >.banner {
    margin-top: 70px !important;
}
</style>