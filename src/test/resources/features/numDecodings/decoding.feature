Feature: Decode
    As a consumer
    I want to know how many ways i have to decode a string
    So that i can know the max numbers of decodings

    Scenario Outline: Decoding
        Given a input <input>
        When i decode it
        Then the result should be <result>

        Examples:
        | input | result   |
        | "1"   | 1        |
        | "2"   | 1        |
        | "3"   | 1        |
        | "26"  | 3        |
        | ""    | 0        |

