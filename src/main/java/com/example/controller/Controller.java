package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Coleccion;
import com.example.model.Material;
import com.example.model.Modelo;
import com.example.model.Plan;
import com.example.model.Proveedor;
import com.example.model.Tipo;
import com.example.model.Usuario;
import com.example.repositories.ColeccionRepository;
import com.example.repositories.MaterialRepository;
import com.example.repositories.ModeloRepository;
import com.example.repositories.ProveedorRepository;
import com.example.repositories.TipoRepository;
import com.example.repositories.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/dssd")

public class Controller {
	@Autowired
	private ColeccionRepository coleccionRepository;
	

	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	//  CONTROLERS COLECCION
	
	@PostMapping("/createColeccion")
	 public ResponseEntity<Coleccion> createColeccion(@RequestBody Coleccion coleccion) {
		 System.out.println("Entra al controller Coleccion");
		 coleccionRepository.save(coleccion);
		 return new ResponseEntity<Coleccion>(coleccion, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/updateColeccion")
	 public  ResponseEntity<Coleccion> updateEmprendimiento(@RequestParam long id, @RequestBody Coleccion coleccion) {
		 Optional<Coleccion> current = coleccionRepository.findById(id);
		 if(current.isEmpty()){
			 return new ResponseEntity<Coleccion>(HttpStatus.NOT_FOUND);
		 }
		 current.get().setCaracteristicas(coleccion.getCaracteristicas());
		 current.get().setDescripcionLentes(coleccion.getDescripcionLentes());
		 current.get().setFechaFin(coleccion.getFechaFin());
		 current.get().setFechaInicio(coleccion.getFechaInicio());
		 current.get().setUsuario(coleccion.getUsuario());
		 current.get().setModelos(coleccion.getModelos());
		 coleccionRepository.save(current.get());
		 
		 return new ResponseEntity<Coleccion>(current.get(),HttpStatus.OK);
	  }
	
	@GetMapping("/getColeccion")
	 public ResponseEntity<Coleccion> getColeccion(@RequestParam long id){
		 System.out.println("Entra al controller Coleccion");
		 Optional<Coleccion> coleccion = coleccionRepository.findById(id);
		 if (coleccion.isEmpty()) {
			 return new ResponseEntity<Coleccion>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Coleccion>(coleccion.get(), HttpStatus.OK);
	 }
	
	@GetMapping("/getListaColecciones")
	 public ResponseEntity<List<Coleccion>> getListaColecciones() {
		 System.out.println("Entra al controller  Coleccion");
		 List<Coleccion> colecciones = coleccionRepository.findAll();
		 if (colecciones.isEmpty()) {
			 System.out.println("user es vacio");
			 return new ResponseEntity<List<Coleccion>>(HttpStatus.NOT_FOUND);
		 }
		 System.out.println("user no es vacio");
		 return new ResponseEntity<List<Coleccion>>(colecciones, HttpStatus.OK);
	 }
	
	//  CONTROLERS material
	
	@PostMapping("/createMaterial")
	 public ResponseEntity<Material> createDonacion(@RequestBody Material material) {
		 System.out.println("Entra al controller c material");
		 materialRepository.save(material);
		 return new ResponseEntity<Material>(material, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/updateMaterial")
	 public  ResponseEntity<Material> updateMaterial(@RequestParam long id, @RequestBody Material material) {
		 Optional<Material> current = materialRepository.findById(id);
		 if(current.isEmpty()){
			 return new ResponseEntity<Material>(HttpStatus.NOT_FOUND);
		 }
		 current.get().setCantidad(material.getCantidad());
		 current.get().setNombre(material.getNombre());
		 current.get().setFechaInicio(material.getFechaInicio());
		 current.get().setFechaFin(material.getFechaFin());
		 current.get().setProveedor(material.getProveedor());
		 materialRepository.save(current.get());
		 
		 return new ResponseEntity<Material>(current.get(),HttpStatus.OK);
	  }
	
	@GetMapping("/getListaMateriales")
	 public ResponseEntity<List<Material>> getListaMateriales() {
		 System.out.println("Entra al controller  Material");
		 List<Material> materiales = materialRepository.findAll();
		 if (materiales.isEmpty()) {
			 return new ResponseEntity<List<Material>>(HttpStatus.NOT_FOUND);
		 }

		 return new ResponseEntity<List<Material>>(materiales, HttpStatus.OK);
	 }
	
	
	
	
	//  CONTROLERS modelo
	
	//anda
	@PostMapping("/createModelo")
	 public ResponseEntity<Modelo> createEmprendimiento(@RequestBody Modelo modelo) {
		 System.out.println("Entra al controller create modelo");
		 modeloRepository.save(modelo);
		 return new ResponseEntity<Modelo>(modelo, HttpStatus.CREATED);
	}
	
	@GetMapping("/getModelo")
	 public ResponseEntity<Modelo> getModelo(@RequestParam long id) {
		 System.out.println("Entra al controller Modelo");
		 Optional<Modelo> modelo = modeloRepository.findById(id);
		 if (modelo.isEmpty()) {
			 return new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Modelo>(modelo.get(), HttpStatus.OK);
	 }
	
	@GetMapping("/getListamodelos")
	 public ResponseEntity<List<Modelo>> getListaModelo() {
		 System.out.println("Entra al controller  modelo");
		 List<Modelo> modelos = modeloRepository.findAll();
		 if (modelos.isEmpty()) {
			 return new ResponseEntity<List<Modelo>>(HttpStatus.NOT_FOUND);
		 }

		 return new ResponseEntity<List<Modelo>>(modelos, HttpStatus.OK);
	 }
	
	

	
	//  CONTROLERS tipo
	
	@PostMapping("/createTipo")
	 public ResponseEntity<Tipo> createPlan(@RequestBody Tipo tipo) {
		 System.out.println("Entra al controller tipo");
		 tipoRepository.save(tipo);
		 return new ResponseEntity<Tipo>(tipo, HttpStatus.CREATED);
	}
	
	@GetMapping("/getTipo")
	 public ResponseEntity<Tipo> getTipo(@RequestParam long id) {
		 System.out.println("Entra al controller Tipo");
		 Optional<Tipo> tipo = tipoRepository.findById(id);
		 if (tipo.isEmpty()) {
			 return new ResponseEntity<Tipo>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Tipo>(tipo.get(), HttpStatus.OK);
	 }
	
	@GetMapping("/getListaTipos")
	 public ResponseEntity<List<Tipo>> getListaTipo() {
		 System.out.println("Entra al controller  Tipo");
		 List<Tipo> tipo = tipoRepository.findAll();
		 if (tipo.isEmpty()) {
			 return new ResponseEntity<List<Tipo>>(HttpStatus.NOT_FOUND);
		 }

		 return new ResponseEntity<List<Tipo>>(tipo, HttpStatus.OK);
	 }

	
	// CONTROLERS Usuario
	
	@PostMapping("/registrarUsuario")
	 public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario user) {
		 System.out.println("Entra al controller");
		 usuarioRepository.save(user);
		 return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	 }
	
	
	@GetMapping("/getUsuario")
	 public ResponseEntity<String> getUsuario(@RequestParam long id) throws JsonProcessingException {
		 System.out.println("Entra al controller");
		 ObjectMapper theBadMapper = new ObjectMapper();
		 Optional<Usuario> user = usuarioRepository.findById(id);
		 if (user.isEmpty()) {
			 System.out.println("user es vacio");
			 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		 }
		 System.out.println(user.get().getColeccion());
		 String theJsonText = theBadMapper.writeValueAsString(user.get());
		 return new ResponseEntity<String>(theJsonText, HttpStatus.OK);
	 }
	
	@GetMapping("/getListaUsuarios")
	 public ResponseEntity<List<Usuario>> getListaUsuarios() {
		 System.out.println("Entra al controller");
		 List<Usuario> users = usuarioRepository.findAll();
		 if (users.isEmpty()) {
			 System.out.println("user es vacio");
			 return new ResponseEntity<List<Usuario>>(HttpStatus.NOT_FOUND);
		 }
		 System.out.println("user no es vacio");
		 return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
	 }

	
	@GetMapping("/getUserUsername")
	 public ResponseEntity<Usuario> getUser(@RequestParam String username){
		 System.out.println("Entra al controller");
		 Usuario usuario = usuarioRepository.findByNombre(username);
		 if (usuario==null) {
			 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	 }
	
	
	
	
	
	//proveedor
	
	@PostMapping("/createProveedor")
	 public ResponseEntity<Proveedor> createPlan(@RequestBody Proveedor proveedor) {
		 System.out.println("Entra al controller tipo");
		 proveedorRepository.save(proveedor);
		 return new ResponseEntity<Proveedor>(proveedor, HttpStatus.CREATED);
	}
	
	@GetMapping("/getProveedor")
	 public ResponseEntity<Proveedor> getProveedor(@RequestParam long id) {
		 System.out.println("Entra al controller");
		 Optional<Proveedor> prove = proveedorRepository.findById(id);
		 if (prove.isEmpty()) {
			 System.out.println("user es vacio");
			 return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
		 }
		 System.out.println("user no es vacio");
		 return new ResponseEntity<Proveedor>(prove.get(), HttpStatus.OK);
	 }
}
