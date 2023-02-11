import { createStore } from 'vuex'

export default createStore({
  state: {
    streams:[]
  },
  getters: {
  },
  mutations: {
    GET_STREAMS(state, data){
      console.log(data);
      state.streams = data;
    }
  },
  actions: {
  },
  modules: {
  }
})
