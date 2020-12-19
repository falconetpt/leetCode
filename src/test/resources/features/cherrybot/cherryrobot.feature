Feature: Cherrybot
    As a consumer
    I want to collect the cherry
    So that i can collect the max cherries

    Scenario Outline: Single robot max
        Given a file <file>
        When i collect cherry
        Then the result should be <result>

        Examples:
        | file                                                                      | result    |
        | "src/test/resources/features/cherrybot/files/empty.txt"                   | 0         |
        | "src/test/resources/features/cherrybot/files/single_element.txt"          | 7         |
        | "src/test/resources/features/cherrybot/files/multiple_element.txt"        | 37        |
        | "src/test/resources/features/cherrybot/files/multiple_element_grid1.txt"  | 14        |
