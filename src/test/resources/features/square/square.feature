Feature: Square Array
    As a consumer
    I want to collect the cherry
    So that i can collect the max cherries

    Scenario Outline: Single robot max
        Given a input <input>
        When i square every number
        Then the result should be <result>

        Examples:
        | input | result    |
        | ""    | ""        |
        | "0"    | "0"        |
        | "1"    | "1"        |
        | "-1"    | "1"        |
        | "1,2,3"    | "1,4,9"        |
        | "-4,1,2,3"    | "1,4,9,16"        |
