<template>
  <div class="page4-page">
    <BasicPage :headerTitle="title"></BasicPage>
  </div>
  
</template>

<script>

import BasicPage from '@/components/page_layouts/BasicPage'

export default {
    name: 'Page4',
    props: {

    },
    mounted() {

    },
    data() {
        return {
            title: "Page 4 Title",
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