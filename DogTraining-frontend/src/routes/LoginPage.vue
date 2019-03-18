<template>
  <div class="login-page">
    <BasicPage :headerTitle="title" :bodyTitle="bodyTitle"></BasicPage>
  </div>
  
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

import BasicPage from '@/components/page_layouts/BasicPage'

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
    BasicPage
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
