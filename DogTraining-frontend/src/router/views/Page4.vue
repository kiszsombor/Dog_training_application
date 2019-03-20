<template>
  <div class="page4-page">
    <BaseContainer :headerTitle="title"></BaseContainer>
  </div>
  
</template>

<script>

import BaseContainer from '@/components/base/BaseContainer'

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
      BaseContainer,
    }
}
</script>

<style scoped>

/* div.title h1{
  text-align: center;
} */

</style>