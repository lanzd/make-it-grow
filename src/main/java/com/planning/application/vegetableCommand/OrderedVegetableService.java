package com.planning.application.vegetableCommand;

import com.planning.application.order.OrderEntity;
import com.planning.application.product.Product;
import com.planning.application.product.compositeproduct.CompositeProduct;
import com.planning.application.product.simpleproduct.SimpleProduct;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderedVegetableService {

    @Autowired
    OrderedVegetableRepository vegetableOrderedVegetableRepository;

    public OrderedVegetable get(long connectorId) throws NotFoundException {
        Optional<OrderedVegetable> optionalConnector = vegetableOrderedVegetableRepository.findById(connectorId);
        if(optionalConnector.isPresent()){
            return optionalConnector.get();
        }
        throw new NotFoundException("no ordered vegetable " + connectorId);
    }

    public void createOrderedVegetablesFromOrder(OrderEntity orderEntity){
        Product orderedProduct = orderEntity.getProduct();
        if(orderedProduct instanceof SimpleProduct){

        } else if (orderedProduct instanceof CompositeProduct){

        }
    }

    public void deleteOrderedVegetablesFromOrder(OrderEntity orderEntity){
        Page<OrderedVegetable> page = vegetableOrderedVegetableRepository.findByOrderEntity(orderEntity, PageRequest.of(0,100));
        while(page.getNumberOfElements() > 0) {
            for (OrderedVegetable orderedVegetable : page.getContent()) {
                vegetableOrderedVegetableRepository.delete(orderedVegetable);
            }
        page = vegetableOrderedVegetableRepository.findByOrderEntity(orderEntity, page.nextPageable());
        }
    }

    private OrderedVegetable createOrderedVegetablesFromSimpleProduct(SimpleProduct product, OrderEntity orderEntity){
        OrderedVegetable orderedVegetable = new OrderedVegetable();
        orderedVegetable.setOrderEntity(orderEntity);
        orderedVegetable.setVegetable(product.getVegetable());
        // TODO quantity
        return vegetableOrderedVegetableRepository.save(orderedVegetable);
    }

    private List<OrderedVegetable> createOrderedVegetablesFromCompositeProduct(CompositeProduct product, OrderEntity orderEntity){
        // TODO
        return null;
    }
}
