package com.bongus.plantify

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlantifyApplication

fun main(args: Array<String>) {
	runApplication<PlantifyApplication>(*args)
}
