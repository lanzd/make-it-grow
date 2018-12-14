package com.planning.application.product.simpleproduct;

public class SimpleProductUtils {

    public static int CONVERT_QUANTITY(SimpleProduct product) {
        Double factor = product.getVegetable().getVegetableParameters().getUnitConversionFactor().get(product.getUnit());
        if (factor != null) {
            return (int) Math.ceil(product.getQuantity()*factor);
        }
        throw new UnsupportedOperationException("Unable to convert " + product.getVegetable() + " quantity, No conversion factor for unit : " + product.getUnit());
    }
}
