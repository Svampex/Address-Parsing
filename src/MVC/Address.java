package MVC;

import java.util.regex.*;

public class Address {
    private final String street, house, floor, side, postcode, city;
    private static Pattern addressPattern = Pattern.compile("(?<vejnavn>[A-ZÆØÅa-zæøå ]+)(?<husnr>[1-9][0-9]*[A-Z]?)((?<etage> [1-9][0-9]*\\.[ ]?)(?<side>MF|TV|TH|mf|tv|th))?[,]? (?<postnr>[1-9][0-9]{3}) (?<bynavn>[A-ZÆØÅa-zæøå ]+)");

    private Address(String _street, String _house, String _floor, String _side, String _postcode, String _city) {
        street = _street;
        house = _house;
        floor = _floor;
        side = _side;
        postcode = _postcode;
        city = _city;
    }
    public static class Builder {
        private String street = "Unknown", house, floor, side, postcode, city;
        public Builder street(String _street) { street = _street; return this; }
        public Builder house(String _house)   { house = _house;   return this; }
        public Builder floor(String _floor)   { floor = _floor;   return this; }
        public Builder side(String _side)     { side = _side;     return this; }
        public Builder postcode(String _postcode) { postcode = _postcode; return this; }
        public Builder city(String _city)     { city = _city;     return this; }
        public Address build() {
            return new Address(street, house, floor, side, postcode, city);
        }
    }

    public String street()   { return street; }
    public String house()    { return house; }
    public String floor()    { return floor; }
    public String side()     { return side; }
    public String postcode() { return postcode; }
    public String city()     { return city; }

    public static Address parse(String s) {
        Builder b = new Builder();
        Matcher m = addressPattern.matcher(s);
        if(m.matches()){
            return b.street(m.group("vejnavn")).house(m.group("husnr")).floor(m.group("etage")).side(m.group("side")).postcode(m.group("postnr")).city(m.group("bynavn")).build();
        }
        return null;
    }
}