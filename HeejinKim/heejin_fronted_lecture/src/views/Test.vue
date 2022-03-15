<template>
    <div class="home">
        <div id="header">         
            <router-link :to="{ name: 'Home' }" 
                    class="nav-link"
                    active-class="active">
                Home
            </router-link>
            <router-link :to="{ name: 'Test' }"
                    class="nav-link"
                    active-class="active">
                Test
            </router-link>
        </div>

        <h2>Vue 테스트 페이지</h2>

        <div id="app">
            <p>{{ msg }}</p>

            <global-component v-bind:initial-test="counter"> 

            <!--왜 매핑이 되느냐? 
            v-bind를 써서  initialtest가 globalComponent에서는 initialtest는 
            여기의 counter로 매핑이됨
            Test로 가면 props로 받은 initialtestsms this를 통해 Test에 있는  counter랑 연결이 됨
            버튼을 클릭하면 Test의 counter 값이 올라가게 됨 
            그래서 Props의  initialtest와 Test의 data의 리턴값에 있는 counter를 맞춰주기 위해서 0으로 설정함
            즉. v-bind를 사용해서 글로벌컴포넌트에 있는 props[ initialtest ]랑 counter=0랑 매핑을 시킴
            자동적으로 컴포넌트에 -가 들어감(암묵적인 규칙)-->


            </global-component>

            <local-component v-bind:num="value">
            </local-component>
            <button v-on:click="plus">클릭</button>

        </div>
    </div>
</template>

<script>

 // <div id="header">어디로 이동을 할것임//<router-link>어디로 이동하겠음 (home으로 이동하겠음)
 // class 쪽은 스타일이라 신경안써도 됨

import Vue from 'vue'
import GlobalComponent from '@/components/test/GlobalComponent.vue'
import LocalComponent from '@/components/test/LocalComponent.vue'


//GlobalComponent라는 것을 알려줌

Vue.component(GlobalComponent.name, GlobalComponent) //vue에 GlobalComponent라는 것을 등록해줌

export default {

    components: {
       
        'local-component': LocalComponent
               //로컬 컴포넌트는 이렇게 컴포넌트 해서 매번 넣어주어야함
    },

    data () { //스크립트쪽에서 넘어온 뷰 정보를 받아갈수 있는 구성 //scr 자동완성
        return {
            counter: 0,
            value: 0,
            msg: '이래서 Vue 가 생산성이 높음'
        }
    },

    methods: {
        plus(){
            this.value++
        }
    }
}

</script>

