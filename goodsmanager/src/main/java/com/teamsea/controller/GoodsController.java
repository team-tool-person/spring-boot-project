package com.teamsea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamsea.pojo.Goods;
import com.teamsea.service.GoodsService;

@Controller
@RequestMapping("/goods/")
public class GoodsController {

	@Autowired
	private GoodsService service;

	@RequestMapping("list")
	public String goodsList(Model model) {

		// 获取goods信息
		List<Goods> goods = service.getGoodsList();

		// 将获取goods传递给前端
		model.addAttribute("goods", goods);

		// 进入页面
		return "goodslist";
	}

	@RequestMapping("add")
	public String addGoods(Goods goods) {

		service.addGoodStrengthen(goods);

		// 进行重定向
		return "redirect:list";
	}

	@RequestMapping("delete")
	public String deleteGoods( /* Goods goods */ Integer id, String name) {

		Goods goods = new Goods(id,name,null);

		System.out.println(goods);

		service.deleteGoodStrengthen(goods);

		return "redirect:list";

	}
}
