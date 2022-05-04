package com.example.multiresponsetest.controller

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.time.Duration

/**
 * @author Jefferson Alves Reis (jefaokpta) < jefaokpta@hotmail.com >
 * Date: 08/04/22
 */
@RestController
@RequestMapping("/long")
class LongResponse {

    @GetMapping
    fun long(): Flux<Int> {
        //val listOf = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        return Flux.fromIterable(NumberStore.getNumbers())
            .log()
            .limitRate(1)
            .delayElements(Duration.ofSeconds(1))
            .doOnNext { NumberStore().addNumber(99); println(NumberStore.getNumbers().size )}
//            .publishOn(Schedulers.boundedElastic())
    }

    fun customSubscriber() {

        val range = Flux.range(1, 10)

    }
}