
package com.sportsquest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sportsquest.model.Event;
import com.sportsquest.model.Sport;
import com.sportsquest.model.User;
import com.sportsquest.model.UserEvent;
import com.sportsquest.service.EventService;
import com.sportsquest.service.EventServiceImpl;
import com.sportsquest.service.SportService;
import com.sportsquest.service.SportServiceImpl;
import com.sportsquest.service.UserEventService;
import com.sportsquest.service.UserEventServiceImpl;
import com.sportsquest.service.UserRolesService;
import com.sportsquest.service.UserRolesServiceImpl;
import com.sportsquest.service.UserService;
import com.sportsquest.service.UserServiceImpl;

/**
 * Zbiór głownych kontrolerów (metod nawigacyjnych) obsługujących nawigację po
 * aplikacji oraz odczyt formularzy i wykonywanie metod DAO (Data access object)
 * 
 * @author Mateusz Orczykowski
 * 
 */
@Controller
@SessionAttributes("userList")
public class LinkNavigation {

	@Autowired
	private UserService us;

	@Autowired
	private UserRolesService urs;

	@Autowired
	private UserEventService ues;

	@Autowired
	private EventService es;

	@Autowired
	private SportService ss;

	/**
	 * Kontroler przenoszący na stronę rejestracji
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		ModelAndView model = new ModelAndView();

		model.setViewName("register");

		return model;

	}

	/**
	 * 
	 * Kontroler odczytujący formularz ze strony rejestracji oraz wykonujący
	 * metodę
	 * {@link com.sportsquest.service.UserServiceImpl#addUser(String, String, String, String, String)}
	 * 
	 * @param name
	 *            imię
	 * @param surname
	 *            nazwisko
	 * @param login
	 *            login
	 * @param password
	 *            hasło
	 * @param password2
	 *            hasło
	 * @param city
	 *            miasto
	 * @return ModelAndView
	 * @see com.sportsquest.service.UserServiceImpl#addUser(String, String,
	 *      String, String, String)
	 */
	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public ModelAndView registeredPage(@RequestParam("name") String name, @RequestParam("surname") String surname,
			@RequestParam("login") String login, @RequestParam("password") String password,
			@RequestParam("password2") String password2, @RequestParam("city") String city) {

		ModelAndView model = new ModelAndView();

		if (us.checkLoginAvailable(login) == true) {

			if (password.equals(password2)) {
				us.addUser(name, surname, login, password, city);
				Integer userId = us.getUser(login).getUserId();
				urs.add(userId, 2);
				model.setViewName("regSuccess");
			} else {
				model.addObject("passwordError", true);
				model.setViewName("register");
			}

		} else {
			model.addObject("loginError", true);
			model.setViewName("register");

		}

		return model;

	}

	/**
	 * Kontroler przenoszący na stronę potwierdzającą dodanie nowego użytkownika
	 * do systemu.
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/regSuccess", method = RequestMethod.GET)
	public ModelAndView registerSuccessPage() {
		ModelAndView model = new ModelAndView();

		model.setViewName("regSuccess");

		return model;

	}

	/**
	 * Kontoler przenoszący na stronę dodawania wydarzenia. Sprawdza czy
	 * uzytkownik nie jest zablokowany.
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/addEvent", method = RequestMethod.GET)
	public ModelAndView addEventPage() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		String name = us.getUser(userName).getName();
		ModelAndView model = new ModelAndView();

		List<Sport> sports = ss.getAcceptedSports();

		Integer blocked = us.getUser(userName).getBlocked();

		if (blocked == 0) {
			model.addObject("sports", sports);
			model.setViewName("addEvent");

		} else {
			model.addObject("name", name);
			model.setViewName("blocked");
		}

		return model;

	}

	/**
	 * Kontroler wykonujący metodę
	 * {@link UserEventServiceImpl#removeAllUserEventId(Integer)} oraz
	 * {@link EventServiceImpl#deleteEvent(Integer)} i przenosi na stronę
	 * potwierdzenia wykonanej operacji.
	 * 
	 * @param eventId
	 *            numer ID wydarzenia
	 * @return ModelAndView
	 * @see UserEventServiceImpl#removeAllUserEventId(Integer)
	 * @see EventServiceImpl#deleteEvent(Integer)
	 */
	@RequestMapping(value = "/deleteEvent", method = RequestMethod.POST)
	public ModelAndView deleteEventPage(@RequestParam("eventId") Integer eventId) {
		ModelAndView model = new ModelAndView();
		List<UserEvent> userEventList = ues.getUserEventId(eventId);

		ues.removeAllUserEventId(eventId);
		es.deleteEvent(eventId);
		model.setViewName("deleteEvent");

		return model;

	}

	/**
	 * Kontroler wykonujący metodę
	 * {@link EventServiceImpl#addEvent(String, String, String, String, Integer, Integer, String)}
	 * oraz {@link UserEventServiceImpl#addUserEvent(Integer, Integer)} i przenoszący
	 * na stronę potwierdzenia operacji.
	 * 
	 * @param name
	 *            nazwa
	 * @param city
	 *            miasto
	 * @param desc
	 *            opis
	 * @param date
	 *            data
	 * @param address
	 *            adres
	 * @param sport
	 *            nazwa sportu
	 * @return ModelAndView
	 * @see EventServiceImpl#addEvent(String, String, String, String, Integer,
	 *      Integer, String)
	 * @see UserEventServiceImpl#addUserEvent(Integer, Integer)
	 */
	@RequestMapping(value = "/addingEvent", method = RequestMethod.POST)
	public ModelAndView addEvent(@RequestParam("name") String name, @RequestParam("city") String city,
			@RequestParam("desc") String desc, @RequestParam("date") String date,
			@RequestParam("address") String address, @RequestParam("sport") Integer sport) {

		ModelAndView model = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();

		Integer id = us.getUser(userName).getUserId();

		String[] splitDate = date.toString().split(" ");

		date = splitDate[0];
		String time = splitDate[1] + ".0";

		String newDate;
		String[] words = date.toString().split("-");
		newDate = words[2] + "-" + words[1] + "-" + words[0];

		newDate = newDate + " " + time;
		System.out.println(city);

		es.addEvent(name, newDate, city, address, id, sport, desc);
		List<Event> events = es.getAllEvents();

		Integer event_id = events.get(events.size() - 1).getEventId();

		ues.addUserEvent(id, event_id);

		model.setViewName("addSuccess");

		return model;

	}

	/**
	 * Kontroler przenoszący na stronę okreslonego wydarzenia. Ma dostęp do
	 * listy uczestników danego wydarzenia.
	 * 
	 * @param id
	 *            numer ID wydarzenia
	 * @return ModelAndView
	 * 
	 */
	@RequestMapping(value = "/event", params = "buttonInfo",method = RequestMethod.POST)
	public ModelAndView eventPage(@RequestParam("buttonInfo") Integer id) {
		ModelAndView model = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		Event event = es.getEvent(id);
		Integer userId = us.getUser(userName).getUserId();
		Boolean joined = false;
		User host = us.getUserId(event.getHost_id());
		Integer hostId = host.getUserId();
		List<UserEvent> userEvents = ues.getUserEvent();

		List<User> participants = new ArrayList<User>();

		for (int i = 0; i < userEvents.size(); i++) {
			if (userEvents.get(i).getEventId() == id) {
				participants.add(userEvents.get(i).getUser());

			}
		}

		for (int i = 0; i < participants.size(); i++) {
			if (participants.get(i).getUserId() == userId) {

				joined = true;
				break;

			}
		}
		for (int i = 0; i < participants.size(); i++) {
			if (participants.get(i).getUserId() == host.getUserId()) {
				participants.remove(participants.get(i));
			}
		}

		model.setViewName("event");
		model.addObject("id", id);
		model.addObject("userId", userId);
		model.addObject("joined", joined);
		model.addObject("event", event);
		model.addObject("participants", participants);
		model.addObject("host", host);
		return model;

	}
	@RequestMapping(value = "/event",params = "buttonDelete", method = RequestMethod.POST)
	public ModelAndView adminDeleteEventPage(@RequestParam("buttonDelete") Integer eventId) {
		ModelAndView model = new ModelAndView();
		List<UserEvent> userEventList = ues.getUserEventId(eventId);

		ues.removeAllUserEventId(eventId);
		es.deleteEvent(eventId);
		model.setViewName("deleteEvent");

		return model;

	}

	/**
	 * Kontroler wykonujący metodę
	 * {@link UserEventServiceImpl#addUserEvent(Integer, Integer)} oraz
	 * przenoszący do strony z potwierdzeniem wykonanej operacji.
	 * 
	 * @param eventId
	 *            numer ID wydarzenia
	 * @return ModelAndView
	 * @see UserEventServiceImpl#addUserEvent(Integer, Integer)
	 */
	@RequestMapping(value = "/joinEvent", method = RequestMethod.POST)
	public ModelAndView joinEvent(@RequestParam("eventId") Integer eventId) {
		ModelAndView model = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		Integer userId = us.getUser(userName).getUserId();
		Boolean joined = false;
		List<UserEvent> userEventList = ues.getUserEventId(eventId);

		List<User> participants = new ArrayList<User>();

		for (int i = 0; i < userEventList.size(); i++) {
			if (userEventList.get(i).getEventId() == eventId) {
				participants.add(userEventList.get(i).getUser());

			}
		}

		for (int i = 0; i < participants.size(); i++) {
			if (participants.get(i).getUserId() == userId) {
				joined = true;
				break;
			}
		}

		if (joined == false) {
			ues.addUserEvent(userId, eventId);
			model.setViewName("joinSuccess");

		}

		return model;
	}

	/**
	 * Kontroler wykonujący metodę
	 * {@link UserEventServiceImpl#removeUserEvent(Integer, Integer)} oraz
	 * przenoszący na stronę z potwierdzeniem wykonanej operacji.
	 * 
	 * @param eventId
	 *            Numer ID wydarzenia
	 * @return ModelAndView
	 * @see UserEventServiceImpl#removeUserEvent(Integer, Integer)
	 */
	@RequestMapping(value = "/exitEvent", method = RequestMethod.POST)
	public ModelAndView exitEvent(@RequestParam("eventId") Integer eventId) {
		ModelAndView model = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		Integer userId = us.getUser(userName).getUserId();

		ues.removeUserEvent(userId, eventId);

		model.setViewName("joinFail");

		return model;
	}

	/**
	 * Kontoroler przenoszący na stronę panelu administratora. Ma dostep do
	 * wszystkich uzytkowników, wydarzeń i dyscyplin sportu istniejących w
	 * systemie.
	 * 
	 * @return ModelAndView
	 * @see UserServiceImpl#getAllUsers()
	 * @see SportServiceImpl#getAcceptedSports()
	 * @see SportServiceImpl#getNotAcceptedSports()
	 * @see EventServiceImpl#getAllEventsDate()
	 */
	@RequestMapping(value = "/adminpanel", method = RequestMethod.GET)
	public ModelAndView adminPanelPage() {
		ModelAndView model = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		String role = us.getUser(userName).getRole().getRole();
		List<User> userList = us.getAllUsers();
		List<Sport> sportListAccepted = ss.getAcceptedSports();
		List<Sport> sportListNot = ss.getNotAcceptedSports();

		List<Event> eventList = es.getAllEventsDate();

		model.addObject("eventList", eventList);
		model.addObject("userList", userList);
		model.addObject("rola", role);
		model.addObject("sportList", sportListAccepted);
		model.addObject("sportListNot", sportListNot);
		model.setViewName("adminpanel");

		return model;

	}

	/**
	 * Kontoler wykonujący metody
	 * {@link EventServiceImpl#deleteEventUser(Integer)},
	 * {@link UserRolesServiceImpl#removeUserRole(Integer)},
	 * {@link UserServiceImpl#deleteUser(Integer)} Uwaga ! Usuwa również
	 * wydarzenia stworzone przez tego uzytkownika oraz usuwa go z istniejących
	 * wydarzeń.
	 * 
	 * @param userId
	 *            Numer ID użytkownika
	 * @return ModelAndView
	 * @see EventServiceImpl#deleteEventUser(Integer)
	 * @see  UserRolesServiceImpl#removeUserRole(Integer)
	 * @see UserServiceImpl#deleteUser(Integer)
	 */
	@RequestMapping(value = "/menageUser", params = "buttonDelUser", method = RequestMethod.POST)
	public ModelAndView deleteUser(@RequestParam("buttonDelUser") Integer userId) {
		ModelAndView model = new ModelAndView();

		es.deleteEventUser(userId);
		urs.removeUserRole(userId);
		ues.removeUser(userId);
		us.deleteUser(userId);

		model.setViewName("redirect:/adminpanel");

		return model;

	}

	/**
	 * Kontroler wykonujący metodę {@link UserServiceImpl#activateUser(Integer)}
	 * 
	 * @param userId
	 *            Numer ID użytkownika.
	 * @return ModelAndView
	 * @see UserServiceImpl#activateUser(Integer)
	 */
	@RequestMapping(value = "/menageUser", params = "buttonActivate", method = RequestMethod.POST)
	public ModelAndView activateUser(@RequestParam("buttonActivate") Integer userId) {
		ModelAndView model = new ModelAndView();

		us.activateUser(userId);

		model.setViewName("redirect:/adminpanel");

		return model;

	}

	/**
	 * Kontroler wykonujący metodę {@link UserServiceImpl#blockUser(Integer)}
	 * 
	 * @param userId
	 *            Numer ID użytkownika
	 * @return ModelAndView 
	 * @see UserServiceImpl#blockUser(Integer)
	 */
	@RequestMapping(value = "/menageUser", params = "buttonBlock", method = RequestMethod.POST)
	public ModelAndView blockUser(@RequestParam("buttonBlock") Integer userId) {
		ModelAndView model = new ModelAndView();

		us.blockUser(userId);

		model.setViewName("redirect:/adminpanel");

		return model;

	}

	/**
	 * Kontroler wykonujący metodę
	 * {@link com.sportsquest.service.SportService#acceptSport(Integer)}
	 * 
	 * @see com.sportsquest.service.SportService#acceptSport(Integer)
	 * @param sportId Numer ID dyscypliny sportu
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/menageSport", params = "buttonAdd", method = RequestMethod.POST)
	public ModelAndView acceptSport(@RequestParam("buttonAdd") Integer sportId) {
		ModelAndView model = new ModelAndView();

		ss.acceptSport(sportId);

		model.setViewName("redirect:/adminpanel");

		return model;

	}

	/**
	 * Kontroler wykonujący metodę {@link SportServiceImpl#addSport(String)}  oraz przenosi na stronę dodawania wydarzenia
	 * @param sportName Nazwa sportu
	 * @return ModelAndView
	 * @see  SportServiceImpl#addSport(String)
	 */
	@RequestMapping(value = "/addSport", method = RequestMethod.POST)
	public ModelAndView addSport(@RequestParam("sportName") String sportName) {
		ModelAndView model = new ModelAndView();

		ss.addSport(sportName);

		model.setViewName("redirect:/addEvent");

		return model;

	}

	/**
	 * Kontroler wykonujący metodę {@link SportServiceImpl#deleteSport(Integer)}
	 * @param sportId Numer ID dyscypliny sportu
	 * @return ModelAndView
	 * @see SportServiceImpl#deleteSport(Integer)
	 */
	@RequestMapping(value = "/menageSport", params = "buttonDel", method = RequestMethod.POST)
	public ModelAndView deleteSport(@RequestParam("buttonDel") Integer sportId) {
		ModelAndView model = new ModelAndView();

		ss.deleteSport(sportId);

		model.setViewName("redirect:/adminpanel");

		return model;

	}

	/**
	 * Kontroler przenoszący na stronę obsługi błedu http 403
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView errorPage() {
		ModelAndView lista = new ModelAndView();
		lista.setViewName("403");
		return lista;
	}

	/**
	 * Kontroler przenoszący na strone propozycji dodania nowego sportu do systemu
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/sport-add", method = RequestMethod.GET)
	public ModelAndView sportAddPage() {
		ModelAndView lista = new ModelAndView();
		lista.setViewName("sport-add");
		return lista;
	}

}
