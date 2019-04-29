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


.main-title{
font: bold 30px "Century Schoolbook", Georgia, Times, serif;
 color: #333;
 line-height: 90%;
 margin: .2em 0 .4em 0;
 letter-spacing: -2px;
 text-shadow: 1px 1px 1px rgba(0,0,0,0.2);
 text-align:center;
}
</style>
