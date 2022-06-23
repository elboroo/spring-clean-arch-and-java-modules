open module pl.trainig.shop.service {
    requires pl.training.payments.domain;
    requires pl.training.payments.adapters;
    requires transitive pl.training.payments.ports;

    requires pl.training.orders.domain;
    requires pl.training.orders.prodcuts.adapters;
    requires transitive pl.training.orders.ports;

    requires spring.context;
    requires spring.core;
    requires spring.beans;
    requires spring.web;
    requires spring.webmvc;
    requires spring.boot.starter.web;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.boot.starter.data.jpa;
    requires spring.aop;
    requires static lombok;
    requires java.logging;
    requires java.sql;
    requires spring.boot;
    requires spring.boot.autoconfigure;
}
