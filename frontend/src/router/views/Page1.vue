<template>
  <div class="pages">
    <!-- <BaseContainer :headerTitle="title"></BaseContainer> -->
    <h1 class="main-title">
      {{title}}
      </h1> 
        
  <div class="card">
  <b-card

    header-text-variant="white"
    header-bg-variant="secondary"

    bg-variant="light"
    
    tag="article"
    style="max-width: 100%;"
    class="mb-2"
  >
  <div slot="header">
        <b-row bg-variant="dark" >
          <b-col cols="10">
          <h3>{{dog.name}}</h3>
          </b-col>
             <b-col cols="1"> <b-button variant="dark" v-b-tooltip.hover  v-b-modal.modal-prevent title="Profil szerkesztése"><i class="fas fa-edit"></i></b-button></b-col>
              <b-col cols="1"> <b-button v-b-modal.modal-1 variant="dark" v-b-tooltip.hover title="Profil törlése"><i class="fas fa-trash"></i></b-button></b-col>
        </b-row>
      </div>
    <b-card-text>
    <b-container fluid class="bv-example-row">
        <b-row class="datas">
            <div class="w-100"></div>
          
          <b-col cols="6">Születési dátum </b-col>
          <b-col cols="6">{{dog.birthDate}}</b-col>
              <div class="w-100"></div>
          <b-col cols="6">Fajta </b-col>
          <b-col cols="6">{{dog.breed}}</b-col>
              <div class="w-100"></div>
          <b-col cols="6">Súly </b-col>
          <b-col cols="6">{{dog.weight}}</b-col>
              <div class="w-100"></div>
              <br>
                  
              <b-col cols="12">
                <hr>
                  
                  
                {{dog.description}}</b-col>

        </b-row>
      </b-container>    
      </b-card-text>
      
  </b-card>
</div>

<!-- MODAL -->
                    <div>

                        <b-modal id="modal-1" title="Biztos ki szeretné törölni?" ok-title="Igen" cancel-title="Nem" @ok="showAlert">
                            <p class="my-4">A törlés végleges! </p>
                        </b-modal>
                    </div>


<!-- Modal Component -->
            <b-modal id="modal-prevent" ref="modal"
            title="Profil módosítása"
            ok-variant="primary"
            ok-title="Módosítás"
            cancel-title="Mégse"
            size="lg"
            
            >
            
            <!-- @shown="clearSeasonTicket" -->
            <form @submit.stop.prevent="handleSubmit">
                <b-container class="bv-example-row">
                <b-row>
                    <b-col cols="4">Név</b-col>
                    <b-col cols="8"><b-form-input type="text" v-model="myAccount.name"></b-form-input></b-col>
                    <div class="w-100 padding"></div>

                    <b-col cols="4">Születési dátum</b-col>
                    <b-col cols="8"><b-form-input type="date" v-model="myAccount.birthDate"></b-form-input></b-col>
                    <div class="w-100 padding"></div>

                    <b-col cols="4">Fajta</b-col>
                    <b-col cols="8"><b-form-input type="text" v-model="myAccount.breed"></b-form-input></b-col>
                    <div class="w-100 padding"></div>

                    <b-col cols="4">Súly</b-col>
                     <b-col cols="8"><b-form-input type="number" v-model="myAccount.weight"></b-form-input></b-col>
                     <div class="w-100 padding"></div>

                    <b-col cols="4">Leírás</b-col>
                     <b-col cols="8">
                        <b-form-textarea
                          id="textarea"
                          v-model="myAccount.description"
                          placeholder="Leírás..."
                          rows="4"
                          max-rows="12"
                      ></b-form-textarea>
                    </b-col>
                </b-row>
                </b-container>
               
            </form>
            </b-modal>
<div>
  <br>
  {{myAccount}}
</div>


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
            title: "Profilom",
            dog: this.$store.state.dogs[0],

            myAccount:{
              name:"",
              birthDate:null,
              weight:null,
              breed:"",
              description:""
            }
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

.w-100{
  padding-bottom: 2%;
}
.datas{
  font-size:22px;
}

</style>