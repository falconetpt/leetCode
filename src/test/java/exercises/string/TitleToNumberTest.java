package exercises.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TitleToNumberTest {
    private TitleToNumber titleToNumber = new TitleToNumber();

    @Test
    @DisplayName( "Scenario 1 - Simple Letter A to 1" )
    public void scenario1() {
        assertEquals( 1, titleToNumber.titleToNumber( "A" ) );
    }

    @Test
    @DisplayName( "Scenario 2 - Simple Letter B to 1" )
    public void scenario2() {
        assertEquals( 2, titleToNumber.titleToNumber( "B" ) );
    }

    @Test
    @DisplayName( "Scenario 3 - Simple Letter AB to 28" )
    public void scenario3() {
        assertEquals( 28, titleToNumber.titleToNumber( "AB" ) );
    }

    @Test
    @DisplayName( "Scenario 4 - Simple Letter ZY to 701" )
    public void scenario4() {
        assertEquals( 701, titleToNumber.titleToNumber( "ZY" ) );
    }
}