<template>
  <router-view :productId="$route.params.productId" />
</template>

<script>
export default {
  data() {
    return {
      product: {
        id: 1,
        name: 'Sample Product',
        image: 'https://via.placeholder.com/300',
        description: 'This is a sample product description.',
        price: 100,
      },
    };
  },
};
</script>

<style scoped>
.product-detail {
  text-align: center;
}

img {
  width: 300px;
  height: 300px;
}

input[type="number"] {
  width: 50px;
  text-align: center;
}

button {
  margin-top: 10px;
  padding: 10px 20px;
  background-color: blue;
  color: white;
  border: none;
  cursor: pointer;
}
</style>
