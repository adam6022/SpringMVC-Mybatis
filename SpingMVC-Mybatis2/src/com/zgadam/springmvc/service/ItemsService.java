package com.zgadam.springmvc.service;

import java.util.List;

import com.zgadam.springmvc.pojo.Items;

public interface ItemsService {
	List<Items> selectItemsList();

	Items findItemById(Integer id);

	void updateitem(Items items);
}
