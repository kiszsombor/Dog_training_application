<template>
  <div id="app" class="bg-light">
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
/* body{
  background-color: rgb(221, 224, 207);
} */

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
