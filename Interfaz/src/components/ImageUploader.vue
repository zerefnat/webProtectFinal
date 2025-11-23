<script setup>
import { ref, onBeforeUnmount } from "vue";

const fileInput = ref(null);
const previewImages = ref([]);
const objectUrls = [];

const emit = defineEmits(["update:urls"]);

const openFileDialog = () => {
  fileInput.value.click();
};

const handleFiles = (event) => {
  const files = Array.from(event.target.files);
  previewImages.value = [];
  objectUrls.forEach((url) => URL.revokeObjectURL(url));
  objectUrls.length = 0;

  for (const file of files) {
    const url = URL.createObjectURL(file);
    previewImages.value.push(url);
    objectUrls.push(url);
  }
  emit("update:urls", previewImages.value);
};
onBeforeUnmount(() => {
  objectUrls.forEach((url) => URL.revokeObjectURL(url));
});
</script>

<template>
  <div class="uploader" @click="openFileDialog">
    <input
        type="file"
        ref="fileInput"
        accept="image/*"
        multiple
        @change="handleFiles"
    />

    <div v-if="!previewImages.length" class="upload-placeholder">
      <svg
          xmlns="http://www.w3.org/2000/svg"
          class="icon"
          viewBox="0 0 24 24"
          fill="none"
          stroke="currentColor"
          stroke-width="2"
          stroke-linecap="round"
          stroke-linejoin="round"
      >
        <line x1="12" y1="5" x2="12" y2="19" />
        <line x1="5" y1="12" x2="19" y2="12" />
      </svg>
      <p>Haz clic o arrastra imágenes aquí</p>
    </div>

    <div v-else class="preview-container">
      <div v-for="(img, index) in previewImages" :key="index" class="preview">
        <img :src="img" alt="preview" />
      </div>
    </div>
  </div>
</template>

<style scoped>
.uploader {
  width: 100%;
  max-width: 350px;
  height: 200px;
  background-color: #fffaf0;
  border: 2px dashed #ccc;
  border-radius: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  cursor: pointer;
  transition: border-color 0.3s ease;
}

.uploader:hover {
  border-color: #999;
}

.uploader input[type="file"] {
  display: none;
}

.upload-placeholder {
  text-align: center;
  color: #888;
}

.icon {
  width: 40px;
  height: 40px;
  color: #666;
  margin-bottom: 8px;
}

.preview-container {
  display: flex;
  gap: 8px;
  flex-wrap: wrap;
  justify-content: center;
  padding: 8px;
}

.preview img {
  width: 80px;
  height: 80px;
  border-radius: 8px;
  object-fit: cover;
  box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
}
</style>