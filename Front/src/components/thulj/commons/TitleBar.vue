<template>
    <nav class="white" :class="customClasses">
        <div class="nav-wrapper ">
            <span class="brand-logo black-text">{{sectionTitle}}</span>
        </div>
    </nav>
</template>

<script>
  export default {
    name: 'TitleBar',
    props: ['sectionTitle', 'customClasses']
  }
</script>

<style scoped>
    nav {
        position: fixed;
        top: 0;
        z-index: 50
    }
    @media only screen and (min-width: 992px){
        nav{ padding-left: 120px;}
        .withMiddleNav{padding-left:60px;z-index:0}
    }

    .brand-logo {
        font-size: 18px;
    }
    .withMiddleNav{left:485px;}
</style>
