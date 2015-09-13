import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class AddressTest {

    @Test
    public void test_nominal() {
        Address addressOne = new Address("144 new street", "Oklahoma", 11000);

        Assertions.assertThat(addressOne.getAddressLine()).isEqualTo("144 new street");
        Assertions.assertThat(addressOne.getCity()).isEqualTo("Oklahoma");
        Assertions.assertThat(addressOne.getPostCode()).isPresent().contains(11000);

        Address addressTwo = new Address("144 new street", "Oklahoma", null);
        Assertions.assertThat(addressTwo.getPostCode()).isNotNull();
        Assertions.assertThat(addressTwo.getPostCode()).isEmpty();
    }

    @Test
    public void test_exceptions() {
        Assertions.assertThatThrownBy(() -> new Address(null, "Oklahoma", 11000))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("must not be null");

        Assertions.assertThatThrownBy(() -> new Address("144 new street", null, 11000))
                .isInstanceOf(NullPointerException.class)
                .hasMessage(null);

        Assertions.assertThatThrownBy(() -> {
            Optional<Integer> postCode = new Address("144 new street", "Oklahoma", null).getPostCode();
            postCode.get();
        })
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("No value present");

    }

    @Test
    public void test_optional() {
        Address addressOne = new Address("144 new street", "Oklahoma", 11000);
        Assertions.assertThat(addressOne.getPostCode().orElse(0)).isEqualTo(11000);

        Address addressTwo = new Address("144 new street", "Oklahoma", null);
        Assertions.assertThat(addressTwo.getPostCode().orElse(0)).isEqualTo(0);
        Assertions.assertThat(addressTwo.getPostCode().orElseGet(() -> 0)).isEqualTo(0);
    }
}