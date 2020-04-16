/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package sample.kotlin.spring

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import sample.kotlin.spring.model.entities.Country
import sample.kotlin.spring.model.repository.CountryRepository
import sample.kotlin.spring.user.ApplicationUser
import sample.kotlin.spring.user.ApplicationUserRepository

@SpringBootApplication
open class CapitalCityQuizAPI {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(CapitalCityQuizAPI::class.java)
        }
    }

    @Bean
    open fun bCryptPasswordEncoder() : BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    open fun sampleData(repository : CountryRepository): CommandLineRunner{
        return CommandLineRunner {
            repository.save(Country("Spain",  "Madrid",          "Europe"))
            repository.save(Country("France", "Paris",           "Europe"))
            repository.save(Country("USA",    "Washington D.C.", "North America"))
            repository.save(Country("Japan",  "Tokyo",           "Asia"))
        }
    }

    @Bean
    open fun sampleUserData(repository : ApplicationUserRepository): CommandLineRunner{
        return CommandLineRunner {
            repository.save(ApplicationUser("Hannah",  bCryptPasswordEncoder().encode("123tom"),
                    "hannahlhughes94@gmail.com", "Hannah", "Hughes"))

            repository.save(ApplicationUser("Jose",  bCryptPasswordEncoder().encode("456tom"),
                    "jose.gbel@gmail.com", "Jose", "Garcia"))
        }
    }
}
