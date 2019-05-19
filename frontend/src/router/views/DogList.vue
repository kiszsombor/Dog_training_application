<template>
  <div class="pages">
    <!-- <BaseContainer :headerTitle="title"></BaseContainer> -->
    <h1 class="main-title">
      {{title}}
    </h1>
<!-- {{dogs}} -->
TRAINERDOGS:   {{trainerDogs}}
{{trainerId}}
{{dogId}}
<div>
  <!-- {{me}} -->
</div>
  <table class="table">
    <thead class=" thread bg-secondary">
        <tr>
        <th scope="col"></th>
        <th scope="col">Név</th>
        <th scope="col">Születési dátum</th>
        <th scope="col">Fajta</th>
        <th scope="col">Nem</th>
        <th scope="col">Súly</th>
        <th scope="col">Kutya választás</th>
        </tr>
    </thead>
    <tbody class="link" v-for="s in trainerDogs" :key="s.id">
      
        <tr v-bind:class="{ active: colorActiveDog(s.id)}">
            <td scope="row">{{s.id}}</td>
            <td>{{s.name}}</td>
            <td>{{s.birthDate}}</td>
            <td>{{s.breed}}</td>
            <td>{{s.sex}}</td>
            <td>{{s.weight}}</td>
            <router-link :to="`/logged/${trainerId}/${s.id}/kutyaim`">
            <td class="button" @click=" tableId=s.id">Kiválaszt</td>
            </router-link>
        </tr>

    </tbody>
  </table>
  <!-- {{ trainerDogs.length }} -->
  {{ tableId }}
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
     // if (!this.$store.state.moduleDog.me.id) { this.$router.push('/LoginPage') }
      this.getDogs()
      //this.getDogsByTrainer()
    },
    data() {
        return {
          //trainerId:this.$store.state.moduleDog.me.id,
          trainerId:this.$route.params.trainerId,
          dogId:this.$route.params.dogId,
          tableId:null,
          title: "Kutyáim",
          checked:''
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
        },
        colorActiveDog(tableId){
          if(tableId == this.dogId){
            return true;
          }
          return false
        }
    },
    computed: {
        ...mapState({
            dogs: function (state) { return state.moduleDog.dogs },
			      trainerDogs: function (state) {return state.moduleDog.trainerDogs},
           // me: function (state) { return state.moduleDog.me }
        })
    },
    components: {
      // BaseContainer,
    }
}
</script>

<style scoped>
thead, tbody{
  text-align: center;
}
.button, a{
  color: black;
  margin: auto;
  text-decoration: none;
  font-weight: bold;
  text-align: center;
}

.button:hover, a:hover{
  color: blue;
  margin: auto;
  text-decoration: none;
  font-weight: bold;
  text-align: center;
}
.link{
  background-color: lightgray;
}
.active{
  background-color: lightblue;
}


</style>