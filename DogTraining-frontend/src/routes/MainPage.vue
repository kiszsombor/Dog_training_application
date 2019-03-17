<template>
  <div class="main-page">
    <BasicPage :headerTitle="title"></BasicPage>
  </div>
  
</template>

<script>

import BasicPage from '@/components/page_layouts/BasicPage'

export default {
    name: 'MainPage',
    props: {

    },
    mounted() {

    },
    data() {
        return {
            title: "Main Page Title",
        }
    },
    methods: {
        
    },
    computed: {
        
    },
    components: {
      BasicPage,
    }
}
</script>

<style scoped>

/* div.title h1{
  text-align: center;
} */

</style>
