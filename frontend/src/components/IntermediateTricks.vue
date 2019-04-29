<template>
  <div class="main">
    <!-- <h1>{{ msg }}</h1> -->
    <div class="title">
        <h2>Képzés</h2>
    </div>
    <!-- <nav-bar-trick></nav-bar-trick> -->
    <ul>
      <li>
        <button type="button" class="btn li button btn-lg btn-block">Figyelj</button>
      </li>
      <li>
        <button type="button" class="btn li button btn-lg btn-block">Hagyd</button>
      </li>
      <li>
        <button type="button" class="btn li button btn-lg btn-block">Séta pórázon</button>
      </li>
      <li>
        <button type="button" class="btn li button btn-lg btn-block">Séta lábnál</button>
      </li>
    </ul>
    <p class="back"><router-link to="/TrickPage"> VISSZA </router-link></p>
  </div>
</template>

<script>
// import NavBarTrick from './NavBarTrick'

export default {
  name: 'IntermediateTricks',
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
li button {
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
    background-color: gray;
    color: white;
    /* background-image: url('../assets/tennisball.png'); */
	  background-repeat: no-repeat;
	  background-position: 40% 50%;
    background-size: 5%;
}
li button:active {
    background-color: lightgreen;
    color: white;
    /* background-image: url('../assets/tennisball.png'); */
	  background-repeat: no-repeat;
	  background-position: 40% 50%;
    background-size: 5%;
    border: none;
}
.back {
    padding-top: 4%;
    background-color: #606060;
    margin: auto;
    font-family: Arial, sans-serif;
    font-size: 130%;
    /* visibility: hidden; */
}
a{
    background-color: #606060;
    border-color: #606060;
    text-decoration: none;
    color: white;
}
a:hover {
    background-color: #606060;
    border-color: #606060;
    color: skyblue;
	  background-repeat: no-repeat;
	  background-position: 43% 50%;
    background-size: 5%;
}
</style>