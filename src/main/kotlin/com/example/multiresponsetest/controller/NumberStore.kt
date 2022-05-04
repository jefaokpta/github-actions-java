package com.example.multiresponsetest.controller

/**
 * @author Jefferson Alves Reis (jefaokpta) < jefaokpta@hotmail.com >
 * Date: 08/04/22
 */
class NumberStore {
    companion object {
        private val numbers = mutableListOf(1,2,3,4,5,6,7,8,9,10)

        fun getNumbers() = numbers


    }
        fun addNumber(number: Int) = numbers.add(number)
}