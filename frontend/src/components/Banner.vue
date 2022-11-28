<template>
    <div class="banner">
        <div class="banner-inner">
            <router-link :to="{path: `/`}">
                <div>
                    <img :src="file" />
                </div>
            </router-link>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        file: String,
        class: String,
        link: String,
    },
    mounted () {
    },
}
</script>


<style lang="scss" scoped>
.banner {
    padding-bottom: 70px;
    width: 100%;
    &-inner {
        width: 980px;
        margin: 0 auto!important;
    }
}
</style>