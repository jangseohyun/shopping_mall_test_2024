const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
module.exports = {
  // npm run build 타겟 디렉토리
  outputDir: '../src/main/resources/static',
  // npm run serve 개발 진행 시 포트가 다르기 때문에 프록시 설정
  devServer: {
    proxy: 'http://localhost:8080'
  }
};