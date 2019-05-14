<template>
  <div class="main">
    <!-- <h1>{{ msg }}</h1> -->
    <h1 class=" trick-title main-title">
        {{title}}
        
    </h1>
    <!-- <nav-bar-trick></nav-bar-trick> -->


    <div>
      <b-alert class="alertClass" :show="dogBasicTrickCount==4"  variant="success">
        <span> Gratulálunk! Az alapszint összes feladatát teljesítette! <i class="far fa-smile-wink"></i> </span>
      </b-alert>
    </div>

    <div>
      <b-alert class="alertClass" :show="dogBasicTrickCount!=4" dismissible variant="primary">
        <span> Még {{4-dogBasicTrickCount}} alapszintes feladat teljesítés szükséges a továbblépéshez!</span>
      </b-alert>
    </div>
    <hr>
    <ul >
      <div v-for="t in dogBasicTrick" :key=t.name>

      </div>

      
      <!-- <label for="r1">Change colors</label><input type="checkbox" v-model="class1" id="r1"> -->
      <li>
        <button id="COME" ref="COME" type="checkbox"   @click="done(BASIC.COME)" class="btn li button btn-lg btn-block">Gyere</button>
      </li>
      <li>
        <button id="SIT" ref="SIT" type="button"   @click="done(BASIC.SIT)" class="btn li button btn-lg btn-block">Ül</button>
      </li>
      <li>
        <button id="LAY" type="button"   @click="done(BASIC.LAY)" class="btn li button btn-lg btn-block">Fekszik</button>
      </li>
      <li>
        <button id="STAY" type="button"   @click="done(BASIC.STAY)" class="btn li button btn-lg btn-block">Marad</button>
      </li>
      
    </ul>
    <p><b-button class="back"><router-link :to="`/logged/${dogId}/tricks`"> VISSZA </router-link></b-button></p>

<!-- <ul v-for="t in dogBasicTrick" :key=t.name>
  <li>
        <button id="t.name" type="button" :style="{ 'background-color': color }"  @click="done()" class="btn li button btn-lg btn-block">{{t.name}}</button>
      </li>
</ul> -->

  <br>
  <br>
  </div>

</template>

<script>
// import NavBarTrick from './NavBarTrick'

export default {
  name: 'BasicTricks',
    components: {
        // 'nav-bar-trick': NavBarTrick
    }
  ,
  data () {
    return {
      title: "Alapszint",
      dogId: this.$route.params.dogId,
      class1 : false,
      isAllAchieved:false,
      dogBasicTrickCount:0,
      //color:"lightgray",
      BASIC:{
        COME:'COME',
        SIT:'SIT',
        LAY:'LAY',
        STAY:'STAY',
      },

      
      
      dogBasicTrick:[

        {
          'id': 1,
          "name": "COME",
          "category" :"BASIC"
        },
        {
          'id': 2,
          "name": "LAY",
          "category" :"BASIC"
        }
      ]
          
      
    }
  },
  created(){
    this.checkIsAllGreen();
  },
 
  methods: {
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

      if(document.getElementById(nameId).className=='btn li button btn-lg btn-block'){
        document.getElementById(nameId).className='btn li button btn-lg btn-block class1'
        this.dogBasicTrickCount++;
        //console.log(nameId)

        
      }else{
        document.getElementById(nameId).className='btn li button btn-lg btn-block'
        this.dogBasicTrickCount--;
      }
      console.log(this.dogBasicTrickCount);
      if(this.dogBasicTrickCount==4){
            this.isAllAchieved=true;
         }
      
      
    },

    checkIsAllGreen(){
        //for(let i=0;i<this.BASIC.length;i++){
         // if(document.getElementById("COME").style.backgroundColor=='lightgreen'){
              console.log(this.dogBasicTrickCount);
              
         // }
        //  if(this.dogBasicTrickCount==4){
        //     this.isAllAchieved=true;
        //  }

       // }
    }
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