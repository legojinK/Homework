import{ 
    FETCH_ITEM_LIST,    //아이템리스트를 불러오는 FETCH_ITEM_LIST라고 이름 지음
    FETCH_ITEM          //낱개로 불러오는 부분 
    
}  from './mutation-types' // 얘네들에 대한 정보는 mutation-types에 들어있음 

import axios from 'axios'


//export해서 외부에서 참조가능하도록 만들어줌
//map.action을 하게 되면 action에 있는 정보를 사용하게 됨-->이 떄 FETCH_ITEM_LIST를 사용함


export default{
    fetchItemList ({ commit }) {
        return axios.get('http://localhost:7777/48th/vueboard/list')
                .then((res) => {
                    commit(FETCH_ITEM_LIST, res.data) // 스프링에서 데이터 넘어옴-->commit 하면 mutations가야함
                }) 


    // 액션 쪽에서 넘오는 것은 처리됨--> 
    //그다음 commit(FETCH_BOARD_LIST, res.data)의 FETCH에 의해서 mutations에서도 export를 처리해야함 
    //--> states에서 넘어온 정보만 셋팅하면 됨
    },
    fetchBoard ({ commit }, itemNo) {
        return axios.get(`http://localhost:7777/48th/vueboard/${itemNo}`)
                .then((res) => {
                    commit(FETCH_ITEM, res.data)
                })
    }
}