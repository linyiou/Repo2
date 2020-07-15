package dao;

import domain.Seller;

public interface SellerDao {
    /**
     * ¸ù¾Ýid²éÑ¯
     * @param id
     * @return
     */
    public Seller findById(int id);
}
