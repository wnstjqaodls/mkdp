<template>
  <div id="app">
    <Member-info></Member-info>

  </div>
</template>

<script>
import MemberInfo from './components/MemberInfo.vue'

export default {
  name: 'App',
  components: {
    MemberInfo,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
