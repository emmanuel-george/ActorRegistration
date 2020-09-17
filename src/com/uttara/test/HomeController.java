package com.uttara.test;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uttara.services.ActorService;

@Controller
public class HomeController {
	@Autowired
	ActorService service;
	
	@RequestMapping({"/","home"})
	public String showHome()
	{
		System.out.println("in HC showHome()");
		return "Home";
	}
	/*@RequestMapping("/openRegisterView")
	public String openRegister(Model model)
	{
		System.out.println("in HC openRegister()");
		RegBean rb=new RegBean();
		model.addAttribute("bean",rb);
		return "Register";
	}
	@RequestMapping("/register")
	public String register(@ModelAttribute("bean")@Validated RegBean rb,BindingResult result,Model model)
	{
		if(result.hasErrors()) {
			return "Register";
		}
		else
		{
			
			String res=service.register(rb);
			if(res.equals("SUCCESS"))
			{
				model.addAttribute("msg","Your registeration has benn succedded");
				return "Success";
			}
			else
			{
				model.addAttribute("errorMsg","Your Registeration has failed");
				return "Register";
			}
		
	    }
	}*/
	
	@RequestMapping("/displayActors")
	public String showActors(Model model)
	{
		List<Actor> actors=service.listActors();
		model.addAttribute("listactors", actors);
		return "DisplayActors";
	}
	@RequestMapping("/openAddActorView")
	public String showAddActor(Model model)
	{
		Actor actor=new Actor();
		model.addAttribute("actor",actor);
		return "AddActor";
	}
	
	@RequestMapping("/addActor")
	public String addActor(@ModelAttribute("actor")@Valid Actor bean,BindingResult result,Model model)
	{
		System.out.println("actor= "+bean);
		if(result.hasErrors())
		{
			return "AddActor";
		}
		else {
			String msg=service.createActor(bean);
			model.addAttribute("msg",msg);
			return "Success";
		}
		
		
	}
	@RequestMapping("/deleteActor")
	public String deleteActor(Long id,Model model)
	{
		String msg=service.deleteActor(id);
		model.addAttribute("msg", msg);
		return "Success";
		
	}
	@RequestMapping("/openUpdateActor")
	public String OpenUpdateActor(Long id,Model model)
	{
		Actor a=service.openUpdateactor(id);
		model.addAttribute("actor",a);
		model.addAttribute("id",id);
		return "UpdateActor";
	}
	@RequestMapping("/updateActor")
	public String updateActor(@ModelAttribute("actor")@Valid Actor bean,BindingResult result,Model model,Long id)
	{
		System.out.println("actor= "+bean);
		if(result.hasErrors())
		{
			return "UpdateActor";
		}
		else {
			String msg=service.updateActor(bean);
			model.addAttribute("msg",msg);
			return "Success";
		}
	}
}

