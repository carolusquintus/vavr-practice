package dev.carv.tuple;

import io.vavr.Tuple;
import java.util.AbstractMap.SimpleEntry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TupleBegin {

    record Customer(String name, int age) {
    }

    public static void main(String[] args) {
        var t0 = Tuple.of("Alex", 36);
        log.debug("{}", t0);

        var t1 = Tuple.of(42, "Hello", new Customer("Alex", 36));
        log.debug("{}", t1._1);
        log.debug("{}", t1._2);
        log.debug("{}", t1._3);

        log.debug("{}", t1._1());
        log.debug("{}", t1._2());
        log.debug("{}", t1._3());

        var t2Entry = Tuple.of(new SimpleEntry(42, "foo"));
        log.debug("{}", t2Entry._1);
    }
}
