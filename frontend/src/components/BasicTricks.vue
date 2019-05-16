<template>
  <div class="main">
    <!-- <h1>{{ msg }}</h1> -->
    <h1 class=" trick-title main-title">
        {{title}}

    </h1>
<!-- MODAL -->
                <div>

                    <b-modal id="modal-1" title="Feladat teljesítésének visszavonása" ok-title="Igen" cancel-title="Nem"  v-if="revocation" @cancel="done(basicId)">
                        <p class="my-4">Biztos vissza szeretné vonni? </p>
                    </b-modal>
                </div>
    <!-- <nav-bar-trick></nav-bar-trick> -->


    <div>
      <b-alert class="alertClass" :show="tricks.length==categoryTricks.length"  variant="success">
        <span> Gratulálunk! Az alapszint összes ({{tricks.length}}) feladatát teljesítette! <i class="far fa-smile-wink"></i> </span>
      </b-alert>
    </div>

    <div>
      <b-alert class="alertClass" :show="tricks.length!=categoryTricks.length" dismissible variant="primary">
        <span> Még {{categoryTricks.length-tricks.length}} alapszintes feladat teljesítés szükséges a továbblépéshez!</span>
      </b-alert>
    </div>
    <hr>
    <!-- <ul> -->
    <ul v-for="t in categoryTricks" :key=t.id>
      <!-- <div v-for="t in dogBasicTrick" :key=t.name>

      </div> -->

      
      <!-- <label for="r1">Change colors</label><input type="checkbox" v-model="class1" id="r1"> -->
 <li>
        <button :id="t.name" ref="COME" type="checkbox"  v-b-modal.modal-1  @click="done(t.name), basicId=t.name" v-bind:class="{class1:initColorTricks(t.name)}">
          {{t.name=="COME" ? "Gyere": t.name=="SIT" ? "Ül" : t.name=="LAY" ? "Fekszik" : t.name=="STAY" ? "Marad" : t.name}}
          </button>
      </li>
        
      <!-- <li>
        <button :id="t.name" ref="COME" type="checkbox"  v-b-modal.modal-1  @click="done(t.name), basicId=t.name" v-bind:class="{class1:initColorTricks(t.name)}">
          {{t.name=="COME" ? "Gyere": t.name=="SIT" ? "Ül" : t.name=="LAY" ? "Fekszik" : t.name=="STAY" ? "Marad" : t.name}}
          </button>
      </li> -->
      <!-- <li>
        <button id="COME" ref="COME" type="button" v-b-modal.modal-1  @click="done(BASIC.COME), basicId=BASIC.SIT" v-bind:class="{class1:initColorTricks(BASIC.COME)}">Gyere</button>
      </li>
      <li>
        <button id="SIT" ref="SIT" type="button" v-b-modal.modal-1  @click="done(BASIC.SIT), basicId=BASIC.SIT" v-bind:class="{class1:initColorTricks(BASIC.SIT)}">Ül</button>
      </li>
      <li>
        <button id="LAY" type="button" v-b-modal.modal-1  @click="done(BASIC.LAY) , basicId=BASIC.LAY" v-bind:class="{class1:initColorTricks(BASIC.LAY)}">Fekszik</button>
      </li>
      <li>
        <button id="STAY" type="button" v-b-modal.modal-1  @click="done(BASIC.STAY) , basicId=BASIC.STAY" v-bind:class="{class1:initColorTricks(BASIC.STAY)}">Marad</button>
      </li> -->
      
    </ul>
    <p><b-button class="back"><router-link :to="`/logged/${dogId}/tricks`"> VISSZA </router-link></b-button></p>


  <!-- <div v-if="allTricks.length>0">
    <ul v-for="t in allTricks" :key=t.id>
      <li>
        
            <button id="t.name" type="button" @click="done(t.name) , basicId=t.name" class="btn li button btn-lg btn-block">{{t.name}}</button>
          </li>
    </ul>
  </div> -->

<div v-for="t in saveTricks" :key=t.id>
  <div>
    {{t}}
  </div>
</div>
  <br>
  {{tricks}}
  <br>
  {{dogBasicTrickCount}}
  <br>



<!-- <button @click="initColorTricks()">Try it</button> -->
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
      dogId: this.$route.params.dogId,
      class1 : false,
      isAllAchieved:false,
      dogBasicTrickCount:0,
      revocation:false,
      isOkRevocation:false,
      basicId:null,
      //color:"lightgray",
      category:"BASIC",
      BASIC:{
        COME:'COME',
        SIT:'SIT',
        LAY:'LAY',
        STAY:'STAY',
      },
      saveTricks:[],
      saveTrick:
      {
        'id':null,
        "name": null,
        "category" :"BASIC"
      },
          
    }
  },
  created(){
  
    this.getTricksByDog();
    this.getAll_Tricks();
    this.getTricks_ByCategory();
    // this.initColorTricks();
  },
 
  methods: {
    ...mapActions(['getTricksByADog','getAllTricks','getTricksByCategory']),
 myFunction() {
  document.getElementById("demo").className='btn li button btn-lg btn-block class1';
},
    getTricksByDog(){
          this.getTricksByADog(this.dogId);
    },
    getAll_Tricks(){
      this.getAllTricks();
    },
    getTricks_ByCategory(category){
      this.getTricksByCategory(this.category);
    },
    
    initColorTricks(nameId){

      for(let i=0; i<this.tricks.length; i++){
          if(this.tricks[i].name==nameId){
            return true
          }
        }
        return false
      },
    done(nameId) {
      this.isActive = true
      // for(let i=0;i<this.dogBasicTrick.length;i++){
      //     if(this.dogBasicTrick[i].id==id){
      //         this.dogBasicTrick[i].color = 'lightgray'
      //       if(this.dogBasicTrick[i].color == 'lightgreen'){
      //         this.dogBasicTrick[i].color = 'lightgray'
      //       }
      //       if(this.dogBasicTrick[i].color == 'lightgray'){
      //         this.dogBasicTrick[i].color = 'lightgreen'
      //       }
            
      //     }
          

          //console.log(this.dogBasicTrick[i].name)
          //console.log("REF: " + this.$refs.COME)
          //console.log("REF: " + document.getElementById(nameId))
          
      //}
      
      //if(this.dogBasicTrick)
      
        // if(this.color=='lightgray'){
        //   this.color = 'lightgreen'
        // }else {
        //   this.color='lightgray'
        // }
      // if(document.getElementById(nameId).style.backgroundColor=='lightgray'){
      //   document.getElementById(nameId).style.backgroundColor='lightgreen'
      //   console.log(nameId)
      //   this.dogBasicTrick.push(nameId)
      // }else{
      //   document.getElementById(nameId).style.backgroundColor='lightgray'
      // }
      
      let sT=
      {
        'id':null,
        "name": nameId,
        "category" :"BASIC"
      };
      console.log("NAME___: ",document.getElementById(nameId).id)
      
      if(document.getElementById(nameId).className=='btn li button btn-lg btn-block'){
        document.getElementById(nameId).className='btn li button btn-lg btn-block class1'
        

         if ( this.saveTricks.includes(sT)==false) {
              this.saveTricks.push(sT);
              this.tricks.push(sT);
          }
     
        this.dogBasicTrickCount++;
        this.revocation=false;
       
      }else{
        for( let i = 0; i < this.saveTricks.length; i++){ 
          
          if ( this.saveTricks[i].name == nameId) {
            
            this.saveTricks.splice(i, 1); 
          }
        }
        
        document.getElementById(nameId).className='btn li button btn-lg btn-block'

        if(this.dogBasicTrickCount>0)
          this.dogBasicTrickCount--;
        this.revocation=true;
      }
      if(this.dogBasicTrickCount==4){
            this.isAllAchieved=true;
         }
      
      
    },
},

    

  computed:{
    ...mapState({
            tricks: function (state) { return state.moduleDog.tricks },
            allTricks: function (state) { return state.moduleDog.allTricks },
            categoryTricks: function (state) { return state.moduleDog.categoryTricks },
            dog: function (state) { return state.moduleDog.dog }
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
	  /* background-image: url('../assets/china.png');
	  background-repeat: repeat;
	  background-attachment: fixed; */
}
/* .title {
	  background-color: skyblue;
    background-image: url('../assets/paw.png');
	  background-repeat: no-repeat;
	  background-position: 2% 50%;
	  background-size: 5%;
    padding: 0.1%;
    text-indent: 5%;
    font-weight: normal;
} */

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
    /* background-image: url('../assets/china.png'); */
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
    /* background-color: gray; */
    color: white;
    /* background-image: url('../assets/tennisball.png'); */
	  background-repeat: no-repeat;
	  background-position: 40% 50%;
    background-size: 5%;
}
.class1 {
    background-color: lightgreen;
    color: black;
    /* background-image: url('../assets/tennisball.png'); */
	  background-repeat: no-repeat;
	  background-position: 40% 50%;
    background-size: 5%;
    border: none;
}
.back {
    text-align: center;
    background-color: #606060;
    margin-left: auto;
    margin-right: auto;
    font-family: Arial, sans-serif;
    /* visibility: hidden; */
}
p {
    text-align: center;
}
a{
    background-color: #606060;
    border-color: #606060;
    text-decoration: none;
    color: white;
}
a:hover {
    background-color: #606060;
    color: skyblue;
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