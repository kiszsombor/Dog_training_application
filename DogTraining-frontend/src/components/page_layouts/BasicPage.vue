<template>
    <div class="basic-page">
        <div class="header">
            <h1> {{headerTitle}} </h1>

        </div>
        <div class="body">

        </div>

    </div>
</template>

<script>
export default {
    name: 'BasicPage',
    props: {
        headerTitle: {
            default: 'Default Page Title',
            required: true,
            
        }
    },
    data() {
        return {
            
        }
    },
    methods: {
        
    },
}
</script>

<style scoped>

div.header h1{
    text-align: center;
}

</style>
