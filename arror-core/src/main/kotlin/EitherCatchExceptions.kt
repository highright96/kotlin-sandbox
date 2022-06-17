import arrow.core.Either

fun potentialThrowingCode(): String = throw RuntimeException("Blow up!")

suspend fun makeSureYourLogicDoesNotHaveSideEffects(): Either<Error, String> =
    Either.catch {
        potentialThrowingCode()
    }.mapLeft {
        Error.SpecificError
    }

suspend fun main() {
    println(makeSureYourLogicDoesNotHaveSideEffects())
}