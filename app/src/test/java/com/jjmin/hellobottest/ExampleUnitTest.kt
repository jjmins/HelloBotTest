package com.jjmin.hellobottest

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun solution() {
        var answer = 0
        var play_list : ArrayList<Int> = arrayListOf(2,3,1,4)
        var listen_time = 3
        var base_point = 0
        var base_value = 999

        (0 until play_list.size).forEach{

            if(base_value > play_list[it]){
                base_value = play_list[it]
                base_point = it
            }
        }

        println("base_point0 : "+ base_point)


        base_point--

        println("base_point1 : "+ base_point)


        if(base_point < 0){
            base_point = play_list.size-1
        }

        println("base_point2 : "+ base_point)


        var check_frist = true

        while (true){

            if(listen_time <=0 || play_list.size == answer){
                break
            }

            println("base_point : " + base_point)


            if(play_list[base_point] != 0){

                if(check_frist){
                    play_list[base_point] - 1
                    listen_time--
                    println("!$listen_time")
                    check_frist = false
                }else{
                    listen_time -= play_list[base_point]
                    println("play_list[base_point] : " + base_point)
                    println("?$listen_time")
                    play_list[base_point] = 0
                }



                answer++
//                println("time : " + listen_time + "   answer : " + answer)
            }

            base_point+=1
            println("base_point : "+ base_point)

            if(base_point >= play_list.size){
                base_point = 0
            }

        }
//        print(answer)
        assertEquals(answer,1)
    }
}
