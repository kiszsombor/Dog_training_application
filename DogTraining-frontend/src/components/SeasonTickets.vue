<template>
<div class="kiskutya"></div>
</template>

<script>
export default {
    data() {
        return{
            count: count
        }
    },
    methods: {
        count() {
            console.log(this.$store.state.count)
            return this.$store.state.count
        }
    }
}
</script>
