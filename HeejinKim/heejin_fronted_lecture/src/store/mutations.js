import {
    FETCH_ITEM_LIST,
    FETCH_ITEM

} from './mutation-types' 
//실질적으로 가져와서 states에 있는 item에 세팅을 함 --axio로 연결함

export default{ //외부 참조가 가능하게 함//여기서는 states에서 넘어온 정보만 셋팅하면 됨(?)
    [FETCH_ITEM_LIST] (state, items) {
        state.items = items
    },
    [FETCH_ITEM] (state, item) {
        state.item = item
    }
  
  

}
