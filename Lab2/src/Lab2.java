import Products.DAOProducts;

public class Lab2 {

    static class FindingKettles implements DAOProducts.ProcessFunction {
        private int kettlesNumber;
        FindingKettles(){
            this.kettlesNumber = 0;
        }
        @Override
        public void ProcessProduct(DAOProducts.Product product){
            if (product.GetType() == DAOProducts.Product.Type.Kettle) {
                kettlesNumber++;
            }
        }
        int getKettlesNumber(){
            return kettlesNumber;
        }
    }
    static class LowestPrice implements DAOProducts.ProcessFunction {
        private int lowestPrice;
        LowestPrice(){
            this.lowestPrice = Integer.MAX_VALUE;
        }
        @Override
        public void ProcessProduct(DAOProducts.Product product){
            if (product.GetPrice() < lowestPrice) {
                lowestPrice = product.GetPrice();
            }
        }
        int getLowestPrice(){
            return lowestPrice;
        }
    }

    public static void main(String[] args) {

        var products = new DAOProducts("Products.xml");
        var findingKettles = new FindingKettles();
        products.EnumProducts(findingKettles);
        final int kettlesNumber = findingKettles.getKettlesNumber();
        var lowestPrice = new LowestPrice();
        products.EnumProducts(lowestPrice);
        final int price = lowestPrice.getLowestPrice();

    }
}