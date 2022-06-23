module pl.training.payments.adapters {
    exports pl.training.payments.adapters.output.id;
    exports pl.training.payments.adapters.output.persistence;
    exports pl.training.payments.adapters.output.time;
    exports pl.training.payments.adapters.commons.web;

    requires pl.training.payments.ports;
    requires spring.context;
    requires spring.web;
    requires spring.webmvc;
    requires static lombok;
}