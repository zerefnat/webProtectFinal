<script setup>
import {useRouter} from "vue-router"

const router = useRouter()

defineProps({
  name: {
    type: String,
    required: true
  },
  url: {
    type: String,
    required: true
  }
})

function nextRouter(url) {
  router.push(url)
}
</script>

<template>
  <p @click="nextRouter(url)">
    {{ name }}
  </p>
</template>

<style scoped>
p {
  background: none;
  border: none;
  font-size: 18px;
  color: #f4ebd1;
  cursor: pointer;
  transition: padding-left 0.2s, color 0.2s;
}

p:hover {
  padding-left: 10px;
  color: #5fb0bb;
}
</style>
