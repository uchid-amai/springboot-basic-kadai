package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;




@Controller
public class ToDoController {
	// 依存性の注入（DI）を行う（コンストラクタインジェクション）
	private final ToDoService todoService;
	
	public ToDoController(ToDoService todoService) {
		this.todoService = todoService;
	}
	//ビュー(todoView)の画面を表示
	@GetMapping("/")
	public String todoView(Model model) {
		// データベースを取得
		List<ToDo> todos = todoService.getAllTodos();
		model.addAttribute("todos", todos);
		
		return "todoView";
	}
	
	
}
