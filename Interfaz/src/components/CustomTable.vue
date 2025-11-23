<script setup>
import { defineProps, defineEmits } from 'vue';

defineProps({
  columns: {
    type: Array,
    required: true
  },
  data: {
    type: Array,
    required: true
  }
});
const emit = defineEmits(['edit-row', 'delete-row']);
</script>
<template>
  <table class="custom-table">
    <thead>
    <tr>
      <th v-for="column in columns" :key="column.key">
        {{ column.label }}
      </th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(item, index) in data" :key="index">
      <td v-for="column in columns" :key="column.key">
        <slot :name="column.key" :item="item" :index="index">
          {{ item[column.key] }}
        </slot>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<style scoped>
.custom-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}
.custom-table th, .custom-table td {
  border: 1px solid #ccc;
  padding: 8px;
  text-align: left;
}
.custom-table th {
  background-color: #f2f2f2;
}
</style>