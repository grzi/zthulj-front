<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>
  export default {
    name: 'app',
    components: {
    }
  }
</script>

<style>
    body {
        background: #eceff1;
        font-family: 'Source Code Pro', monospace;
        font-weight: 500;
    }
    .content{margin-top: 70px;
        min-height: 600px;}
    .content .container{width:90% !important;padding-left:105px;font-weight: 400;}
    .articleContent h1{font-size:30px !important;font-weight:500;}
    .articleContent h2{font-size:27px !important;font-weight:500;}
    .articleContent h3{font-size:24px !important;font-weight:500;}
    .articleContent h4{font-size:21px !important;font-weight:500;}
    .articleContent h5{font-size:18px !important;font-weight:500;}
    .articleContent h6{font-size:15px !important;font-weight:500;}
    .articleContent ul li {list-style-type: disc !important;}
    .articleContent ul {margin-left:30px;}
    .articleContent img{width:80%;margin-left:10%;}
</style>
