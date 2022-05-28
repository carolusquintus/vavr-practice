package dev.carv.tuple;

import io.vavr.Tuple;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TupleConversion {

    record Address(String street, String city) {}
    record Nationality(String nationality, String birthPlace) {}

    public static void main(String[] args) {
        var t0 = Tuple.of("Zhou", 87);
        var t0New = t0.append(new Address("Santa Devota", "Monaco"));
        log.debug("{}", t0New.arity());
        log.debug("{}", t0New._3);

        var t1 = Tuple.of("Patricio", 25);
        var t1Data = Tuple.of(
            new Address("Texas", "USA"),
            new Nationality("Mexican", "Monterrey")
        );
        var t1New = t1.concat(t1Data);
        log.debug("{}", t1New.arity());
        log.debug("{}", t1New._3);
        log.debug("{}", t1New._4);

        var t2 = Tuple.of("foo", "bar", "bazz");
        log.debug("{}", t2.toSeq()); // io.vavr.collection.Seq > LinearSeq > List > Cons (Non-empty List, consisting of a head and a tail.)

        var h3 = Tuple.hash("foo", "bar");
        log.debug("{}", h3); // equivalent: (31 * (31 + Objects.hashCode("foo")) + Objects.hashCode("bar"))

    }
}
