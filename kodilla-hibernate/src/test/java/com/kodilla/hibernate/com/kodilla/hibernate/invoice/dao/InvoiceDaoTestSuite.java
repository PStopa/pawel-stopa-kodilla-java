package com.kodilla.hibernate.com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("03/2018");
        Product monitor = new Product("Monitor");
        Product mouse = new Product("Mouse");
        Product router = new Product("Router");
        Item item1 = new Item(monitor, new BigDecimal(400), 2, new BigDecimal(800), invoice);
        Item item2 = new Item(mouse, new BigDecimal(30), 5, new BigDecimal(150), invoice);
        Item item3 = new Item(router, new BigDecimal(150), 1, new BigDecimal(150), invoice);
        monitor.getItems().add(item1);
        mouse.getItems().add(item2);
        router.getItems().add(item3);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        invoiceDao.delete(invoice);
    }
}
