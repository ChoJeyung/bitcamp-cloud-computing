package bitcamp.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.pms.domain.Namecard;
import bitcamp.pms.service.NamecardService;

@Controller
@RequestMapping("/namecard")
public class NamecardController {

    @Autowired NamecardService namecardService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(defaultValue="1") int page, 
            @RequestParam(defaultValue="3") int size,
            Model model) throws Exception {
        
        if (page < 1) page = 1;
        if (size < 1 || size > 20) size = 3;
        
        List<Namecard> list = namecardService.list(page, size);
        
        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPage", 
                namecardService.getTotalPage(size));

        return "namecard/list";
    }
    
    @GetMapping("form")
    public void form() {
    }
    
    @PostMapping("add")
    public String add(Namecard namecard) throws Exception {
        
        namecardService.add(namecard);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(String name) throws Exception {
        
        namecardService.delete(name); 
        return "redirect:list";
       
    }
    
    @RequestMapping("update")
    public String update(Namecard namecard) throws Exception {
        
        if (namecardService.update(namecard) == 0) {
            return "namecard/updatefail";
        } else {
            return "redirect:list";
        }
    }
    
    @RequestMapping("view/{id}")
    public String view(
            @PathVariable String name,
            Model model) throws Exception {
        
        Namecard namecard = namecardService.get(name);
        model.addAttribute("namecard", namecard);
        return "namecard/view";
    }

}










