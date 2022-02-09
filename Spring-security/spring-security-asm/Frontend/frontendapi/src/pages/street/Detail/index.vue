<template>
  <a-form :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }" :datasrc="data">
    <a-form-item label="Street Name" >
      <a-input v-model="data.name" disabled/>
    </a-form-item>
    <a-form-item  label="District">
      <a-input v-model="data.district.name" disabled/>
    </a-form-item>
    <a-form-item label="Description">
      <a-input v-model="data.description" disabled />
    </a-form-item>
    <a-form-item label="Create_at">
      <a-input v-model="data.created_at" disabled />
    </a-form-item>
    <a-form-item label="Status">
      <a-input v-model="data.status" disabled />
    </a-form-item>

    <a-form-item :wrapper-col="{ span: 12, offset: 5 }">
      <a-button type="primary" html-type="submit" @click.stop.prevent="backBtn">
        Back
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
      data:{},
      params:undefined,
      district:{}
    };
  },
  created() {
    this.params = this.$router.currentRoute.params.id
    this.getDetail()
  },
  methods: {
    getDistrict(){
      DistrictService.getAll().then(
          res => {
            console.log(res.data)
            this.data = res.data
            this.district = res.data.district
          }
      )
    },
    getDetail(){
      StreetService.detail(this.params).then(
          res =>{
            console.log(res.data)
            this.data = res.data
          }
      )
    },
    backBtn(){
      this.$router.push("/streets/list")
    }
  },
};
</script>

<style scoped>
</style>