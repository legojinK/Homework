<template>
    <div>

        <h3> 게시물 목록 </h3>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="600">과일명</th>
                <th align="center" width="150">원산지</th>
                <th align="center" width="240">등록일자</th>
            </tr>
            <!-- 아까전 전달된 v-bind가 없는 경우와 제어할 수 없는 데이터도 포함시킴 -->
            <tr v-if="!items || (Array.isArray(items) && items.length === 0 )">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다
                </td>
            </tr>
            <tr v-else v-for="item in items" :key="item.itemNo">   
                <td align="center">
                    {{ item.itemNo }}
                </td>

                <td align="right">
                    <router-link :to="{ name: 'ItemReadPage',
                                        params:{ itemNo: item.itemNo.toString()} }">
                            {{ item.title }}
                    </router-link>
                </td>

                <td align="right">
                    {{ item.area }}
                </td>

                <td align="center">
                    {{ item.regDate }}
                </td>
            </tr> 

        </table>
    </div>
</template>

<script>
export default { //바인드 시킨 정보를 전달하지만 아직 (1) 넘어온게 없음
   name: 'ItemList',
   props: {
       items: {
           type: Array 
       }

   }
}
</script>