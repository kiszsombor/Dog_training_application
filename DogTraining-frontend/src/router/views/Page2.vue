<template>
  <div class="page2-page">
    <BaseContainer :headerTitle="title"></BaseContainer>
  </div>
  
</template>

<script>

import BaseContainer from '@/components/base/BaseContainer'

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
      BaseContainer,
    }
}
</script>

<style scoped>

/* div.title h1{
  text-align: center;
} */

</style>