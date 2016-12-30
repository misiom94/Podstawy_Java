package com.sportsquest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sportsquest.model.Event;
import com.sportsquest.model.Role;
import com.sportsquest.service.EventService;
import com.sportsquest.service.UserService;

/**
 * Zbiór kontrolerów (metod nawigacyjnych) odpowiedzialnych za zalogowanie do
 * systemu oraz przeniesienie na odpowiednie strony startowe w zalezności od
 * roli
 * 
 * @author Mateusz Orczykowski
 *
 */
@Controller
public class SecurityNavigation {
	@Autowired
	private UserService us;

	@Autowired
	private EventService es;

	/**
	 * Kontroler przenoszący na stronę logowania
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("login-form");
	}

	/**
	 * Kontroler przenoszący na stronę logowania
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		return new ModelAndView("login-form");
	}
	/**
	 * Kontroler przenoszący na stronę logowania pokazujący komunikat o błędnym logowaniu
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/error-login", method = RequestMethod.GET)
	public ModelAndView invalidLogin() {
		ModelAndView modelAndView = new ModelAndView("login-form");
		modelAndView.addObject("error", true);
		return modelAndView;
	}

	/**
	 * Kontroler przenoszący na odpowiednią stronę startową po pomyślnym zalogowaniu
	 * @return ModelAndView
	 * @see org.springframework.security.core.context.SecurityContextHolder
	 */
	@RequestMapping(value = "/success-login", method = RequestMethod.GET)
	public ModelAndView successLogin() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		Role role = us.getUser(userName).getRole();
		ModelAndView model = new ModelAndView();

		if (role.getRole().equals("admin")) {

			model.setViewName("redirect:/admin");

		}
		if (role.getRole().equals("user")) {

			model.setViewName("redirect:/user");

		}

		return model;

	}

	/**
	 * Kontroler przenoszący na stronę główną użytkownika
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView userPage() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		String name = us.getUser(userName).getName();
		String role = us.getUser(userName).getRole().getRole();
		ModelAndView model = new ModelAndView();

		List<Event> eventList = es.getAllEventsDate();

		model.addObject("eventList", eventList);
		model.addObject("name", name);
		model.addObject("rola", role);

		Integer blocked = us.getUser(userName).getBlocked();

		if (blocked == 0) {
			model.setViewName("user");

		} else {
			model.setViewName("blocked");
		}
		return model;
	}

	/**
	 * Kontroler przenoszący na stronę główną administratora
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		String name = us.getUser(userName).getName();
		String role = us.getUser(userName).getRole().getRole();

		ModelAndView model = new ModelAndView();

		List<Event> eventList = es.getAllEventsDate();
		model.addObject("eventList", eventList);
		model.addObject("name", name);
		model.addObject("rola", role);
		model.setViewName("admin");
		return model;
	}
	/**
	 * Kontroler przenoszący na stronę główną zablokowanego użytkownika
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/block", method = RequestMethod.GET)
	public ModelAndView blockedPage() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		String name = us.getUser(userName).getName();
		String role = us.getUser(userName).getRole().getRole();

		ModelAndView model = new ModelAndView();

		model.addObject("name", name);
		model.addObject("rola", role);
		model.setViewName("blocked");
		return model;
	}

}
