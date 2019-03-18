<template>
    <div class="basic-page">
        <div class="header">
            <h1> {{headerTitle}} </h1>

        </div>
        <div class="body">
            <h1 v-if="bodyTitle === 'Default Page Body'"> {{ bodyTitle }} </h1>
            <LoginBody v-if="bodyTitle === 'LoginBody'"></LoginBody>
            
            <!-- <LoginBody></LoginBody> -->
        </div>

    </div>
</template>

<script>

import LoginBody from './login_page/LoginBody'

export default {
    name: 'BasicPage',
    props: {
        headerTitle: {
            default: 'Default Page Title',
            required: true,
            
        },
        bodyTitle: {
            default: 'Default Page Body',
            required: true,
        }
    },
    data() {
        return {
            
        }
    },
    methods: {
        
    },
    components: {
        LoginBody
    },
}
</script>

<style scoped>

div.header h1{
    text-align: center;
    padding: 5%;
}

div.body h1{
    text-align: center;
    padding: 10%;
}

</style>
