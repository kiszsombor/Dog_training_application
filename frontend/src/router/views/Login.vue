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
                    v-model="form.name"
                    required
                    placeholder="Írja be a felhasználónevét..." />
            </b-form-group>

            <!-- <b-form-group
                id="inputEmailGroup"
                label="Email:"
                label-for="inputEmail"
                description="We'll never share your email with anyone else."
            >
                <b-form-input 
                    
                    id="inputEmail"
                    type="email"
                    text-align="center"
                    v-model="form.email"
                    required
                    autocomplete="username email"
                    placeholder="email@example.com" />
            </b-form-group> -->

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
                    placeholder=" *********** " />
            </b-form-group>


            <!-- <b-form-group id="inputSelectGroup"
                label="Options:"
                label-for="inputSelect"
            >
                <b-form-select
                    id="inputSelect"
                    :options="options"
                    required
                    v-model="form.option" />
            </b-form-group>

            <b-form-group id="inputCheckGroup">
                <b-form-checkbox-group v-model="form.checked" id="inputCheck">
                    <b-form-checkbox value=1>Check 1</b-form-checkbox>
                    <b-form-checkbox value=2>Check 2</b-form-checkbox>
                </b-form-checkbox-group>
            </b-form-group> -->
            <br>
                <div class="row">
                    <div class="col-lg-12">
                        <b-button class="button" type="submit" variant="primary">Bejelentkezés</b-button>
                    </div>
                    
                         
            </div>
        <hr>
            <div class="row">
                <div class="col-lg-12">
                        <b-button class="button" type="reset" variant="danger"><router-link to="RegisterPage" >Még nem regisztráltam</router-link></b-button>
                    </div>
            </div>
            
        </b-form>
    </div>
</template>

<script>
export default {

    name: "Login",
    data() {
        return {
            title:"Bejelentkezés",
        form: {
            email: '',
            name: '',
            //option: null,
            //checked: []
        },
        //options: [{ text: 'Select One', value: null }, 'Option1', 'Option2', 'Option3', 'Option4'],
        show: true
        }
    },
    methods: {
        onSubmit(event) {
            event.preventDefault()
            alert(JSON.stringify(this.form))
        },
        onReset(event) {
            event.preventDefault()
            /* Reset our form values */
            this.form.email = ''
            this.form.name = ''
            this.form.option = null
            this.form.checked = []
            /* Trick to reset/clear native browser form validation state */
            this.show = false
            this.$nextTick(() => {
                this.show = true
            })
        }
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
