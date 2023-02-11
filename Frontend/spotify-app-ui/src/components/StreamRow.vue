<template>

    <div class="row">
        <div class="stat" id="">
            <h2>{{ master_metadata_track_name }}</h2></div>
        <div class="stat" id=""><h3>{{ master_metadata_album_artist_name }}</h3></div>
        
    </div>
  
</template>

<script>

export default {
    name:"StreamRow",
    props:[
        "master_metadata_track_name",
        "master_metadata_album_artist_name",
        
    ]

}
</script>

<style>
    .roq{
        display: flex;
        flex-direction: column;
    }



</style>