<template>
  <div class="pages">
    <!-- <BaseContainer :headerTitle="title"></BaseContainer> -->
    <h1 class="main-title">
      {{title}}
    </h1>
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

</style>