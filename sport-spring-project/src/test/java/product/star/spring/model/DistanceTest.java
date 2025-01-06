package product.star.spring.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DistanceTest {

    @Test
    void ofFive() {
        Distance expect = Distance.FIVE_KM;
        Distance actual = Distance.of("5 km");
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void wrongParameter() {
        String code = "5";
        String message = "Unknown distance: " + code;
        assertThatThrownBy(() -> Distance.of("5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(message);
    }
}