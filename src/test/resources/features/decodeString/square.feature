Feature: Square Array
    As a consumer
    I want to know the letter at index
    So that i can know what value is there

    Scenario Outline: Single robot max
        Given a input <input>
        When i decode it and check index <index>
        Then the result should be <result>

        Examples:
            | input      | index | result    |
            | "a"        | 1     | "a"       |
            | "a2"       | 2     | "a"       |
            | "leet2code3"       | 10     | "o"       |
            | "ha22"       | 5     | "h"       |
            | "a2345678999999999999999"       | 1     | "a"       |
            | "a23"       | 6     | "a"       |
            | "a2b3c4d5e6f7g8h9"       | 9     | "b"       |
