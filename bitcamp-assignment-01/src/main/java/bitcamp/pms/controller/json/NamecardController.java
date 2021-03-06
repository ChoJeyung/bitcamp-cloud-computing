package bitcamp.pms.controller.json;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.pms.domain.Namecard;
import bitcamp.pms.service.NamecardService;

@RestController
@RequestMapping("/namecard")
public class NamecardController {

	@Autowired
	NamecardService namecardService;

	@RequestMapping("list")
	public Object list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size)
	        throws Exception {

		if (page < 1)
			page = 1;
		if (size < 1 || size > 20)
			size = 3;

		List<Namecard> list = namecardService.list(page, size);

		HashMap<String, Object> data = new HashMap<>();
		data.put("list", list);
		data.put("page", page);
		data.put("size", size);
		data.put("totalPage", namecardService.getTotalPage(size));

		return data;
	}

	@GetMapping("form")
	public void form() {
	}

	@PostMapping("add")
	public Object add(Namecard namecard) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		namecardService.add(namecard);
		result.put("status", "success");

		return result;
	}

	@RequestMapping("delete")
	public Object delete(String name) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		if (namecardService.delete(name) == 0) {
			result.put("status", "fail");
			result.put("error", "해당 아이디가 없습니다.");
		} else {
			result.put("status", "success");
		}
		return result;
	}

	@RequestMapping("update")
	public Object update(Namecard namecard) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		if (namecardService.update(namecard) == 0) {
			result.put("status", "fail");
			result.put("error", "해당 아이디가 없습니다.");
		} else {
			result.put("status", "success");
		}
		return result;
	}

	@RequestMapping("view/{name}")
	public Object view(@PathVariable String name) throws Exception {

		HashMap<String, Object> data = new HashMap<>();
		data.put("namecard", namecardService.get(name));

		return data;
	}

}
