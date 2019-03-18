<template>
    <div class="login-body">
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">

            <b-form-group
                id="inputNameGroup"
                label="Name:"
                label-for="inputName"
            >
                <b-form-input
                    id="inputName"
                    type="text"
                    v-model="form.name"
                    required
                    placeholder="Enter name" />
            </b-form-group>

            <b-form-group
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
                    placeholder="Enter email" />
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
                    placeholder="Enter password" />
            </b-form-group>


            <b-form-group id="inputSelectGroup"
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
            </b-form-group>

            <b-button type="submit" variant="primary">Submit</b-button>
            <b-button type="reset" variant="danger">Reset</b-button>
        </b-form>
    </div>
</template>

<script>
export default {

    name: "LoginBody",
    data() {
        return {
        form: {
            email: '',
            name: '',
            option: null,
            checked: []
        },
        options: [{ text: 'Select One', value: null }, 'Option1', 'Option2', 'Option3', 'Option4'],
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

div.login-body{
    margin: 10%;
}

b-form-input.email-input{
    text-align: center;
}

</style>
