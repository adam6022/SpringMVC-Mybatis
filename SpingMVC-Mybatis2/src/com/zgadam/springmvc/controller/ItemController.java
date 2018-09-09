package com.zgadam.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zgadam.springmvc.exception.CustomerException;
import com.zgadam.springmvc.pojo.Items;
import com.zgadam.springmvc.service.ItemsService;
import com.zgadam.springmvc.vo.QueryVo;

/**
 * 商品管理
 * @author Apple
 *
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList() throws Exception {
		
		
		List<Items> list = itemsService.selectItemsList();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("itemList");
		mav.addObject("itemList",list);
		
		return mav;
	}
	
	@RequestMapping(value="/item/delete.action")
	public ModelAndView delete(Integer[] ids) {
		for (Integer integer : ids) {
			System.out.println(integer);
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("success");
		
		return mav;
	}
	
	@RequestMapping(value="/itemEdit.action")
	public ModelAndView itemEdit(Integer id) {
		Items item = itemsService.findItemById(id);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("editItem");
		mav.addObject("item",item);
		return mav;
	}
	
	@RequestMapping(value="/updateitem.action")
	public ModelAndView updateitem(QueryVo vo,MultipartFile pictureFile) throws IllegalStateException, IOException {
		//保存图片到D:
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		File file=new File("D:\\upload\\" + name +"."+ ext);
		pictureFile.transferTo(file);
		Items items = vo.getItems();
		itemsService.updateitem(items);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("success");
		return mav;
		//return "redirect:/itemEdit.action?id="+items.getId();
	}
	
}
