<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <item-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import ItemRegisterForm from '@/components/item/ItemRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'ItemRegisterPage',
    components: {
        ItemRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, area, content } = payload
            axios.post('http://localhost:7777/48th/vueboard/register', {title, area, content })
                    .then(() => {
                        alert('게시물 등록 성공!')

                        this.$router.push({
                            name: 'ItemListPage'
                        })
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    }
}

</script>
