<template>
  <div class="product-detail">
    <h2>{{ product.name }}</h2>
    <img :src="product.image" alt="Product Image" />
    <p>{{ product.description }}</p>
    <p>Price: {{ product.price }} USD</p>

    <div>
      <label for="quantity">Quantity:</label>
      <input type="number" id="quantity" v-model="quantity" min="1" />
    </div>

    <br>
    <p>최근 장바구니에 담긴 횟수: {{cartCount}}번</p>

    <button @click="addToCart">Add to Cart</button>
  </div>
</template>

<script>
import axios from 'axios';

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
      quantity: 1,
      cartCount: 0
    };
  },
  methods: {
    async addToCart() {
        const cartItem = {
          productId: this.product.id,
          quantity: this.quantity,
        };
        await axios.post('/api/cart', cartItem)
              .then(response => {
                  console.log(response.data);
                  this.cartCount++;
              })
              .catch(error => {
                  console.error(error);
              });
        alert('Product added to cart!');
    },
    async fetchCartCount() {
      try {
        const response = await axios.get(`/api/cart/count/${this.product.id}`);
        if (response.data != null && response.data != '') this.cartCount = response.data;
      } catch (error) {
        console.error(error);
      }
    }
  },
  created() {
    this.fetchCartCount(); // 페이지가 로드될 때 장바구니 횟수 불러오기
  }
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
