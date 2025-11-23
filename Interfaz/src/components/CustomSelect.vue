<script setup>
import { ref, watch } from "vue";

const props = defineProps({
  id: String,
  name: String,
  label: String,
  options: Array,
  modelValue: String,
  required: Boolean,
  placeholder: {
    type: String,
    default: "Seleccione una opción",
  },
});

const emits = defineEmits(["update:modelValue"]);

const selected = ref(props.modelValue || "");

watch(
    () => props.modelValue,
    (newVal) => (selected.value = newVal)
);

function emitChange() {
  emits("update:modelValue", selected.value);
}
</script>

<template>
  <div class="form-group">
    <label :for="id">{{ label }}<span v-if="required" class="required">*</span></label>
    <select
        :id="id"
        :name="name"
        v-model="selected"
        @change="emitChange"
        :required="required"
    >
      <option value="">{{ placeholder }}</option>
      <option
          v-for="(option, index) in options"
          :key="index"
          :value="option.value"
      >
        {{ option.text }}
      </option>
    </select>
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

select {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
  font-size: 1rem;
}

.required {
  color: red;
  margin-left: 4px;
}
</style>