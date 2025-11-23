<script setup>
import Header from "@/components/Header.vue";
</script>

<template>
  <div class="layout">
    <Header />
    <main class="main-content">
      <router-view />
    </main>
  </div>
</template>

<style scoped>
.main-content {
  margin-top: 100px;
}
</style>

