<template>
  <div class="content-container">
    <div class="header-section">
        <el-input v-model="searchForm.keyword" placeholder="请输入昵称" class="filter-input" :prefix-icon="Search" clearable></el-input>
        <el-button class="ml-10" plain type="primary" @click="load">搜索</el-button>
        <el-button plain type="info" @click="reset">重置</el-button>
    </div>

    <div class="toolbar-section">
        <el-button plain type="primary" @click="handleAdd" :icon="Plus">新增</el-button>
        <el-button plain type="danger" @click="confirmBatchDelete" :icon="Delete">批量删除</el-button>
    </div>
    <el-card>
        <el-table :data="tableData" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="60" align="center" />
            <el-table-column prop="id" label="ID" width="80" align="center" />
            <el-table-column prop="username" label="用户名" />
            <el-table-column prop="nickname" label="昵称" />
            <el-table-column prop="email" label="邮箱" />
            <el-table-column prop="phone" label="电话" />


            <el-table-column width="100" label="头像" align="center">
                <template #default="scope">
                    <el-avatar :size="60" :src="scope.row.avatarUrl" />
                </template>
            </el-table-column>

            <el-table-column width="120" label="操作" align="center" fixed="right">
                <template #default="scope">
                    <el-tooltip content="编辑" placement="top" :effect="'light'" >
                        <el-button circle type="primary" :icon="Edit" @click="handleEdit(scope.row)"></el-button>
                    </el-tooltip>
                    <el-tooltip content="删除" placement="top" :effect="'light'" >
                        <el-button circle type="danger" :icon="Delete" @click="confirmDelete(scope.row.id)"></el-button>
                    </el-tooltip>
                </template>
            </el-table-column>
        </el-table>

        <div class="pagination-section">
            <el-pagination
                :current-page="pageNum"
                :page-size="pageSize"
                :page-sizes="[10, 20, 50, 100]"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total"
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                ></el-pagination>
        </div>
    </el-card>

    <el-dialog v-model="dialogFormVisible" :title="form.id ? '编辑' : '新增'" width="30%" destroy-on-close center>
        <el-form :model="form" label-width="100px">
            <el-form-item label="头像" required>
                <div class="upload-container">
                    <el-avatar v-if="form.avatarUrl" :src="form.avatarUrl" :size="80" />
                    <el-upload :action="`${serverHost}/web/upload`" :on-success="handleAvatarUrlUploadSuccess" :show-file-list="false">
                        <el-button type="primary" :icon="UploadFilled">{{form.avatarUrl ? '更换图片' : '上传图片' }}</el-button>
                    </el-upload>
                </div>
            </el-form-item>
            <el-form-item label="用户名" required>
                <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码" required>
                <el-input v-model="form.password" show-password placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item label="昵称" required>
                <el-input v-model="form.nickname" placeholder="请输入昵称"></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
                <el-input v-model="form.email" placeholder="请输入邮箱"></el-input>
            </el-form-item>
            <el-form-item label="电话">
                <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
            </el-form-item>
        </el-form>

        <template #footer>
            <div class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取消</el-button>
                <el-button type="primary" @click="save">确定</el-button>
            </div>
        </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ElMessage, ElMessageBox } from "element-plus"
import { reactive, ref } from "vue"
import request from '../../utils/request'
import { Delete, Edit, Plus, UploadFilled, Search  } from '@element-plus/icons-vue'
import { serverHost } from '../../../config/config.default'

 const tableData = ref([])
 const total = ref(0)
 const pageNum = ref(1)
 const pageSize = ref(10)

 const searchForm = reactive({
    keyword: ''
 })

 const form = ref({})
 const dialogFormVisible = ref(false)
 const multipleSelection = ref([])

 const load = () => {
    request.get("/admin/page", {
        params: {
            pageNum: pageNum.value,
            pageSize:pageSize.value,
            keyword: searchForm.keyword
        }
    }).then(res => {
        if(res.data) {
            tableData.value = res.data.records
            total.value =res.data.total
            console.log('===', tableData.value, total.value)
        }
    })
 }
 load()

 const save = () => {
    request.post('/admin', form.value).then(res => {
        if(res.code === '200') {
            ElMessage.success('保存成功')
            dialogFormVisible.value = false
            load()
        }else {
            ElMessage.error("保存失败")
        }
    })
 }

 const handleAdd = () => {
    form.value = {}
    dialogFormVisible.value = true
 }

 const handleEdit = (row) => {
    form.value = JSON.parse(JSON.stringify(row))
    dialogFormVisible.value = true
 }

 const del = (id) => {
    request.delete('/admin/' + id).then(res => {
        if(res.code === '200') {
            ElMessage.success('删除成功')
            load()
        }else {
            ElMessage.error("删除失败")
        }
    })
 }

 const delBatch = () => {
    if(multipleSelection.value.length === 0) {
        ElMessage.warning("请至少选择一条记录")
        return
    }
    const ids = multipleSelection.value.map(v => v.id) 
    request.post('/admin/del/batch', ids).then(res => {
        if(res.code === '200') {
            ElMessage.success('批量删除成功')
            load()
        }else {
            ElMessage.error('批量删除失败')
        }
    })
 }

 const reset = () => {
    searchForm.keyword = ''
    load()
 }

 const handleSelectionChange = (val) => {
    multipleSelection.value = val
 }

 const handleSizeChange = (size) => {
    pageSize.value = size
    load()
 }

 const handleCurrentChange = (current) => {
    pageNum.value = current
    load()
 }

 const confirmDelete = (id) => {
    ElMessageBox.confirm(
        '确定删除这条吗？',
        '警告',
        {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
        }
    ).then(() => {
        del(id)
    })
 }

 const confirmBatchDelete = () => {
    if(multipleSelection.value.length === 0) {
        ElMessage.warning('请至少选择一条数据')
        return
    }
    ElMessageBox.confirm(
        '确定要批量删除这些数据吗？',
        '警告',
        {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
        }
    ).then(() => {
        delBatch()
    })
 }

 //  头像上传
 const handleAvatarUrlUploadSuccess = (res => {
    form.value.avatarUrl = res
 })
</script>