<template>
  <div class="home">
    <!-- <BaseContainer :headerTitle="title"></BaseContainer> -->
    <router-view></router-view>
  </div>
  
</template>

<script>

// import BaseContainer from '@/components/base/BaseContainer'

export default {
    name: 'Home',
    props: {

    },
    mounted() {

    },
    data() {
        return {
            title: "Home Page Title",
        }
    },
    methods: {
        
    },
    computed: {
        
    },
    components: {
      // BaseContainer,
    }
}
</script>

<style scoped>

/* div.title h1{
  text-align: center;
} */

</style>
