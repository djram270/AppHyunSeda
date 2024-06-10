package co.unicauca.microservice.apirest.domain.entity;

import co.unicauca.microservice.apirest.domain.entity.states.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Entity
@Table(name = "order_table")
@ToString
@Getter
@Setter

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long clientId;
    private String strDate;
    private String strState;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;

    @JsonIgnore
    @Transient
    @JsonSerialize(as = iStateOrder.class)
    private iStateOrder state;

    // Constructor
    public Order() {
        // Por defecto, el estado inicial es "EsperandoPagoState"
        this.state = new NotSend();
        this.strState = state.getClass().getSimpleName();

    }

    /**
     * Ejecuta la accion 'Cancel' sobre el estado actual de la orden.
     */
    public void cancelOrder() {
        state.CancelOrder(this);
        updateStrState();
    }
    /**
     * Ejecuta la accion 'Send' sobre el estado actual de la orden.
     */
    public void sendOrder() {
        state.SendOrder(this);
        updateStrState();
    }
    /**
     * Ejecuta la accion 'NotSend' sobre el estado actual de la orden.
     */
    public void notSendOrder() {
        state.NotSendOrder(this);
        updateStrState();
    }
    /**
     * Ejecuta la accion 'OnHold' sobre el estado actual de la orden.
     */
    public void onHold() {
        state.OnHoldOrder(this);
        updateStrState();
    }
    /**
     * Modifica el valor del atributo 'strState' al nombre de la clase del estado actual.
     */
    private void updateStrState() {
        strState = state.getClass().getSimpleName();
    }

    /**
     * Cambia el estado de la orden a un nuevo estado si condicion.
     *
     * @param StateOrder Nuevo estado de la orden.
     */
    public void setState(iStateOrder StateOrder) {
        this.state = StateOrder;
        updateStrState();
    }
    /**
     * Basado en el valor del atributo 'strState' de 'Order' se cambia el estado de la orden.
     */
    public void setPersistentState()
    {
        if (strState == null)
        {
            return;
        }

        switch (strState)
        {
            case "NotSend" :
                setState(new NotSend());
                break;

            case "OnHold" :
                setState(new OnHold());
                break;

            case "Cancel" :
                setState(new Cancel());
                break;

            case "Send" :
                setState(new Send());
                break;
        }
    }
}

