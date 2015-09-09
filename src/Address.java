import java.util.Objects;
import java.util.Optional;

public class Address {
    private final String addressLine; // never null
    private final String city; // never null
    private final Integer postCode; // will be optional and may be null

    public Address(String addressLine, String city, Integer postCode) {
        this.addressLine = Objects.requireNonNull(addressLine);
        this.city = Objects.requireNonNull(city);
        this.postCode = postCode;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public String getCity() {
        return city;
    }

    public Optional<Integer> getPostCode() {
        return Optional.ofNullable(postCode);
    }
}
