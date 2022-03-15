<template>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>과일명</td>
                <td>
                    <input type="text" v-model="title"/>
                </td>
            </tr>
            <tr>
                <td>원산지</td>
                <td>
                    <input type="text" v-model="area"/>
                </td>
            </tr>
            <tr>
                <td>상세 정보</td>
                <td>
                    <textarea cols="50" rows="20" v-model="content">
                    </textarea>
                </td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'ItemListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>

export default {
    name: 'ItemRegisterForm',
    data () {
        return {
            title: '과일명',
            area: '원산지',
            content: '상세 설명'
        }
    },
    methods: {
        onSubmit () {
            const { title, area, content } = this
            this.$emit('submit', { title, area, content })
        }
    } // 여기서 등록 누르면  onsubmit이 동작하고 
      //emit을 통해서 itemRegisterPage쪽의 @submit 쪽으로 이벤트를 전달
      //-->그쪽 onsubmit이 동작해서 작성한 { title, area, content } 가 스프링 컨트롤러에 전달
}
</script>