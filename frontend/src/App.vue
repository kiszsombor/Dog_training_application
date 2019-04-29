<template>
  <div id="app">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <NavigationBar></NavigationBar>
    <router-view/>
  </div>
</template>


<script>
import NavigationBar from '@/components/NavigationBar'
// import LoginPage from '@/components/pages/LoginPage'
// import BasicPage from '@/components/pages/BasicPage'

export default {
  name: 'App',
  components:{
    NavigationBar,
    // LoginPage,
    // BasicPage
  }
}
</script>


<style>
.pages{
  background-color: #fff;
    padding-top:7%;
    margin-left:20%;
    margin-right:20%;
    overflow-y:auto;
    margin-bottom:5%;
}

.main-title{

    font-weight:bold;
    color: #575555;
    font-family: arial, sans-serif;
    font-size: 28px;
    font-weight: bold;
    margin-top: 0px;
    margin-bottom: 2%;
    text-align: center;
}
</style>
