package com.planning.application.orderedvegetable;

import com.planning.application.order.OrderEntity;
import com.planning.application.product.Product;
import com.planning.application.product.compositeproduct.CompositeProduct;
import com.planning.application.product.compositeproduct.component.CompositeProductComponent;
import com.planning.application.product.compositeproduct.component.CompositeProductComponentRepository;
import com.planning.application.product.simpleproduct.SimpleProduct;
import com.planning.application.vegetable.Vegetable;
import com.planning.application.vegetable.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.planning.application.product.simpleproduct.SimpleProductUtils.CONVERT_QUANTITY;

@Service
public class OrderedVegetableService {

    @Autowired
    OrderedVegetableRepository orderedVegetableRepository;

    @Autowired
    CompositeProductComponentRepository compositeProductComponentRepository;

    @Autowired
    VegetableService vegetableService;

    public void createOrderedVegetablesFromOrder(OrderEntity orderEntity){
        Product orderedProduct = orderEntity.getProduct();
        if(orderedProduct instanceof SimpleProduct){
            createOrderedVegetablesFromSimpleProduct((SimpleProduct) orderedProduct,orderEntity);
        } else if (orderedProduct instanceof CompositeProduct){
            createOrderedVegetablesFromCompositeProduct((CompositeProduct) orderedProduct,orderEntity);
        }
    }

    public void deleteOrderedVegetablesFromOrder(OrderEntity orderEntity){
        Page<OrderedVegetable> page = orderedVegetableRepository.findByOrderEntity(orderEntity, PageRequest.of(0,100));
        while(page.getNumberOfElements() > 0) {
            for (OrderedVegetable orderedVegetable : page.getContent()) {
                orderedVegetableRepository.delete(orderedVegetable);
            }
            page = orderedVegetableRepository.findByOrderEntity(orderEntity, page.nextPageable());
        }
    }

    public void updateOrderedVegetableMaximumSeedingDate(Vegetable vegetable){
        Page<OrderedVegetable> page = orderedVegetableRepository.findByVegetable(vegetable, PageRequest.of(0,100));
        while(page.getNumberOfElements() > 0) {
            for (OrderedVegetable orderedVegetable : page.getContent()) {
                orderedVegetable.setMaximumSeedingDate(vegetableService.findMaximumSeedingDateForHarvestDate(vegetable,orderedVegetable.getDate()));
            }
            page = orderedVegetableRepository.findByVegetable(vegetable, PageRequest.of(0,100));
        }
    }

    private OrderedVegetable createOrderedVegetablesFromSimpleProduct(SimpleProduct product, OrderEntity orderEntity){
        OrderedVegetable orderedVegetable = new OrderedVegetable();
        orderedVegetable.setOrderEntity(orderEntity);
        orderedVegetable.setVegetable(product.getVegetable());
        orderedVegetable.setDate(orderEntity.getDate());
        orderedVegetable.setMaximumSeedingDate(vegetableService.findMaximumSeedingDateForHarvestDate(product.getVegetable(),orderEntity.getDate()));
        orderedVegetable.setQuantity(CONVERT_QUANTITY(product));
        return orderedVegetableRepository.save(orderedVegetable);
    }

    private Collection<OrderedVegetable> createOrderedVegetablesFromCompositeProduct(CompositeProduct product, OrderEntity orderEntity){
        Map<Vegetable,OrderedVegetable> orderedVegetablesMap = new HashMap<>();

        Page<CompositeProductComponent> page = compositeProductComponentRepository.findByProduct(product, PageRequest.of(0,100));
        while(page.getNumberOfElements() > 0) {
            for(CompositeProductComponent component : page.getContent()) {
                Vegetable vegetable = component.getComponent().getVegetable();
                if(orderedVegetablesMap.containsKey(vegetable)){
                    OrderedVegetable orderedVegetable = orderedVegetablesMap.get(vegetable);
                    orderedVegetable.setQuantity(orderedVegetable.getQuantity() + CONVERT_QUANTITY(component.getComponent()));
                } else {
                    orderedVegetablesMap.put(vegetable,createOrderedVegetablesFromSimpleProduct(component.getComponent(),orderEntity));
                }
            }
            page = compositeProductComponentRepository.findByProduct(product, page.nextPageable());
        }
        return orderedVegetablesMap.values();
    }

}
