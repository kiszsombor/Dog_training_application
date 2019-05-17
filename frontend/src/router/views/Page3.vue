<template>
  <div class="pages">
    <!-- <BaseContainer :headerTitle="title"></BaseContainer> -->
    <h1 class="main-title">
      {{title}}
    </h1>
{{dogs}}
  <table class="table">
    <thead class=" thread bg-secondary">
        <tr>
        <th scope="col"></th>
        <th scope="col">Név</th>
        <th scope="col">Születési dátum</th>
        <th scope="col">Fajta</th>
        <th scope="col">Nem</th>
        <th scope="col">Súly</th>
        </tr>
    </thead>
    <tbody v-for="s in dogs" :key="s.id">
        <tr>
            <th scope="row">{{s.id}}</th>
            <!-- <td>{{moment(String(s.birthDate)).format("LL")}}</td> -->
            <td>{{s.name}}</td>
            <td>{{s.birthDate}}</td>
            <td>{{s.breed}}</td>
            <td>{{s.sex}}</td>
            <td>{{s.weight}}</td>
            <!-- <td><b-button v-b-modal.modal-modify variant="secondary"><i class="fas fa-edit"></i></b-button></td>
            <td><b-button v-b-modal.modal-1 variant="secondary" @click="ticketId=s.id"><i class="fas fa-trash"></i></b-button></td> -->
            
        </tr>
        
    </tbody>
    </table>



  </div>
  
</template>

<script>
import { mapState, mapActions } from 'vuex';
import moment from 'moment'
// import BaseContainer from '@/components/base/BaseContainer'

export default {
    name: 'Page3',
    props: {

    },
    mounted() {

    },
    created(){
      this.getDogs()
      //this.getDogsByTrainer()
    },
    data() {
        return {
            title: "Kutyáim",
        }
    },
    methods: {
        ...mapActions(['getDogById','getAllDogs','getDogsByTrainerId']),
        getDog(){
          this.getDogById(this.dogId);
        },
        getDogs(){
          this.getAllDogs();
        },
        getDogsByTrainer(){
          this.getDogsByTrainerId(this.trainerId);
        }
    },
    computed: {
        ...mapState({
            dogs: function (state) { return state.moduleDog.dogs }
        })
    },
    components: {
      // BaseContainer,
    }
}
</script>

<style scoped>

</style>