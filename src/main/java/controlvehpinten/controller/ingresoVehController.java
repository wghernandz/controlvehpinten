package controlvehpinten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;


import controlvehpinten.entity.Marca;
import controlvehpinten.services.MarcaService;

@Controller
public class ingresoVehController {
	@Autowired
	private MarcaService marcaService;

	@Transactional
	@RequestMapping(value="/ingresovehiculo", method=RequestMethod.GET)
	public String ingresoveh(Model model) {
		List<Marca> marcas=marcaService.getMarcas();
		model.addAttribute("marcas", marcas);
		
		return "controlvehiculos/ingresoveh";
	}
	
	 /*@Transactional
	   @RequestMapping(value = "/listarclientes", method = RequestMethod.GET)
	   public String cargaFormListar(Model model)
	   {
	       List<Clientes> clis = dao.allClientes();      
	       model.addAttribute("clis", clis);
	       //List<Detallesaldo> detallesaldoCollection = (List<Detallesaldo>) clis.get(0).getSaldo().getDetallesaldoCollection();
	       
	       return "listarclientes";
	   }*/
}





