<template>

    <div class="login-page pages">
<div class="main-title">
    {{title}}
</div>

        <b-form @submit="onSubmit" @reset="onReset" v-if="show">

            <b-form-group
                id="inputNameGroup"
                label="Felhasználónév:"
                label-for="inputName"
            >
                <b-form-input
                    id="inputName"
                    type="text"
                    v-model="trainer.username"
                    required
                    placeholder="Írja be a felhasználónevét..." />
            </b-form-group>

            <b-form-group
                id="inputPasswordGroup"
                label="Password:"
                label-for="inputPassword"
            >
                <b-form-input
                    id="inputPassword"
                    type="password"
                    v-model="trainer.password"
                    required
                    autocomplete="current-password"
                    placeholder=" *********** " />
            </b-form-group>
            <br>
            {{me.id}}

                <div class="row">
                    <div class="col-lg-12">
                            <b-button class="button" type="submit" variant="primary" @click="log_in()">Bejelentkezés</b-button>
                        
                    </div>
                    
                         
            </div>
        <hr>
            <div class="row">
                <div class="col-lg-12">
                        <b-button class="button" type="reset" variant="danger">Visszavonás</b-button>
                    </div>
            </div>
            
        </b-form>
    </div>
</template>

<script>

import { mapState, mapActions } from 'vuex';

export default {

    name: "Login",
    data() {
        return {
            title:"Bejelentkezés",
        form: {
            password: '',
            name: '',
            //option: null,
            //checked: []
        },
        trainer:{
            username:"",
	        password:""
        },
        //options: [{ text: 'Select One', value: null }, 'Option1', 'Option2', 'Option3', 'Option4'],
        show: true
        }
    },
    created(){
            console.log(this.trainer.username)
            console.log(this.trainer.password)
            console.log(this.me.id)
    },
    methods: {
            ...mapActions(['login','login_']),

            log_in(){
              this.login({username: this.trainer.username, password: this.trainer.password})
              .then(() => this.$router.push(`/logged/${this.me.id}/${this.dogId}/kutyaim`))
            },
            log_in_(){
                 this.login_({username: this.trainer.username, password: this.trainer.password})
              .then(() => this.$router.push(`/logged/${this.me.id}/${this.dogId}/kutyaim`))
            },

        onSubmit(event) {
            event.preventDefault()
            alert(JSON.stringify(this.trainer))
        },
        onReset(event) {
            event.preventDefault()
            /* Reset our form values */
            // this.form.email = ''
            // this.form.name = ''
            // this.form.option = null
            // this.form.checked = []
            /* Trick to reset/clear native browser form validation state */
            this.show = false
            this.$nextTick(() => {
                this.show = true
            })
        }
    },
    computed:{
    ...mapState({
            me: function (state) { return state.moduleDog.me }
        }),
  }
}
</script>

<style scoped>

div.login{
    margin: 10%;
}

b-form-input.email-input{
    text-align: center;
}

.login-page{
    background-color: #fff;
    padding-top:7%;
    padding-left:8%;
    padding-right:8%;
    overflow-y:auto;
    margin-bottom:5%;
}

.row{
    text-align:center;
}

.button{
    /* padding-right:1%;
    padding-left:1%;
    margin-left:1%;
    margin-right:1%;  */
    width:100%;
}

</style>
