package dev.carv.tuple;

import io.vavr.Tuple;
import java.util.AbstractMap.SimpleEntry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TupleBegin {

  record Customer(String name, int age) {}

  public static void main(String[] args) {
    var t2 = Tuple.of("Alex", 36);
    log.debug("{}", t2);

    var t3 = Tuple.of(42, "Hello", new Customer("Alex", 36));
    log.debug("{}", t3._1);
    log.debug("{}", t3._2);
    log.debug("{}", t3._3);

    log.debug("{}", t3._1());
    log.debug("{}", t3._2());
    log.debug("{}", t3._3());
    
    var tEntry = Tuple.of(new SimpleEntry(42, "foo"));
    log.debug("{}", tEntry._1);
  }
}
