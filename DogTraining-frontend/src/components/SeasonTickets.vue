<template>


    <div class="seasonticket-page">
        <div class="header">
            <h1> {{title}} </h1>

        </div>
        <div class="body">
            <h1> {{ body }} </h1>
            <div> {{ count }} </div>
            
        </div>

        
    </div>
  
</template>

<script>

import BaseContainer from '@/components/base/BaseContainer'

export default {
    name: 'SeasonTicket',
    props: {

    },
    mounted() {

    },
    data() {
        return {
            title: "SeasonTicket Title",
            body: "Body",
            count: this.$store.state.count

        }
    },
    methods: {
        //     count() {
        //     console.log(this.$store.state.count)
        //     return this.$store.state.count
        // }
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
