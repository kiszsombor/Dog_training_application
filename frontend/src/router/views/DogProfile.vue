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
          <b-col cols="6"><h2>Kutya adatai: </h2></b-col>
          <b-col cols="6"></b-col>
          <b-col cols="6">Születési dátum </b-col>
          <b-col cols="6">{{moment(String(dog.birthDate)).format("LL")}}</b-col>
              <div class="w-100"></div>
          <b-col cols="6">Fajta </b-col>
          <b-col cols="6">{{dog.breed}}</b-col>
              <div class="w-100"></div>
          <b-col cols="6">Súly </b-col>
          <b-col cols="6">{{dog.weight}} kg</b-col>
              <div class="w-100"></div>
          <b-col cols="6">Nem </b-col>
          <b-col cols="6">{{dog.sex=="MALE" ? "kan": dog.sex=="FEMALE" ? "szuka" : dog.sex=="NEUTERED_MALE" ? "kan (ivartalanított)" : dog.sex=="NEUTERED_FEMALE" ? "szuka (ivartalanított)" : dog.sex}}</b-col>
              <div class="w-100"></div>
              <br> 
              <b-col cols="12">
                <hr>
                  
                  
                {{dog.description}}</b-col>

        </b-row>
      </b-container>
      <b-container fluid class="bv-example-row">
        <b-row class="datas">
            <div class="w-100"></div>
          <b-col cols="6"><h2>Edző adatai: </h2></b-col>
          <b-col cols="6"></b-col>
          <b-col cols="6">Név </b-col>
          <b-col cols="6">{{trainer.name}}</b-col>
              <div class="w-100"></div>
          <b-col cols="6">Születési dátum </b-col>
          <b-col cols="6">{{moment(String(trainer.birthDate)).format("LL")}}</b-col>
              <div class="w-100"></div>
          <b-col cols="6">Email-cím </b-col>
          <b-col cols="6">{{trainer.email}}</b-col>
              <div class="w-100"></div>
          <b-col cols="6">Telefonszám </b-col>
          <b-col cols="6">{{trainer.phoneNumber}}</b-col>
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

                        <b-modal id="modal-1" title="Biztos ki szeretné törölni?" ok-title="Igen" cancel-title="Nem" 
                          @ok="deleteDog_ById()">
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
  {{trainer}}
</div>


  </div>

</template>

<script>
import { mapState, mapActions } from 'vuex';
import moment from 'moment'

// import BaseContainer from '@/components/base/BaseContainer'

export default {
    name: 'DogProfile',
    props: {

    },
    mounted() {
      moment.locale('hu')
    },
    created(){
      this.getDog(),
      this.getDogs(),
      this.getTrainer()
    },
    data() {
        return {
            title: "Profilom",
            moment:moment,
            trainerId:this.$route.params.trainerId,
            dogId: this.$route.params.dogId,
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
        ...mapActions(['getDogById','getAllDogs','deleteDogById','getTrainerById']),
        getDog(){
          this.getDogById(this.dogId);
        },
        getDogs(){
          this.getAllDogs();
        },
        deleteDog_ById(){
          this.deleteDogById(this.dogId)
          .then(() => this.$router.push(`/LoginPage`))
        },
        getTrainer(){
          this.getTrainerById(this.trainerId);
        },
    },
    computed: {
        ...mapState({
            dog: function (state) { return state.moduleDog.dog },
            dogs: function (state) { return state.moduleDog.dogs },
            trainer: function (state) { return state.moduleDog.trainer}
        })
    },
    components: {
      // BaseContainer,
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
h1{
  padding-bottom: 1%;
}
h2{
  padding-bottom: 3%;
  font-size: 120%;
}

</style>