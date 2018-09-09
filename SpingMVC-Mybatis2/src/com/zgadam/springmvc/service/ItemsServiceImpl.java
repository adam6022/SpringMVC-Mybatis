package com.zgadam.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgadam.springmvc.mapper.ItemsMapper;
import com.zgadam.springmvc.pojo.Items;

/**
 * 查询商品信息
 * @author Apple
 *
 */
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> selectItemsList() {
		return itemsMapper.selectByExample(null);
	}

	@Override
	public Items findItemById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateitem(Items items) {
		itemsMapper.updateByPrimaryKey(items);
	}
	
}
