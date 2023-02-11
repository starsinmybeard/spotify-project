<template>
    <div class="container">
        <div class="button">
            <button v-on:click.once="fillDatabase()">Fill Database</button>
            <button v-on:click.once="fillChart()">Display Streams</button>
        </div>

        <div class="search">
            <label for="artistName" class="search">
                <input type="text">
                <button>search for streams from an artist</button>
            </label>
        </div>
        
        <div class="stream">
            <stream-row 
             v-for="stream in this.streams" 
                v-bind:key="stream.master_metadata_track_name"
                :master_metadata_track_name="stream.master_metadata_track_name"
                :master_metadata_album_artist_name="stream.master_metadata_album_artist_name"
                :timeStamp="stream.timeStamp"> 
            </stream-row>   
    
            
        </div>
    </div>
  

</template>




<script>
import StreamsService from "../services/StreamsService";
import StreamRow from "../components/StreamRow.vue";
export default {

    name: "HomePage",
    data(){
        return{
            streams: {}
        }
    },
    methods:{
        fillDatabase(){
            StreamsService.fillDbFromFile();
        },
        fillChart(){
            console.log("37");
            StreamsService.getAllStreams().then((response) => {
                const fromDb = response.data;
                this.streams = Object.freeze(fromDb);

                // this.$store.commit("GET_STREAMS", response.data);
            })
        }
    },
    components: {
        StreamRow,
    },
    created() {
        
    }, 
    computed(){

    }
}
</script>



<style>
.search{
    margin: 20px;
    padding: 20px;
}

</style>