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
</style>
