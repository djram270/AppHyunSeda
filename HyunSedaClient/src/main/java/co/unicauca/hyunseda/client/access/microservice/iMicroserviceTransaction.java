/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.hyunseda.client.access.microservice;

import co.unicauca.hyunseda.client.access.model.Order;
import co.unicauca.hyunseda.client.access.model.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 *
 * @author Oscar
 */
public interface iMicroserviceTransaction {

    List<Transaction> getTransactionHistory();

    String postTransaction(Transaction transaction);
    
    <T> T getData(String json, TypeReference<T> reference);

}
