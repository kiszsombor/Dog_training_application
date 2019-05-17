<template>
  <div class="login-page">
    <!-- <BaseContainer :headerTitle="title" :bodyTitle="bodyTitle"></BaseContainer> -->
  </div>

  <!-- <div class="login-page">
    <Login></Login>
  </div> -->
  
  <!-- <div class='login'>
    <router-view>
      <div class="header">
        <div class="title">
            <h1> {{ title }} </h1>
        </div>
      </div>
      <div class="body">

      </div>
    </router-view>
  </div> -->


</template>




<script>

import BaseContainer from '@/components/base/BaseContainer'
import Login from './Login'

export default {
  name: 'LoginPage',
  data () {
    return {
      title: "Login Page Title",
      bodyTitle: "LoginBody",
    }
  },
  mounted() {
    
  },
  components: {
    BaseContainer
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

/* div.title h1{
  text-align: center;
} */

/* div.login{
  padding: 20px 50px;
} */
/* div h1{
  text-align: center;
} */

</style>
