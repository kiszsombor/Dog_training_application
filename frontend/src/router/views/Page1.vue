<template>
  <div class="pages">
    <!-- <BaseContainer :headerTitle="title"></BaseContainer> -->
    <h1 class="main-title">
      {{title}}
      </h1> 
        
  <div class="card">
  <b-card

    header-text-variant="white"
    header-bg-variant="secondary"

    bg-variant="light"
    
    tag="article"
    style="max-width: 100%;"
    class="mb-2"
  >
  <div slot="header">
        <b-row bg-variant="dark" >
          <b-col cols="10">
          <h3>{{dog.name}}</h3>
          </b-col>
             <b-col cols="1"> <b-button variant="dark" v-b-tooltip.hover title="Profil szerkesztése"><i class="fas fa-edit"></i></b-button></b-col>
              <b-col cols="1"> <b-button v-b-modal.modal-1 variant="dark" v-b-tooltip.hover title="Profil törlése"><i class="fas fa-trash"></i></b-button></b-col>
        </b-row>
      </div>
    <b-card-text>
    <b-container fluid class="bv-example-row">
        <b-row class="datas">
            <div class="w-100"></div>
          
          <b-col cols="6">Születési dátum </b-col>
          <b-col cols="6">{{dog.birthDate}}</b-col>
              <div class="w-100"></div>
          <b-col cols="6">Fajta </b-col>
          <b-col cols="6">{{dog.breed}}</b-col>
              <div class="w-100"></div>
          <b-col cols="6">Súly </b-col>
          <b-col cols="6">{{dog.weight}}</b-col>
              <div class="w-100"></div>
              <br>
                  
              <b-col cols="12">
                <hr>
                  
                  
                {{dog.description}}</b-col>

        </b-row>
      </b-container>    
      </b-card-text>
      <!-- <div slot="footer">
        <b-row>
             <b-col cols="6"> <b-button href="#" class="foot" variant="primary">Szerkesztés</b-button></b-col>
              <b-col cols="6"><b-button href="#" class="foot" variant="primary">Törlés</b-button></b-col>
        </b-row>
      </div> -->


  </b-card>
</div>

<!-- MODAL -->
                    <div>

                        <b-modal id="modal-1" title="Biztos ki szeretné törölni?" ok-title="Igen" cancel-title="Nem" @ok="showAlert">
                            <p class="my-4">A törlés végleges! </p>
                        </b-modal>
                    </div>
  </div>
  
</template>

<script>

import BaseContainer from '@/components/base/BaseContainer'

export default {
    name: 'Page1',
    props: {

    },
    mounted() {

    },
    data() {
        return {
            title: "Profilom",
            dog: this.$store.state.dogs[0]
        }
    },
    methods: {
        
    },
    computed: {
        
    },
    components: {
      BaseContainer,
    }
}
</script>

<style scoped>

.w-100{
  padding-bottom: 2%;
}
.datas{
  font-size:22px;
}

</style>