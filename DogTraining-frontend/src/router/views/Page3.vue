<template>
  <div class="page3-page">
    <BaseContainer :headerTitle="title"></BaseContainer>
  </div>
  
</template>

<script>

import BaseContainer from '@/components/base/BaseContainer'

export default {
    name: 'Page1',
    props: {

    },
    mounted() {

    },
    data() {
        return {
            title: "Page 3 Title",
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