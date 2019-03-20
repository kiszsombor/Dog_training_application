<template>
  <div id="app">
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
body{
  background-color: rgb(221, 224, 207);
}
</style>
