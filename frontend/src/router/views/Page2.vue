<template>
  <div class="pages">
    <h1 class="main-title">
      {{title}}
    </h1>
    <!-- <BaseContainer :headerTitle="title"></BaseContainer> -->
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
            title: "Trükkjeim",
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