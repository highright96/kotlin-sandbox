/*
For our little module, we enumerate any and all errors that can occur.
Then, instead of using exception classes as error values, we use one of the enumerated cases.
Now, when we pattern match, we are able to comphrensively handle failure without resulting in an else branch;
moreover, since Error is sealed, no outside code can add additional subtypes that we might fail to handle.
 */
sealed class Error {

    object NotANumber : Error()
    object NoZeroReciprocal : Error()
    object SpecificError : Error()
}