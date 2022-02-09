<template>
  <div>
    <a-card>
      <div>
        <a-form @submit="handleSearch" class="product__search-form">
          <a-form-item>
            <a-input-search v-model="param.name" placeholder="Search by name">
              <a-icon type="search"/>
            </a-input-search>
          </a-form-item>
          <a-form-item>
            <a-select v-model="param.districtId" placeholder="Search by District">
              <a-select-option v-for="item in district" :key="item.id" :value="item.id">
                {{item.name}}
              </a-select-option>
            </a-select>
          </a-form-item>
        </a-form>
        <a-button type="primary" html-type="submit" @click="handleSearch">
          Search
        </a-button>
        <a-button type="primary" html-type="submit" style="margin-left: 20px" @click="resetButton">
          Reset
        </a-button>
      </div>
      <div style="padding-bottom: 20px; padding-top: 20px">
        <router-link to="/streets/add">
          <a-button type="primary" icon="plus">
            Add Street
          </a-button>
        </router-link>
        <a-table :pagination="false" :columns="columns" :data-source="data">
          <a slot="name" slot-scope="text">{{ text }}</a>
          <span slot="customTitle">Street Name</span>
          <span slot="district" slot-scope="text">
            <p>{{ text.name }}</p>
         </span>
          <div slot="action" slot-scope="text">
            <a class="button" :href="'/streets/detail/'+ text.id ">
              <a-icon style="font-size: 30px" type="info-circle"/>
            </a>&nbsp;
            <a class="button">
              <a-icon style="font-size: 30px" type="edit" theme="twoTone" />
            </a>&nbsp;
            <a class="button">
              <a-icon style="font-size: 30px" type="delete" />
            </a>
          </div>
        </a-table>
      </div>
    </a-card>
  </div>
</template>
<script>
import StreetService from "@/service/StreetService";
import DistrictService from "@/service/DistrictService";
const columns = [
  {
    dataIndex: 'name',
    key: 'name',
    slots: { title: 'customTitle' },
    scopedSlots: { customRender: 'name' },
  },
  {
    title: 'District',
    dataIndex: 'district',
    key: 'district',
    ellipsis: true,
    scopedSlots: {customRender: 'district'},
  },
  {
    title: 'Description',
    dataIndex: 'description',
    key: 'description',
  },
  {
    title: 'Created at',
    dataIndex: 'created_at',
    key: 'created_at',
  },
  {
    title: 'Status',
    key: 'status',
    dataIndex: 'status',
    scopedSlots: { customRender: 'tags' },
  },
  {
    title: 'Action',
    key: 'action',
    scopedSlots: { customRender: 'action' },
  },
];
export default {
  data() {
    return {
      data: [],
      columns,
      district: [],
      param:{
        name: undefined,
        districtId:undefined
      }
    }
  },
  created() {
    this.getStreets();
    this.getDistrict()
  },
  methods: {
    getStreets() {
      StreetService.getAll(this.param).then(
          res => {
            console.log(res.data)
            this.data = res.data
          }
      )
    },
    getDistrict() {
      DistrictService.getAll(this.param).then(
          res => {
            console.log(res.data)
            this.district = res.data
          }
      )
    },
    handleSearch(e) {
      e.preventDefault();
      this.getStreets()
    },
    resetButton() {
      this.param = {
        districtId: undefined,
        name: undefined
      }
    }
  }
}
</script>
<style scoped>
.product__search-form{
  display: grid;
  gap: 2rem;
  grid-template-columns: repeat(auto-fit,minmax(200px,1fr));
}
</style>