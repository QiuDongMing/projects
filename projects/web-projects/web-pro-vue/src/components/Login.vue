<template>
  <div id="login">
    <el-row class="is-center" style="width: 500px" >
      <el-form>
        <el-form-item>用户登录</el-form-item>
        <el-form-item>
          <el-input placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="success">登录</el-button>
        </el-form-item>
      </el-form>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: "Loign"
  }
</script>

<style scoped>

</style>
