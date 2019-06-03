/**
 * 
 */
package controlvehpinten.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import controlvehpinten.entity.Ingresovehiculo;
import controlvehpinten.entity.Marca;
import controlvehpinten.services.AsesorService;
import controlvehpinten.services.ClienteService;
import controlvehpinten.services.EstadoService;
import controlvehpinten.services.IngresovehiculoService;
import controlvehpinten.services.MarcaService;

/**
 * @author willian
 *
 */
@Controller
@RequestMapping("/flujovehiculo")
public class FlujoVehiculoController {
	@Autowired
	private IngresovehiculoService ingresovehiculoService;
	@Autowired
	private AsesorService asesorService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private MarcaService marcaService;
	
	@RequestMapping(value="/estado",method=RequestMethod.GET)
	public String vehiculosEstado(Model model) {
		List<Ingresovehiculo> ingresoveh=ingresovehiculoService.getIngresovehiculos();
		List<Marca> marcas=marcaService.getMarcas();
		model.addAttribute("listavehestado",ingresoveh);
		model.addAttribute("marcas",marcas);
		return("controlvehiculos/vehiculoestado");
	}
}
