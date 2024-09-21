<template>
  <div class="product-detail">

    <h2>{{ product[0].name }}</h2>
    <img :src="`https://via.placeholder.com/300`" alt="Product Image" />
    <p>{{ product[0].description }}</p>
    <p>Price: {{ Number(product[0].price).toLocaleString() }}원</p>

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
  props: {
    productId: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      product: ['','',0], 
      quantity: 1,
      cartCount: 0,
    };
  },
  async created() {
    try {
      const response = await axios.get(`http://localhost:8080/api/products/${this.productId}`);
      this.product = response.data; 
      this.fetchCartCount(); // 페이지가 로드될 때 장바구니 횟수 불러오기
    } catch (error) {
      console.error(error);
    }
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
        const response = await axios.get(`http://localhost:8080/api/cart/count/${this.productId}`);
        if (response.data != null && response.data != '') this.cartCount = response.data;
      } catch (error) {
        console.error(error);
      }
    },
  },
  mounted() {
    // API 호출 등으로 productId를 기반으로 상품 데이터를 가져오는 로직 추가
    console.log(`Product ID: ${this.productId}`);
  },
};
</script>
