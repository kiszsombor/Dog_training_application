<template>
  <div class="main">
    <!-- <h1>{{ msg }}</h1> -->
    <h1 class=" trick-title main-title">
      {{title}}

    </h1>
<!-- MODAL -->
  <div>

      <b-modal id="modal-1" :title="modalTitle" ok-title="Igen" cancel-title="Nem"  @ok="done(basicId,selectedTrickId)">
          <p class="my-4">Biztos ez? </p>
      </b-modal>
<!-- 
      <b-modal id="modal-2" title="Feladat teljesítése" ok-title="Igen" cancel-title="Nem"  v-if="isSave" @ok="done(basicId,selectedTrickId)">
          <p class="my-4">Biztos vissza szeretné vonni? </p>
      </b-modal> -->
  </div>
    <div>
      <b-alert class="alertClass" :show="getTricksByDogByCategory(category)==categoryTricks.length"  variant="success">
        <span> Gratulálunk! Az alapszint összes ({{categoryTricks.length}}) feladatát teljesítette! Továbbléphet a 
          <router-link class="router" :to="`/logged/${trainerId}/${dogId}/kozepszint`">középszintre</router-link>.<i class="far fa-smile-wink"></i> </span>
      </b-alert>
    </div>

    <div>
      <b-alert class="alertClass" :show="getTricksByDogByCategory(category)!=categoryTricks.length" dismissible variant="primary">
        <span> Még {{categoryTricks.length-getTricksByDogByCategory(category)}} alapszintes feladat teljesítés szükséges a továbblépéshez!</span>
      </b-alert>
    </div>
    <hr>
    <ul v-for="t in categoryTricks" :key=t.id>
      <li>
        <button :id="t.name" ref="COME" type="checkbox" v-b-modal.modal-1  @click=" basicId=t.name, selectedTrickId=t.id" v-bind:class="{class1:initColorTricks(t.name)}">
          {{t.name=="COME" ? "Gyere": t.name=="SIT" ? "Ül" : t.name=="LAY" ? "Fekszik" : t.name=="STAY" ? "Marad" : t.name}}
          </button>
      </li>
    </ul>
    <p><b-button class="back"><router-link :to="`/logged/${trainerId}/${dogId}/tricks`"> VISSZA </router-link></b-button></p>
    <!-- <div>{{tricks}}</div> -->
    <div>{{getTricksByDogByCategory(category)}}</div>
  </div>

</template>

<script>
import { mapState, mapActions } from 'vuex';
export default {
  name: 'BasicTricks',
    components: {

    }
  ,
  data () {
    return {
      title: "Alapszint",
      trainerId: this.$route.params.trainerId,
      dogId: this.$route.params.dogId,
      class1 : false,
      isAllAchieved:false,
      isDelete:false,
      isSave:false,
      revocation:false,
      isOkRevocation:false,
      modalTitle:"ModalTitle",
      basicId:null,
      selectedTrickId:null,
      category:"BASIC",
      basicTricks:[],
      BASIC:{
        COME:'COME',
        SIT:'SIT',
        LAY:'LAY',
        STAY:'STAY',
      }, 
    }
  },
  created(){
    this.getTricksByDog();
    this.getAll_Tricks();
    this.getTricks_ByCategory();
    this.getTricksByDogByCategory(this.category);  
    },
 
  methods: {
    ...mapActions(['getTricksByADog','getAllTricks','getTricksByCategory', 'deleteDogTricksByDogIdAndTrickId', 'addDogTricks','getTricksByADogAndCategory']),
    getTricksByDog(){
          this.getTricksByADog(this.dogId);
          // this.basicTrick();
    },
    getAll_Tricks(){
      this.getAllTricks();
    },
    getTricks_ByCategory(category){
      this.getTricksByCategory(this.category);
    },
    saveDogTricks(trickId){
      this.addDogTricks({dogId:this.dogId, trickId:trickId});
    },
    deleteDogTricks_ByDogIdAndTrickId(trickId){
      this.deleteDogTricksByDogIdAndTrickId({dogId:this.dogId, trickId:trickId});
    },
    getTricksBy_DogAndCategory(){
      this.getTricksByADogAndCategory({dogId:this.dogId, category:this.category});
    },

    getTricksByDogByCategory(trickCategory){
      var count=0;
      this.tricks.forEach(function(element) {
        if(element.category==trickCategory){
          count++;
          
        }
      });
      return count;
    },
    // basicTrick(){
    //   for(let i=0;i<this.tricks.length;i++){
    //     if(this.tricks[i].category == this.category){
    //       this.basicTricks.push(this.tricks[i])
    //       console.log(this.categoryTricks);
    //     }
    //   }
    // },
    
    initColorTricks(nameId){

      for(let i=0; i<this.tricks.length; i++){
          if(this.tricks[i].name==nameId){
            return true
          }
        }
        return false
      },
      
    done(nameId, trickId) {
      if(this.tricks.length == 0){
            this.isSave = true;
            this.saveDogTricks(trickId);
      }

      for(let i=0;i<this.tricks.length;i++){
        if(this.tricks[i].id == trickId){
          this.isDelete = true;
          this.deleteDogTricks_ByDogIdAndTrickId(trickId);
        } else {
            this.isSave = true;
            this.saveDogTricks(trickId);
          }
      }
    },
},
  computed:{
    ...mapState({
            tricks: function (state) { return state.moduleDog.tricks },
            allTricks: function (state) { return state.moduleDog.allTricks },
            categoryTricks: function (state) { return state.moduleDog.categoryTricks },
            dog: function (state) { return state.moduleDog.dog },
            dogTricksCategory: function (state) { return state.moduleDog.dogTricksCategory },
        }),
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.main {
    max-width: 1200px;
    min-width: 300px;
    margin: auto;
    text-align:center;
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
    background-repeat: repeat;
    background-attachment: fixed;
}
li{
    text-align: center;
    list-style-type: none;
    padding: 2% 0% 2% 0%;
}
li button{
    font-size: 120%;
    display: inline-block;
    width: 80%;
    padding: 3% 0% 3% 0%;
    background-color: lightgray;
    text-decoration: none;
    color: black;
    border-radius: 5px 5px 5px 5px;
    border: none;
}
li button:hover {
    color: white;
    background-repeat: no-repeat;
    background-position: 40% 50%;
    background-size: 5%;
}
.class1 {
    background-color: lightgreen;
    color: black;
    background-repeat: no-repeat;
    background-position: 40% 50%;
    background-size: 5%;
    border: none;
}
.back{
    text-align: center;
    background-color: #606060;
    margin-left: auto;
    margin-right: auto;
    font-family: Arial, sans-serif;
}
.back a {
    text-decoration: none;
    color: white;
}
.back a:hover {
    color: skyblue;
    text-decoration: none;
} 
p {
    text-align: center;
}
.router{
    font-size: 120%;
    color: #155724;
}
.router:hover {
    color: black;
    text-decoration: none;
}
.alertClass{
    font-size: 100%;
    display: inline-block;
    width: 80%;
    text-align: center;
    text-decoration: none;
}
.far{
    padding-left:1%;
}
</style>