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
            <b-modal 
                id="modal-prevent" ref="modal"
                title="Bérlet hozzáadása"
                ok-variant="primary"
                ok-title="Hozzáadás"
                cancel-title="Mégse"
                @ok="saveNewSeasonTicket()"
                @cancel="clearSeasonTicket()"
            >
            <!-- size="lg" -->
            <!-- @shown="clearSeasonTicket" -->
            <form @submit.stop.prevent="handleSubmit">
                <b-container class="bv-example-row">
                <b-row>
                    <b-col cols="6">Érvényesség kezdete</b-col>
                    <b-col cols="6"><b-form-input type="date" v-model="seasonTicket.startDate" placeholder="Érvényesség kezdete..."></b-form-input></b-col>
                    <div class="w-100 padding"></div>
                    <b-col cols="6">Érvényesség vége</b-col>
                    <b-col cols="6"><b-form-input type="date"  v-model="seasonTicket.endDate" placeholder="Érvényesség vége..."></b-form-input></b-col>
                    <div class="w-100 padding"></div>
                    <b-col cols="6">Eddig lejárt órák száma</b-col>
                    <b-col cols="6"><b-form-input v-model="seasonTicket.classes" :state="classesState" type="number"></b-form-input></b-col>
                    <div class="w-100 padding"></div>
                    <b-col cols="6">Fizetve</b-col>
                     <b-col cols="6">
                        <b-form-group>
                            <b-form-radio-group
                                v-model="seasonTicket.paid"
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
        <div class="body" v-if="seasonTickets.length>0">
            <div>
                <table class="table">
                <thead class=" thread bg-secondary">
                    <tr>
                    <th scope="col"></th>
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
                        <td>{{moment(String(s.startDate)).format("LL")}}</td>
                        <td>{{moment(String(s.endDate)).format("LL")}}</td>
                        <td v-if="s.paid"><i class="fas fa-check"></i></td>
                        <td v-else><i class="fas fa-times"></i></td>
                        <td>10/12</td>
                        <td><b-button v-b-modal.modal-modify variant="secondary"><i class="fas fa-edit"></i></b-button></td>
                        <td><b-button v-b-modal.modal-1 variant="secondary" @click="ticketId=s.id"><i class="fas fa-trash"></i></b-button></td>
                        
                    </tr>
                    
                </tbody>
                </table>

            <b-modal id="modal-modify" ref="modal"
                title="Bérlet szerkesztése"
                ok-variant="primary"
                ok-title="Módosítás"
                cancel-title="Mégse"
                @ok="saveNewSeasonTicket()"
            >
            <!-- size="lg" -->
            <!-- @shown="clearSeasonTicket" -->
            <form @submit.stop.prevent="handleSubmit">
                <b-container class="bv-example-row">
                <b-row>
                    <b-col cols="6">Érvényesség kezdete</b-col>
                    <b-col cols="6"><b-form-input type="date"  placeholder="Érvényesség kezdete..."></b-form-input></b-col>
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
                                :options="options"
                                name="radio-inline"
                            ></b-form-radio-group>
                        </b-form-group>
                     </b-col>
                </b-row>
                </b-container>
               
            </form>
            </b-modal>

            <!-- MODAL -->
                <div>

                    <b-modal id="modal-1" title="Biztos ki szeretné törölni?" ok-title="Igen" cancel-title="Nem" @ok="deleteSeasonTicket(ticketId), showAlert()">
                        <p class="my-4">A törlés végleges! </p>
                    </b-modal>
                </div>
            </div>
        </div>


            <div v-if="seasonTickets.length<=0 && !ticketsLoading">
                    <b-card bg-variant="secondary" text-variant="white">
                        <b-card-text class="cardText">Nincs megjelenítendő bérlet</b-card-text>
                    </b-card>
            </div>
       

        <div>
            <div v-if="ticketsLoading">
                    <!-- <div v-bind:class="{ active: ticketsLoading}"> -->
                <div class="text-center mb-3 d-flex justify-content-center">
                    <b-spinner variant="primary"></b-spinner>
                </div>  
            </div>
        </div>
        



{{seasonTicket}}
<br>
{{trainer}}
<br>
{{dog}}

    </div>
  
</template>

<script>
import { mapState, mapActions } from 'vuex';
import { setTimeout } from 'timers';
import moment from 'moment'
// import BaseContainer from '@/components/base/BaseContainer'

export default {
    name: 'SeasonTicket',
    props: {

    },
    mounted() {
        moment.locale('hu')
    },
    data() {
        return {
            moment:moment,
            dogId:this.$route.params.dogId,
            title: "Bérleteim",
            ticketId:null,
            ticketsLoading:true,
            seasonTicket:{
                startDate:"",
                endDate:"",
                classes:0,
                paid: true,
            },
            // seasonTickets: this.$store.state.moduleSeasonTickets.seasonTickets,
            deleted:true,
            dismissSecs: 2,
            dismissCountDown: 0,
            
            options: [
                { text: 'Igen', value: 'true' },
                { text: 'Nem', value: 'false' },
            ]
        }
    },
    created(){
        this.getDog();
        this.getSeasonTickets();
        this.getTrainer();

        console.log(moment(this.seasonTicket.startDate).format("LL"))
        console.log("Dog ",this.dog.name)
        console.log("SeasonTicket ",this.seasonTicket)

    },
    methods: {
        ...mapActions(['getAllSeasonTicketsByDog','deleteSeasonTicketById','getDogById','getTrainerById']),
        getSeasonTickets(){
                // this.ticketsLoading=false;
            this.getAllSeasonTicketsByDog(this.dogId)
                setTimeout(() => {
                    this.ticketsLoading = false
                },0)  
        },
        deleteSeasonTicket(id){
                this.deleteSeasonTicketById(id);   
        },
        countDownChanged(dismissCountDown) {
            this.dismissCountDown = dismissCountDown
        },
        getDog(){
                this.getDogById(this.dogId);
        },
        getTrainer(){
            this.getTrainerById(1);
        },
        showAlert() {
                this.dismissCountDown = this.dismissSecs
        },
        checkSeasonTicketValues(seasonTicket){
            console.log(moment(String(seasonTicket.startDate)).isValid());
            return (moment(String(seasonTicket.startDate)).isValid() && moment(String(seasonTicket.endDate)).isValid() && this.seasonTicket.classes >= 0);      
        },
        clearSeasonTicket(){
            this.seasonTicket.startDate="";
            this.seasonTicket.endDate="";
            this.seasonTicket.classes=0;
        },
        saveNewSeasonTicket(){
                if(this.checkSeasonTicketValues(this.seasonTicket)){
                    this.$store.dispatch('addNewSeasonTicket',
                    {
                        seasonTicket: this.seasonTicket,
                        dog: this.dog
                    }) 
                    setTimeout(() => {
                        this.clearSeasonTicket()
                    },0) 
                }else{
                    alert("Sikertelen hozzáadás");
                }
            },
        },
        formatDate(date){
            moment(String(date)).format("LL");
        },
    //FIXME: csak a profil után tölti be a state-ből a kutyát
    computed: {
        ...mapState({
            seasonTickets: function (state) { return state.moduleDog.seasonTickets },
            dog: function (state) { return state.moduleDog.dog },
            trainer: function (state) { return state.moduleDog.trainer }
        }),
        classesState() {
            return this.seasonTicket.classes >= 0 ? true : false
        }
    },
    components: {
    }
}
</script>

<style scoped>
.table{
    background-color: lightblue;
}
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

.cardText{
    font-size:18px;
    /* font-weight:bold; */
}


</style>
