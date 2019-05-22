package controlvehpinten.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import controlvehpinten.entity.Anio;
import controlvehpinten.entity.Cliente;
import controlvehpinten.entity.Ingresovehiculo;
import controlvehpinten.entity.Marca;
import controlvehpinten.entity.Modelo;
import controlvehpinten.services.AnioService;
import controlvehpinten.services.ClienteService;
import controlvehpinten.services.IngresovehiculoService;
import controlvehpinten.services.MarcaService;
import controlvehpinten.services.ModeloService;

@Controller
@RequestMapping("/mttovehiculos")
public class ingresoVehController {
	@Autowired
	private MarcaService marcaService;
	@Autowired
	private ModeloService modeloService;
	@Autowired
	private AnioService anioService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private IngresovehiculoService ingresovehiculoService;

	@Transactional
	@RequestMapping(value="/ingresovehiculo", method=RequestMethod.GET)
	public String ingresoveh(Model model) {
		List<Marca> marcas=marcaService.getMarcas();
		List<Modelo> modelos=modeloService.getModelos();
		List<Anio> anios=anioService.getAnios();
		List<Cliente> clientes=clienteService.getClientes();
		//Ingresovehiculo ingresovehiculo=new Ingresovehiculo();
		
		model.addAttribute("marcas", marcas);
		model.addAttribute("modelos",modelos);
		model.addAttribute("anios",anios);
		model.addAttribute("clientes",clientes);
		model.addAttribute("ingresovehiculo",new Ingresovehiculo());
		model.addAttribute("anio",new Anio());
		
		return "controlvehiculos/ingresoveh";
	}
	//Metodo para obtener modelos al seleccionar una marca.
	@RequestMapping(value = "/modelosxmarca/{marcaId}", method = RequestMethod.POST, produces = "application/json")
    
	public @ResponseBody List<Modelo> getAllModels(/*@RequestParam(value = "marcaId", required = false)*/ @PathVariable("marcaId") Integer marcaId) {
		System.out.println("VALOR PASADO"+marcaId);
		List<Modelo> modelos=modeloService.getModelosxmarca(marcaId);
		System.out.println("TAMAÑO "+modelos.size());
		//List<Modelo> modelos=modeloService.getModelos();
		return modelos;//CREAR metodo en servicio.
    }
	

	@RequestMapping(value="/ingresarveh",method=RequestMethod.POST)
	public String ingresarVehiculo(@RequestParam(value="anio") Integer idanio,@ModelAttribute("ingresovehiculo") Ingresovehiculo ingresovehiculo,BindingResult result,Model model,final RedirectAttributes redirectAttributes) {
				System.out.println("IngresoVE PLACA pasado "+ingresovehiculo.getPlaca());
				System.out.println("ANIO pasado"+ingresovehiculo.getAnio());
				System.out.println("ANIO ENTITY id pasado "+idanio);
				//System.out.println("MARCA pasado "+ingresovehiculo.getModelo().getMarca());
				//int idanio=ingresovehiculo.getAnio().getIdanio();
				
				Anio anio=anioService.getAnio(idanio);
				System.out.println("ANIO NOMBRE "+anio.getAnio());
				ingresovehiculo.setAnio(anio);
				ingresovehiculoService.addIngresovehiculo(ingresovehiculo);
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
				return "redirect:mttovehiculos/ingresovehiculo";		
	}
	 
	  /* @RequestMapping(value = "/listarclientes", method = RequestMethod.GET)
	   public String cargaFormListar(Model model)
	   {
	       List<Cliente> clis = clienteService.getClientes();      
	       model.addAttribute("clis", clis);
	       //List<Detallesaldo> detallesaldoCollection = (List<Detallesaldo>) clis.get(0).getSaldo().getDetallesaldoCollection();
	       return "listarclientes";
	   }*/
	
/*	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {

	        binder.registerCustomEditor(Anio.class, "anio", new PropertyEditorSupport() {
	         @Override
	         public void setAsText(String text) {
	            setValue((text.equals(""))?null:anioService.getAnio(Integer.parseInt((String)text)));
	         }
	     });
	}*/
	
}





