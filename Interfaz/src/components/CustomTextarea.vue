<script setup>
import { ref, watch } from "vue";

const props = defineProps({
  id: String,
  name: String,
  label: String,
  rows: {
    type: Number,
    default: 3,
  },
  modelValue: String,
  required: Boolean,
});

const text = ref(props.modelValue || "");

watch(
    () => props.modelValue,
    (newVal) => (text.value = newVal)
);
</script>

<template>
  <div class="form-group">
    <label :for="id">{{ label }}<span v-if="required" class="required">*</span></label>
    <textarea
        :id="id"
        :name="name"
        :rows="rows"
        v-model="text"
        :required="required"
        placeholder="Escriba aquí..."
        @input="$emit('update:modelValue', text)"
    ></textarea>
  </div>
</template>

<style scoped>
.form-group {
  display: flex;
  flex-direction: column;
  gap: 6px;
}

label {
  font-weight: 600;
  color: #444;
}

textarea {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
  resize: vertical;
  font-size: 1rem;
}

.required {
  color: red;
  margin-left: 4px;
}
</style>