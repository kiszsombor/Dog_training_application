<template>
<header class="container-fluid">
  <div class="row">
    <div class="container">
      <div class="row">
        <h1 class="col-lg-4">DogTraining

        </h1>
        <nav class="col-lg-8">
          <a href="">menu</a>
          <a href="">menu</a>
          <a href="">menu</a>
          <a href="">menu</a>
        </nav>
      </div>
    </div>
  </div>
</header>
</template>

<script>

export default {

  
  name: 'Header',
  data () {
    return {
      
    }
  },
  components:{
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
a{
  text-decoration: none;
}

header{
  background: #113102;
  padding: 20px 0px;
  color:#fff;
}

header h1{
  font-size:25px;
  font-weight:700px;
  text-align: left;
}

header nav{
  text-align:right;
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

</style>
