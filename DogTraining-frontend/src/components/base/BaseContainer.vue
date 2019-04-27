<template>
    <div class="base-container">
        <div class="header main-title">
            <h1> {{headerTitle}} </h1>

        </div>
        <div class="body">
            <Login v-if="bodyTitle === 'LoginBody'"></Login>
            <h1 v-else> {{ bodyTitle }} </h1>
            
            
            
            <!-- <LoginBody></LoginBody> -->
        </div>

        

    </div>
</template>


<script>
import Login from '@/router/views/Login.vue'

export default {
    name: 'BaseContainer',
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
        Login
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
div.base-container{
    padding-top:40px;
}
</style>
