<template>
    <div id="item">
        <h2> Vue + Spring 게시판 </h2>
        <router-link :to="{ name: 'ItemRegisterPage' }">

           게시물 작성 
        </router-link>
        <item-list :items="items"/>
        <!--items에서 itemList컴포넌트한테데이터를 전달 해줘야함  (1)-->
    
    </div>
</template>



<script>

import ItemList from '@/components/item/ItemList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name:'ItemListPage',
    components:{

        ItemList
        // 로컬 컴포넌트 만들기
        //(1)아직 이것만 만들고 데이터가 세팅이 되어있지 않음
        //즉 여기에서 item이라는 데이터에다 스프링에 요청을 해서 데이터를 받아와야함
        //states의 정보와 여기 listpage를 매칭시켜야함

    },
    computed: {
        ...mapState(['items'])//mapstates를 써서 states에 있는 item을 배열로 가져옴
    },
    mounted (){ 
        //vue의 객체가 만들어지고 나서 바로 직후에 Fetch_Item_List에 의해서 스프링으로 부터 정보를 획득해 옴
        
        this.fetchItemList()

        //호출
        //이 this라는 객체에서 (['items'])을 사용할수 있게됨 
        //mapState는 state에 있는 정보를 this와 매핑
    },

    methods: {
        ...mapActions(['fetchItemList'])  
        //action에 있는 fetchBoardList매핑한 것 
        //board전체 List를 가져올수 있는  함수를 쓰려고 만든 것--->mounted에서 호출함---->보드리스트 값을 state가 가지고 있음
        //methods를 통해 Action에 있는 fetchItemList를 썼고 그것은 axio로 정보를 요청한 다음에 mutations을 통해서 state에 집어 넣음

        

        //fetchItemList가 하는 역할---boardlist를 가져오는데 그게 state에 들어가 있음

        //1)states에 있는 item(board) 연결됨
        //2)action에서 fetchItemList가져 와서 실제 vue 객체 만들어지고나서  mounted의 this.fetchItemList()를 요청함
        //3)그러면  <item-list :items="items"/>에서 items에 정보가 들어가니까 정보를 넘길 수 있음 

        //1) 다시 mapActions불러서 fetchItemList집어넣고 mapState로 items에 셋팅하고 그것을 <item-list :items="items"/>에 넘겨줌

        //현재 states에 있는 내용을 현재 this랑 매핑한다
        //보드의 원래 위치는 db이지만 Fetch 를 통해서 가져오는게 state에 들어감
    }

        
    
}
</script>