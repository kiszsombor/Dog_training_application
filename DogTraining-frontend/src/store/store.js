const store = new Vuex.Store({
    state: {
      count: 15
    },
    mutations: {
      increment (state) {
        state.count++
      }
    }
  })

  export const store;