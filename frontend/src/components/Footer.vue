<template>
    <div id="footer_wrap">
        <footer>
            <a href="#" target="_blank" class="flogo" style="background-repeat: inherit;">GENIE MUSIC</a>
            <ul class="flink">
                <li v-for="(footer, index) in footerLists" :key="index">
                    <a href="#" target="_blank">{{ footer.name }}</a>
                </li>
            </ul>
            <address>
                (주)지니뮤직<em>|</em>대표이사 : 박현진<em>|</em>서울 강남구 테헤란로415 (L7HOTELS강남타워 6,7,8층)<em>|</em>사업자등록번호 : 314-81-03453<em>|</em>통신판매일신고 : 2013-서울강남-01302<br>
                개인정보관리책임자 : 홍세희 본부장<em>|</em>서비스문의 : 1577-5337<em>/</em>help@ktmusic.co.kr<em>|</em>방송관련문의 : 1855-1631<em>/</em>mnet.help@cj.net<em>|</em><a href="javascript:;" onclick="window.open('http://www.ftc.go.kr/bizCommPop.do?wrkr_no=3148103453&amp;apv_perm_no=','');" title="팝업창">사업자정보확인&gt;</a>
                <p class="copyright">
                    COPYRIGHTⓒGENIE MUSIC CORP ALL RIGHTS RESERVED.
                </p>
            </address>
            <div class="cj_menu">
                <div class="sns_area">
                    <a href="#" target="_blank" title="새창" style="background-repeat: inherit; background-position: -200px 0px;">&gt;Facebook</a>
                </div>
            </div>
        </footer>
    </div>
</template>

<script>
export default {
    data() {
        return {
            footerLists: [
                {
                name: '회사소개',
                },
                {
                name: '이용약관',
                },
                {
                name: '개인정보처리방침',
                },
                {
                name: '청소년보호정책',
                },
                {
                name: '이메일무단수집거부',
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped>
#footer_wrap {
    position: relative;
    z-index: 40;
    background: #fff;
    * {
        text-align: left;
    }
    .sns_area a, aside .slink li, aside .slink ul+ul li a, footer a.flogo {
        background-image: url(//image.genie.co.kr/imageg/web/common/header_set.png?ver=3);
        background-repeat: no-repeat;
    }
    footer {
        position: relative;
        width: 1000px;
        clear: both;
        padding: 30px 0 50px;
        margin: 0 auto;
        a.flogo {
            display: block;
            width: 137px;
            height: 46px;
            background-position: 0 -301px;
            text-indent: -9999px;
        }
        ul.flink {
            margin: 16px 0 16px -6px;
            &::after {
                content: "";
                display: block;
                clear: both;
            }
            li {
                float: left;
                font-size: 13px;
                padding: 0 6px;
                a {
                    color: #868686;
                }
                &:nth-child(3) a {
                    color: #000;
                    font-weight: 700;
                    vertical-align: -0.5px;
                }
            }
        }
        address {
            clear: both;
            display: block;
            font-size: 11px;
            line-height: 18px;
            color: #8d8d8d;
            em {
                color: #c7c7c7;
                padding: 0 7px;
                font-size: 10px;
                font-family: dotum;
            }
            a {
                color: #8d8d8d;
            }
            p.copyright {
                color: #a1a1a1;
                font-size: 11px;
                margin-top: 10px;
            }
        }
    }
    .cj_menu {
        position: absolute;
        top: 38px;
        right: 4px;
    }
    .sns_area {
        float: left;
        a {
            display: block;
            float: left;
            width: 30px;
            height: 30px;
            margin: 0 4px 0 0;
            background-position: -200px -301px;
            text-indent: -9999px;
            background-image: url(//image.genie.co.kr/imageg/web/common/header_set.png?ver=3);
            background-repeat: inherit;
            background-position: -200px 0px;
        }
    }
}
</style>