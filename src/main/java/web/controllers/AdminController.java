package web.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.RoleService;
import web.service.UserService;

@Controller
public class AdminController {
    private UserService service;
    private RoleService roleService;

    public AdminController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }
    @GetMapping("/admin")
    public String admin(Model model, Authentication authentication) {
        User user = service.getUserByLogin(authentication.getName());
        model.addAttribute("currentuser", user);
        model.addAttribute("all_users", service.getAllUsers());

        return "admin";
    }


    @GetMapping("/admin/create")
    public String create(Model model) {
        model.addAttribute("new_user", new User());
        return "create";
    }

    @PostMapping("/admin/create")
    public String create(@ModelAttribute("new_user") User u, @RequestParam("new_user_roles") String rol) {
        u.setRoles(roleService.getRolesFromText(rol));
        service.addUser(u);
        return "redirect:/admin";
    }


    @GetMapping("admin/{id}/update")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "update";
    }

    @PatchMapping("/admin/update")
   public String updateUser(@ModelAttribute("user") User u, @RequestParam("user_roles") String rol) {
          u.setRoles(roleService.getRolesFromText(rol));

        service.updateUser(u);
        return "redirect:/admin";
    }


    @GetMapping("/admin/delete")
    public String delete() {
        return "delete";
    }

    @DeleteMapping("/admin/delete")
    public String delete(@RequestParam("delete_id") Long id) {
        service.deleteUser(id);
        return "redirect:/admin";
    }


}
