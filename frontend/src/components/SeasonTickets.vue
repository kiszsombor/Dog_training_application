<template>


    <div class="seasonticket-page">
        <div class="header">
            <h1 class="main-title"> {{title}} </h1>

                            <div>
                                    <b-alert v-if="deleted"
                                    class="alert-link"
                                    :show="dismissCountDown"
                                    dismissible
                                    fade
                                    variant="success"
                                    @dismissed="dismissCountDown=0"
                                    @dismiss-count-down="countDownChanged"
                                    >
                                    Sikeres törlés!  {{ dismissCountDown }} 
                                    <!-- <b-progress
                                        variant="success"
                                        :max="dismissSecs"
                                        :value="dismissCountDown"
                                        height="4px"
                                    ></b-progress> -->
                                    </b-alert>
                                
                                    <b-alert v-else
                                    class="alert-link"
                                    :show="dismissCountDown"
                                    dismissible
                                    fade
                                    variant="danger"
                                    @dismissed="dismissCountDown=0"
                                    @dismiss-count-down="countDownChanged"
                                    >
                                    Sikertelen törlés!   {{ dismissCountDown }} 
                                    
                                    </b-alert>

                    </div>
            
                <div class=" button my-3">
                    <b-button v-b-modal.modal-prevent v-b-tooltip.hover title="Új bérlet hozzáadása" variant="secondary"><i class="fas fa-plus"></i></b-button>
                </div>
                
            
            <!-- Modal Component -->
            <b-modal id="modal-prevent" ref="modal"
            title="Bérlet hozzáadása"
            ok-variant="primary"
            ok-title="Hozzáadás"
            cancel-title="Mégse"
            
            >
            <!-- @shown="clearSeasonTicket" -->
            <form @submit.stop.prevent="handleSubmit">
                <b-container class="bv-example-row">
                <b-row>
                    <b-col cols="6">Érvényesség kezdete</b-col>
                    <b-col cols="6"><b-form-input type="date" placeholder="Érvényesség kezdete..."></b-form-input></b-col>
                    <div class="w-100 padding"></div>
                    <b-col cols="6">Érvényesség vége</b-col>
                    <b-col cols="6"><b-form-input type="date"  placeholder="Érvényesség vége..."></b-form-input></b-col>
                    <div class="w-100 padding"></div>
                    <b-col cols="6">Eddig lejárt órák száma</b-col>
                    <b-col cols="6"><b-form-input type="number"></b-form-input></b-col>
                    <div class="w-100 padding"></div>
                    <b-col cols="6">Fizetve</b-col>
                     <b-col cols="6">
                        <b-form-group>
                            <b-form-radio-group
                                v-model="selected"
                                :options="options"
                                name="radio-inline"
                            ></b-form-radio-group>
                        </b-form-group>
                     </b-col>
                </b-row>
                </b-container>
               
            </form>
            </b-modal>
            <hr>

        </div>
        <div class="body">
            <div>
                <table class="table">
                <thead class=" thread bg-secondary">
                    <tr>
                    <th scope="col">#</th>
                    <th scope="col">Érvényesség kezdete</th>
                    <th scope="col">Érvényesség vége</th>
                    <th scope="col">Fizetve</th>
                    <th scope="col">Lejárt órák</th>
                    <th scope="col">Szerkesztés</th>
                    <th scope="col">Törlés</th>
                    </tr>
                </thead>
                <tbody v-for="s in seasonTickets" :key="s.id">
                    <tr>
                        <th scope="row">{{s.id}}</th>
                        <td>{{s.startDate}}</td>
                        <td>{{s.endDate}}</td>
                        <td v-if="s.paid"><i class="fas fa-check"></i></td>
                        <td v-else><i class="fas fa-times"></i></td>
                        <td>10/12</td>
                        <td><b-button variant="secondary"><i class="fas fa-edit"></i></b-button></td>
                        <td><b-button v-b-modal.modal-1 variant="secondary" ><i class="fas fa-trash"></i></b-button></td>
                        
                    </tr>
                    
                </tbody>
                </table>
                <!-- MODAL -->
                    <div>

                        <b-modal id="modal-1" title="Biztos ki szeretné törölni?" ok-title="Igen" cancel-title="Nem" @ok="showAlert">
                            <p class="my-4">A törlés végleges! </p>
                        </b-modal>
                    </div>

            </div>
            
        </div>






        
    </div>
  
</template>

<script>

import BaseContainer from '@/components/base/BaseContainer'

export default {
    name: 'SeasonTicket',
    props: {

    },
    mounted() {

    },
    data() {
        return {
            title: "Bérleteim",
            body: "Body",
            seasonTickets: this.$store.state.seasonTickets,
            deleted:true,
            dismissSecs: 2,
            dismissCountDown: 0,
            selected: 'first',
            options: [
          { text: 'Igen', value: 'yes' },
          { text: 'Nem', value: 'no' },
        ]

        }
    },
    methods: {
        countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
      },
      showAlert() {
              this.dismissCountDown = this.dismissSecs
      }
    
    },
    computed: {
        
    },
    components: {
      BaseContainer,
    }
}
</script>

<style scoped>

.seasonticket-page{
    background-color: #fff;
    padding-top:7%;
    margin-left:20%;
    margin-right:20%;
    overflow-y:auto;
    margin-bottom:5%;

}
th,td{
    text-align: center;
}
/* h1{
    
    text-align:center;
    font-weight:bold;

    color: #575555;
    font-family: arial, sans-serif;
    font-size: 28px;
    font-weight: bold;
    margin-top: 0px;
    margin-bottom: 2%;
} */

.button{
    text-align: right;
    padding-right:1%;
}

.thread{
    color:#fff;
}

.alert-link{
    transition: all .9s cubic-bezier(1.0, 0.5, 0.8, 1.0);
  /* transition: opacity .5s; */
}

 .padding{
        margin:2%;
    }

</style>
