<template>
  <a-form :form="form" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }" >
    <a-form-item label="Street Name">
      <a-input v-model="form.name"/>
    </a-form-item>
    <a-form-item label="Description">
      <a-input v-model="form.description"/>
    </a-form-item>
    <a-form-item label="District">
      <a-select v-model="form.district_id">
        <a-select-option v-for="item in data" :key="item.id" :value="item.id">
          {{item.name}}
        </a-select-option>
      </a-select>
    </a-form-item>
    <a-form-item label="Status">
      <a-select v-model="form.status">
        <a-select-option :value="0">
          USING
        </a-select-option>
        <a-select-option :value="1">
          UNDER_CONSTRUCTION
        </a-select-option>
        <a-select-option :value="2">
          FIX
        </a-select-option>
      </a-select>
    </a-form-item>
    <a-form-item :wrapper-col="{ span: 12, offset: 5 }">
      <a-button type="primary" html-type="submit" @click.stop.prevent="handleSubmit">
        Submit
      </a-button>
    </a-form-item>
  </a-form>
</template>

<script>
import DistrictService from "@/service/DistrictService";
import StreetService from "@/service/StreetService";
export default {
  data() {
    return {
      data:[],
      form:{
        name: undefined,
        district_id: undefined,
        description: undefined,
        status: undefined,
      }
    };
  },
  created() {
    this.getDistrict()
  },
  methods: {
    getDistrict(){
      DistrictService.getAll().then(
          res => {
            console.log(res.data)
            this.data = res.data
          }
      )
    },
    handleSubmit(){
      StreetService.addStreet(this.form).then(
          this.$router.push("/streets/list"),
          StreetService.getAll()
      ).catch(error => {
        console.log(error)
      })
    }
  },
};
</script>

<style scoped>
</style>