package dao;

import domain.Seller;

public interface SellerDao {
    /**
     * ����id��ѯ
     * @param id
     * @return
     */
    public Seller findById(int id);
}
