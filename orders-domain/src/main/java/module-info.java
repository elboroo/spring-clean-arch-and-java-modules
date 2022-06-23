module pl.training.orders.domain {
    exports pl.training.orders.adapters;

    requires pl.training.orders.ports;
    requires org.javamoney.moneta;
    requires static lombok;
    requires static org.mapstruct;
    requires static org.mapstruct.processor;
}
