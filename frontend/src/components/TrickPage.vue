<template>
  <div class="main">
    <!-- <h1>{{ msg }}</h1> -->
    <div class="title">
        <h2>Képzés</h2>
    </div>
    <!-- <nav-bar-trick></nav-bar-trick> -->
    <ul>
      <li class="basic">
        <router-link to="/alapszint"> Alapszint 
          <b-progress id="progress" :max="max"><b-progress-bar id="mb-2" :value="values[0]" class="mb-2">{{values[0]}}/{{max}}</b-progress-bar></b-progress>
        </router-link>
      </li>
      <li class="intermediate">
        <router-link to="/kozepszint"> Középszint
          <b-progress id="progress" :max="max"><b-progress-bar id="mb-2" :value="values[1]" class="mb-2">{{values[1]}}/{{max}}</b-progress-bar></b-progress>
        </router-link>
      </li>
      <li class="advanced">
        <router-link to="/haladoszint"> Haladó szint
          <b-progress id="progress" :max="max"><b-progress-bar id="mb-2" :value="values[2]" class="mb-2">{{values[2]}}/{{max}}</b-progress-bar></b-progress>
        </router-link>
      </li>
    </ul>
    <p class="back"><router-link to="/tricks"> VISSZA </router-link></p>
  </div>
</template>

<script>
// import NavBarTrick from './NavBarTrick'
export default {
  name: 'TrickPage'
  ,
  data() {
      return {
        max: 3,
        values: [3, 1, 0]
      }
    },
  components: {
      // 'nav-bar-trick': NavBarTrick
    }
  // ,
  // data () {
  //   return {
  //     msg: 'Welcome to Your Vue.js App'
  //   }
  // }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 .main {
    max-width: 1200px;
	  min-width: 300px;
    margin: auto;
	  /* background-image: url('../assets/china.png');
	  background-repeat: repeat;
	  background-attachment: fixed; */
    text-align: center;
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
    /* background-image: url('../assets/china.png');
    background-repeat: repeat;
    background-attachment: fixed; */
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
    /* background-image: url('../assets/tennisball.png'); */
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

/* .nav {
  text-align: justify;
} */
</style>