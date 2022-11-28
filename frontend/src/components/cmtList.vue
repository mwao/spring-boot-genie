<template>
    <div class="card-container">
    <el-row class="card-list" :gutter="12">
      <el-col :span="8" v-for="(card, index) in cardLists" :key="index">
        <router-link :to="`/${card.name}`">
          <el-card :body-style="{ padding: '0' }">
            <div class="card-content">
              <strong>{{ card.title }}</strong>
              <div class="card-detail">
                {{ card.detail }}
              </div>
            </div>
          </el-card>
        </router-link>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
    inject: [
        'cmtList',
    ],
    data() {
        return {
            cardLists: [
                {
                name: 'program',
                title: '프로그램 소개',
                detail: `프로그램 소개`
                },
                {
                name: 'mc',
                title: 'MC소개',
                detail: `MC소개`
                },
                {
                name: 'lineup',
                title: '라인업',
                detail: `라인업`
                },
                {
                name: 'clip',
                title: '다시보기',
                detail: `다시보기`
                },
                {
                name: 'notice',
                title: '공지사항',
                detail: `공지사항`
                },
            ],
        }
    },
};
</script>

  
<style lang="scss" scoped>

.editorIndex {
  // margin: 50px auto 0;
  display: flex;
  flex-direction: column;
  align-content: center;
  align-items: center;
  justify-content: center;
  height: 100%;
  .card-container {
    width: 90%;
    max-width: 900px;
    margin: 0 auto;
    padding-bottom: 5rem;
  }
  .card-list {
    display: flex;
    flex-wrap: wrap;
    align-items: stretch;
    .el-col {
      padding-top: 6px;
      padding-bottom: 6px;
      float: none;
      min-height: 280px;
    }
    .el-card {
      height: 100%;
    }
    .card-content {
      padding: 20px;
      font-family: CJ_ONLYONE_NEW_body_Regular, Verdana, Arial, sans-serif;
      > strong {
        font-size: 1.5rem;
      }
      .card-detail {
        margin-top: 0.5rem;
      }
    }
    a {
      text-decoration: none;
      &:hover {
        .el-card {
          box-shadow: 0 4px 24px 0 rgb(0 0 0 / 20%)
        }
        .card-img {
          opacity: 1;
        }
      }
    }
  }
}
</style>