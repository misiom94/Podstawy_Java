

package com.sportsquest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sportsquest.model.User;
import com.sportsquest.service.UserService;

/**
 *  Zbiór kontrolerów odpowiedzialnych za zmianę hasła użytkownika
 *  @author Mateusz Orczykowski
 * 
 * 
 * 
 */
@Controller
public class ChangePassword {
	@Autowired
	private UserService us;

	/**
	 * Kontroler który przenosi na stronę zmiany hasła
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/change", method = RequestMethod.GET)
	public ModelAndView changePage() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();

		String login = us.getUser(userName).getLogin();

		String role = us.getUser(userName).getRole().getRole();

		ModelAndView lista = new ModelAndView();

		lista.setViewName("change");
		return lista;
	}

	/**
	 * 
	 * Kontroler który sprawdza i porównuje czy użytkownik zna stare hasło i czy
	 * nowe hasła są takie same następnie wykonuje metodę {@link com.sportsquest.service.UserService#changePassword(Integer, String)}
	 * 
	 * @param oldpassword
	 *            stare haslo
	 * @param newpassword1
	 *            nowe haslo
	 * @param newpassword2
	 *            nowe haslo
	 *  
	 *  @see com.sportsquest.service.UserService#changePassword(Integer, String)
	 *  
	 * @return ModelAndView
	 */

	@RequestMapping(value = "/password-verify", method = RequestMethod.POST)
	public ModelAndView passwordVerify(@RequestParam("oldpassword") String oldpassword,
			@RequestParam("newpassword1") String newpassword1, @RequestParam("newpassword2") String newpassword2) {

		ModelAndView model = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();

		Integer user_id = us.getUser(userName).getUserId();
		String login = us.getUser(userName).getLogin();
		String pass = us.getUser(userName).getPassword();

		if (pass.equals(oldpassword)) // Stare hasla ok
		{

			if (oldpassword.equals(newpassword1)) // Stare takie jak nowe
			{
				model.addObject("error2", true);

			} else {
				if (newpassword1.equals(newpassword2)) // Zmiana hasla
				{

					us.changePassword(user_id, newpassword1);
					model.addObject("correct", true);

				} else // Nowe hasla sa rozne
				{
					model.addObject("error3", true);

				}
			}
		} else // Stare hasla error
		{
			model.addObject("error1", true);

		}

		model.setViewName("change");
		return model;

	}

}
