<template>
  <div class="product-detail">
    <h2>{{ product.name }}</h2>
    <img :src="`https://via.placeholder.com/300`" alt="Product Image" />
    <p>{{ product.description }}</p>
    <p>Price: {{ Number(product.price).toLocaleString() }}원</p>

    <!-- 옵션 선택 -->
    <div v-if="options.length > 0">
      <label for="product-option">Option:</label>
      <select v-model="selectedOption">
        <option v-for="option in options" :key="option" :value="option">
          {{ option }} 
        </option>
      </select>
    </div>

    <br>
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
      product: {},
      options: [],
      selectedOption: '', 
      quantity: 1,
      cartCount: 0,
    };
  },
  async created() {
    try {
      const response = await axios.get(`http://localhost:8080/api/products/${this.productId}`);
      
      // 첫 번째 아이템의 상품 정보를 가져오고, 옵션만 별도로 추출
      this.product = {
        id: response.data[0][0],
        description: response.data[0][1],
        name: response.data[0][2],
        price: response.data[0][3],
      };
      
      // 옵션만 배열로 추출
      this.options = response.data.map(item => item[4]);

      // 첫 번째 옵션을 기본으로 설정
      if (this.options.length > 0) {
        this.selectedOption = this.options[0];
      }

      this.fetchCartCount(); // 페이지가 로드될 때 장바구니 횟수 불러오기
    } catch (error) {
      console.error(error);
    }
  },
  methods: {
    async addToCart() {
        const cartItem = {
          productId: this.product.id, // 상품 번호
          option: this.selectedOption || null, // 옵션이 없을 경우 null로 처리
          quantity: this.quantity, // 상품 수량
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
