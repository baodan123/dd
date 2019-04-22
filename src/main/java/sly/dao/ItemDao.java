package sly.dao;

import java.util.List;

import sly.entity.Item;

public interface ItemDao extends BaseDao<Item> {
	public List<Item> findByOrder(String order_id);
}
