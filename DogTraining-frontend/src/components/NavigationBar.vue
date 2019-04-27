<template>
  <header class="container-fluid">
    <div class="row">
      <div class="container">
        <div class="row">
          <h1 class="col-lg-4">
            <router-link to="/">
              <div>
                {{title}}
              </div>
            </router-link>
          </h1>
          

          <!-- <h1 class="col-lg-4" v-on:click="mainPageButtonPressed">
              {{title}}
          </h1> -->

          <!-- <nav v-for="menuItem in menuItems">
            <a href="">{{ menuItem }}</a>
          </nav> -->
          
          <nav class="col-lg-8">
            <!-- <b-card no-body>
              <b-tabs pills card>
                <b-tab v-for="menuItem in MenuItems" :key="menuItem.value"><b-card-text> {{ menuItem}} </b-card-text></b-tab>
                <b-tab title="Tab 1" active><b-card-text>Tab Contents 1</b-card-text></b-tab>
                <b-tab title="Tab 2"><b-card-text>Tab Contents 2</b-card-text></b-tab>
              </b-tabs>
            </b-card> -->
            <!-- <a v-for="menuItem in menuItems" :key="menuItem.value"> {{ menuItem }} </a> -->
            <router-link
              v-for="pageItemString in pageItemsString"
              :key="pageItemString.id"
              :to="pageItemString"
            >
              <div class ="col-lg-8">
                {{ pageItemString }}
              </div>
              
             
              <!-- <div class ="col-lg-8">
                <b-tab :title=pageItemString active="">
                  <b-card-text> {{pageItemString}} </b-card-text>
                </b-tab>
              </div> -->

            </router-link>

              <!-- <div v-if="selectedPageItemIndex === index - 1">
                {{ pageItemString }}
              </div> -->
              
            
            <!-- <a href="">menu</a>
            <a href="">menu</a>
            <a href="">menu</a>
            <a href="">menu</a> -->
          </nav>
          
        </div>
      </div>
      
      <!-- <button class= "login-button" v-on:click="loginButtonPressed">LOGIN</button> -->
      <router-link to="LoginPage">LOGIN</router-link>

      <b-navbar></b-navbar>



    </div>
  </header>
</template>

<script>

export default {

  
  name: 'NavigationBar',
  props: {
    selectedPageItemIndex: {
      type: Number,
      default: 0,
    }
  },
  data () {
    return {
      title: "Dog Training Title",
      pageItemsString: ["Page1", "Page2", "Page3", "Page4"],
      // selectedPageItemIndex: 1,
    }
  },
  methods: {
    // loginButtonPressed: function(event) {
    //   this.$router.push( '/LoginPage' )
    // },
    mainPageButtonPressed: function(event) {
      this.$router.push( '/' )
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
a{
  text-decoration: none;
    margin-left:15px;
    display:inline-block;
    padding: 10px 15px;
    color:#fff;
    /* border:10%;
    border-radius: 5%; */
}

header{
  background: #113102;
  padding: 20px 50px;
  color:#fff;
}

header h1{
  font-size:25px;
  font-weight:700px;
  text-align: left;
}

header nav{
  text-align:left;
}

button.login-button{
  margin-left:15px;
  display:inline-block;
  padding: 15px 15px;
  color:#fff;
  background-color: #113102;
  border: #113102;
  border: 10%;
  border-radius: 5%;
}

header nav a{
  margin-left:15px;
  display:inline-block;
  padding: 10px 15px;
  color:#fff;
  border:10%;
  border-radius: 5%;
  
}


header nav a:hover{
  background-color:rgb(178, 235, 202);
  color:black;
  -webkit-box-shadow: -2px 5px 71px 13px rgb(66, 63, 66);
  -moz-box-shadow: -2px 5px 71px 13px rgba(153,148,153,1);
  box-shadow: -2px 5px 71px 13px rgba(153,148,153,1);
}

/* div.selectedRouter{
  background-color: blue;
} */

</style>
