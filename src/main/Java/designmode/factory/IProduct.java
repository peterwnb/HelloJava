package designmode.factory;

/**
 * Created by zzqno on 2017-2-26.
 */
public interface IProduct {

    public void productMethod();

}

class Product implements  IProduct{

    @Override
    public void productMethod() {
        System.out.println(" this is product");
    }
}
