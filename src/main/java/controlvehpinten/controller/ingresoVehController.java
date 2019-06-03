package controlvehpinten.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import controlvehpinten.entity.Anio;
import controlvehpinten.entity.Asesor;
import controlvehpinten.entity.Cliente;
import controlvehpinten.entity.Estado;
import controlvehpinten.entity.Ingresovehiculo;
import controlvehpinten.entity.Marca;
import controlvehpinten.entity.Modelo;
import controlvehpinten.services.AnioService;
import controlvehpinten.services.AsesorService;
import controlvehpinten.services.ClienteService;
import controlvehpinten.services.EstadoService;
import controlvehpinten.services.IngresovehiculoService;
import controlvehpinten.services.MarcaService;
import controlvehpinten.services.ModeloService;

@Controller
@RequestMapping("/mttovehiculos")
public class IngresoVehController {
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
	@Autowired
	private AsesorService asesorService;
	@Autowired
	private EstadoService estadoService;

	@Transactional
	@RequestMapping(value="/ingresovehiculo", method=RequestMethod.GET)
	public String ingresoveh(Model model) {
		List<Marca> marcas=marcaService.getMarcas();
		List<Modelo> modelos=modeloService.getModelos();
		List<Anio> anios=anioService.getAnios();
		List<Cliente> clientes=clienteService.getClientes();
		//Ingresovehiculo ingresovehiculo=new Ingresovehiculo();
		List<Ingresovehiculo> ingresos=ingresovehiculoService.getIngresovehiculos();
		model.addAttribute("marcas", marcas);
		model.addAttribute("modelos",modelos);
		model.addAttribute("anios",anios);
		model.addAttribute("clientes",clientes);
		model.addAttribute("ingresovehiculo",new Ingresovehiculo());
		model.addAttribute("anio",new Anio());
		model.addAttribute("vehiculosingresados",ingresos);
		return "controlvehiculos/ingresoveh";
	}
	//Metodo para obtener modelos al seleccionar una marca.
	@RequestMapping(value = "/modelosxmarca/{marcaId}", method = RequestMethod.POST, produces = "application/json")
    
	public @ResponseBody List<Modelo> getAllModels(@PathVariable("marcaId") Integer marcaId) {
		System.out.println("VALOR PASADO"+marcaId);
		List<Modelo> modelos=modeloService.getModelosxmarca(marcaId);
		System.out.println("TAMAÑO "+modelos.size());
		//List<Modelo> modelos=modeloService.getModelos();
		return modelos;//CREAR metodo en servicio.
    }
	

	@RequestMapping(value="/ingresarveh",method=RequestMethod.POST)
	public String ingresarVehiculo(@RequestParam(value="modelo") Integer idmodelo,@RequestParam(value="fechaing") 
	Date fechai,@ModelAttribute("ingresovehiculo") 
	Ingresovehiculo ingresovehiculo,BindingResult result,
	Model model,final RedirectAttributes redirectAttributes) {
				Asesor asesor=asesorService.getAsesor(1);//obtener de bd
				Anio anio=anioService.getAnio(ingresovehiculo.getAnio().getIdanio());
				Modelo modelo=modeloService.getModelo(idmodelo);
				Cliente cliente=clienteService.getCliente(ingresovehiculo.getCliente().getIdcliente());
				Estado estado=estadoService.getEstado(1);
				//Estado estado=estadoService.
				ingresovehiculo.setAnio(anio);
				ingresovehiculo.setModelo(modelo);
				ingresovehiculo.setAsesor(asesor);
				ingresovehiculo.setCliente(cliente);
				ingresovehiculo.setEstado(estado);
				ingresovehiculo.setFechaingreso(fechai);
				ingresovehiculoService.addIngresovehiculo(ingresovehiculo);
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
				return "redirect:ingresovehiculo";		
		}
	 
	 /*@RequestMapping(value = "/listarclientes", method = RequestMethod.GET)
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





