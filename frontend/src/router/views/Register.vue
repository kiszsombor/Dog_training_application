<template>

    <div class="login-page pages">
<div class="main-title">
    {{title}}
</div>

        <b-form v-if="show">

            <b-form-group
                id="inputUsernameGroup"
                label="Felhasználónév:"
                label-for="inputUsername"
            >
                <b-form-input
                    id="inputUsername"
                    type="text"
                    v-model="form.username"
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
                    v-model="form.password"
                    required
                    autocomplete="current-password"
                    placeholder=" Írja be a teljes jelszavát... " />
            </b-form-group>

            <b-form-group
                id="inputNameGroup"
                label="Teljes név:"
                label-for="inputName"
            >
                <b-form-input
                    id="inputName"
                    type="text"
                    v-model="form.name"
                    required
                    placeholder="Írja be a teljes nevét..." />
            </b-form-group>

            <b-form-group
                id="inputEmailGroup"
                label="Email-cím:"
                label-for="inputEmail"
            >
                <b-form-input
                    id="inputEmail"
                    type="email"
                    v-model="form.email"
                    required
                    placeholder="Írja be az email-címét..." />
            </b-form-group>

            <!-- <b-form-group
                id="inputAddressGroup"
                label="Cím:"
                label-for="inputAddress"
            >
                <b-form-input
                    id="inputAddress"
                    type="text"
                    v-model="form.address"
                    required
                    placeholder="Írja be a címét..." />
            </b-form-group> -->

            <b-form-group
                id="inputPhonenumberGroup"
                label="Telefonszám:"
                label-for="inputPhonenumber"
            >
                <b-form-input
                    id="inputPhonenumber"
                    type="text"
                    v-model="form.phonenumber"
                    required
                    placeholder="Írja be a telefonszámát..." />
            </b-form-group>

            <!-- <b-form-group
                id="inputBirthdateGroup"
                label="Születési idő:"
                label-for="inputBirthdate"
            >
                <b-form-input
                    id="inputBirthdate"
                    type="text"
                    v-model="form.birthdate"
                    required
                    placeholder="Írja be a születési dátumát..." />
            </b-form-group> -->

            <!-- <b-form-group
                id="inputBirthplaceGroup"
                label="Születési hely:"
                label-for="inputBirthplace"
            >
                <b-form-input
                    id="inputBirthplace"
                    type="text"
                    v-model="form.birthplace"
                    required
                    placeholder="Írja be a születési helyét..." />
            </b-form-group> -->
{{form}}
            <br>
                <div class="row">
                    <div class="col-lg-12">
                        <b-button class="button" type="submit" variant="primary" @click="saveRegisteredUser()">Regisztráció</b-button>
                    </div>
                    
                         
            </div>
        <hr>
            <div class="row">
                <div class="col-lg-12">
                        <b-button class="button" type="reset" variant="danger"><router-link to="LoginPage" >Vissza a bejelentkezésre</router-link></b-button>
                    </div>
            </div>
            
        </b-form>

            <div class="alert alert-danger" role="alert" v-if="registrationError">
            This is a danger alert—check it out!
            </div>

        
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';


export default {

    name: "Register",
    data() {
        return {
            title:"Bejelentkezés",
        form: {
            username: '',
            password:'',
            name:'',
            email:'',
            phonenumber:0
        },
        show: true,
        registrationError:false,
        }
    },
    created(){
    },
    methods: {
        ...mapActions(['registration']),

        saveRegisteredUser(){
            console.log("HAHO")
            console.log(this.form)
            this.registration(this.form)
            .then(() => this.$router.push(`/LoginPage`))
            .catch(e =>{
                  this.registrationError=true;
                     this.$router.push(`/RegisterPage`)
            });
           
        },

        
        



        // onSubmit(event) {
        //     event.preventDefault()
        //     alert(JSON.stringify(this.form))
        // },
        // onReset(event) {
        //     event.preventDefault()
        //     /* Reset our form values */
        //     this.form.email = ''
        //     this.form.name = ''
        //     /* Trick to reset/clear native browser form validation state */
        //     this.show = false
        //     this.$nextTick(() => {
        //         this.show = true
        //     })
        // }
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
    width:100%;
}

a, a:hover{
    text-decoration: none;
    color: white;
}

</style>
