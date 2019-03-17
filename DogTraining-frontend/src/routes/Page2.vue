<template>
  <div class="page2-page">
    <BasicPage :headerTitle="title"></BasicPage>
  </div>
  
</template>

<script>

import BasicPage from '@/components/page_layouts/BasicPage'

export default {
    name: 'Page2',
    props: {

    },
    mounted() {

    },
    data() {
        return {
            title: "Page 2 Title",
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