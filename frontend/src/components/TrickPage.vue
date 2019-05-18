<template>
  <div class="pages">
    <h1 class="main-title">
      {{title}}
      </h1> 
<div class="main">
    <ul>
      <li class="basic">
        <router-link :to="`/logged/${trainerId}/${dogId}/alapszint`"> Alapszint 
          <b-progress id="progress" :max="getLengthTricksBy_Categoryes(basic)"><b-progress-bar id="mb-2" :value="getTricksByDogByCategory(basic)" class="mb-2">{{getTricksByDogByCategory(basic)}}/{{getLengthTricksBy_Categoryes(basic)}}</b-progress-bar></b-progress>
        </router-link>
      </li>
      <li class="intermediate">
        <router-link :to="`/logged/${trainerId}/${dogId}/kozepszint`"> Középszint
          <b-progress id="progress" :max="getLengthTricksBy_Categoryes(intermediate)"><b-progress-bar id="mb-2" :value="getTricksByDogByCategory(intermediate)" class="mb-2">{{getTricksByDogByCategory(intermediate)}}/{{getLengthTricksBy_Categoryes(intermediate)}}</b-progress-bar></b-progress>
        </router-link>
      </li>
      <li class="advanced">
        <router-link :to="`/logged/${trainerId}/${dogId}/haladoszint`"> Haladó szint
          <b-progress id="progress" :max="getLengthTricksBy_Categoryes(advanced)"><b-progress-bar id="mb-2" :value="getTricksByDogByCategory(advanced)" class="mb-2">{{getTricksByDogByCategory(advanced)}}/{{getLengthTricksBy_Categoryes(advanced)}}</b-progress-bar></b-progress>
        </router-link>
      </li>
    </ul>
    <p class="back"><router-link :to="`/logged/${trainerId}/${dogId}/tricks`"> VISSZA </router-link></p>
  </div>
   <!-- <div v-for="t in tricks" :key=t.id>
  <div>
    {{t}}
  </div>
</div> -->
<!-- <button @click="proba()">Try it</button> -->
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

export default {
  name: 'TrickPage',

  
  components: {
      
  },
  data() {
    return {
      title: 'Trükkjeim',
      trainerId:this.$route.params.trainerId,
      dogId:this.$route.params.dogId,
      basic:"BASIC",
      intermediate:"INTERMEDIATE",
      advanced:"ADVANCED"
    }
  },

  created(){
    this.getTricks_ByDog();
    this.getAll_Tricks();


    //teljesített feladatok meghatározására
    this.getTricksByDogByCategory(this.basic) //hány basic trükk teljesült az összesből
    this.getTricksByDogByCategory(this.intermediate)
    this.getTricksByDogByCategory(this.advanced)

    //feladattípus hosszának meghatározására
    this.getLengthTricksBy_Categoryes(this.basic); //mennyi BASIC trick van összesen
    this.getLengthTricksBy_Categoryes(this.intermediate);
    this.getLengthTricksBy_Categoryes(this.advanced);
    
  },
    
  methods:{
     ...mapActions(['getTricksByCategory','getTricksByADog','getAllTricks']),
    
    getAll_Tricks(){
      this.getAllTricks();
    },
    proba(){
      document.getElementById("COME").className="btn li button btn-lg btn-block class1";
    },

    getTricks_ByDog(){
      this.getTricksByADog(this.dogId)
    },

    getTricksByDogByCategory(trickCategory){
      var count=0;
      this.tricks.forEach(function(element) {
        if(element.category==trickCategory){
          count++;
        }
      });

      // for(let i=0;i<this.tricks.length;i++){
      //     if(this.tricks[i].category==trickCategory){
      //       count++;
      //     }
      // }
      return count;
    },

    getLengthTricksBy_Categoryes(trickCategory){
      var count=0;
      this.allTricks.forEach(function(element) {
        if(element.category==trickCategory){
          count++;
        }
      });
      return count;
    }
  },
  computed:{
    ...mapState({
          tricks: function (state) { return state.moduleDog.tricks },
          allTricks: function (state) { return state.moduleDog.allTricks },
          //categoryTricks: function (state) { return state.moduleDog.categoryTricks },
        }),
  }
}
</script>
<style scoped>
 .main {
    max-width: 1200px;
	  min-width: 300px;
    margin: auto;
    text-align: center;
}
h2 {
    margin: 2% 2% 2% 5%;
    color: black;
    font-family: Arial, sans-serif;
    font-size: 260%;
    text-align: left;
    font-weight: normal;
}
ul {
    margin: auto;
    padding: 0%;
}
li{
    list-style-type: none;
    padding: 2% 0% 2% 0%;
}
li a {
    font-size: 120%;
    display: inline-block;
    width: 80%;
    padding: 3% 0% 0% 0%;
    background-color: lightgray;
    text-decoration: none;
    color: black;
    border-radius: 5px 5px 5px 5px;
}
li a:hover {
    background-color: gray;
    color: white;
    background-repeat: no-repeat;
    background-position: 40% 50%;
    background-size: 5%;
}
.basic {
  margin-top: 2%;
}
#progress {
    font-size: 100%;
    height: 25px;
    text-align: center;
    width: 100%;
    margin: 2% 0% 0% 0%; 
	  border-radius: 0px 0px 5px 5px;
}
#mb-2 {
    margin-bottom: 0rem !important;
    color: black;
}
.back {
    margin: 0%;
    visibility: hidden;
}
</style>