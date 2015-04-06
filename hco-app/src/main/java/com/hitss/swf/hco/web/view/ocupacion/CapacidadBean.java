package com.hitss.swf.hco.web.view.ocupacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.CellEditEvent;

import com.hitss.swf.hco.capacidad.vo.FiltroRegistroCapacidad;
import com.hitss.swf.hco.catalogo.service.CatalogoService;
import com.hitss.swf.hco.catalogo.service.ColaboradorService;
import com.hitss.swf.hco.catalogo.service.Constantes;
import com.hitss.swf.hco.model.capacidad.ConsultaRegistroCapacidad;
import com.hitss.swf.hco.model.catalogo.AreaConocimiento;
import com.hitss.swf.hco.model.catalogo.Colaborador;
import com.hitss.swf.hco.model.catalogo.Division;
import com.hitss.swf.hco.model.catalogo.Fabrica;
import com.hitss.swf.hco.ocupacion.service.RegistroCapacidadService;
import com.hitss.swf.hco.ocupacion.vo.ConsultaCapacidadVO;

@ManagedBean
@SessionScoped
public class CapacidadBean {

	@EJB
	private ColaboradorService colaboradorService;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private RegistroCapacidadService capacidadService;

	private List<Colaborador> gerentes;

	private List<Fabrica> fabricas;

	private List<Division> divisiones;

	private List<AreaConocimiento> areasConocimiento;

	private List<String> meses;

	private ConsultaCapacidadVO capacidad;

	private List<Colaborador> colaboradores;

	private List<ConsultaRegistroCapacidad> registroCapacidad;

	private FiltroRegistroCapacidad filtro = new FiltroRegistroCapacidad();

	@PostConstruct
	public void init() {
		if (gerentes == null) {
			gerentes = colaboradorService.consultarGerentes("40-580");
		}

		if (meses == null) {
			cargarMeses();
		}
	}

	public void seleccionarGerente() {
		if (-1 == this.filtro.getIdGerente()) {
			limpiarListasGerente();
		} else {
			cargarListasGerente();
		}
	}

	public void seleccionarFabrica() {
		if (-1 == this.filtro.getIdFabrica()) {
			limpiarListasFabrica();
		} else {
			cargarListasFabrica();
		}
	}

	public void buscarOcupacion() {
		try {
			filtro.setUsuarioFirmado("40-580");
			capacidad = capacidadService.consultarCapacidad(filtro);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editarCapacidad(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		if (oldValue instanceof Integer && newValue instanceof Integer) {
			ConsultaRegistroCapacidad registro = this.capacidad
					.getCapacidades().get(event.getRowIndex());
			registro.setCapacidadMensual(registro.getCapacidadMensual()
					- ((Integer) oldValue) + ((Integer) newValue));
			registro.setCapacidadProductiva(registro.getCapacidadProductiva()
					- ((Integer) oldValue) + ((Integer) newValue));
		}
	}

	public void guardarOcupacion() {
		try {
			capacidadService.registrarCapacidad("40-580", filtro.getMesAsDate(),
					registroCapacidad);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<String> cargarMeses() {
		SimpleDateFormat formatter = new SimpleDateFormat(
				Constantes.FORMATO_FECHA_FILTRO);
		meses = new ArrayList<String>(7);
		Calendar hoy = Calendar.getInstance();
		this.filtro.setMes(formatter.format(hoy.getTime()));
		hoy.add(Calendar.MONTH, -1);
		for (int i = 1; i <= 8; i++) {
			meses.add(formatter.format(hoy.getTime()));
			hoy.add(Calendar.MONTH, 1);
		}

		return meses;
	}

	private void limpiarListasGerente() {
		this.fabricas = null;
		this.divisiones = null;
		this.areasConocimiento = null;
	}

	private void cargarListasGerente() {
		this.fabricas = catalogoService
				.consultarFabricas(filtro.getIdGerente());
		this.divisiones = catalogoService.consultarDivisiones(filtro
				.getIdGerente());
		this.areasConocimiento = catalogoService
				.consultarAreasConocimiento(filtro.getIdGerente());
	}

	public List<Colaborador> getGerentes() {
		return gerentes;
	}

	public void setGerentes(List<Colaborador> gerentes) {
		this.gerentes = gerentes;
	}

	public FiltroRegistroCapacidad getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroRegistroCapacidad filtro) {
		this.filtro = filtro;
	}

	public List<Fabrica> getFabricas() {
		return fabricas;
	}

	public void setFabricas(List<Fabrica> fabricas) {
		this.fabricas = fabricas;
	}

	public List<Division> getDivisiones() {
		return divisiones;
	}

	public void setDivisiones(List<Division> divisiones) {
		this.divisiones = divisiones;
	}

	public List<AreaConocimiento> getAreasConocimiento() {
		return areasConocimiento;
	}

	public void setAreasConocimiento(List<AreaConocimiento> areasConocimiento) {
		this.areasConocimiento = areasConocimiento;
	}

	public List<String> getMeses() {
		return meses;
	}

	public void setMeses(List<String> meses) {
		this.meses = meses;
	}

	public ConsultaCapacidadVO getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(ConsultaCapacidadVO capacidad) {
		this.capacidad = capacidad;
	}

	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	private void cargarListasFabrica() {
		this.colaboradores = colaboradorService.consultarPorFabrica(this.filtro
				.getIdFabrica());
	}

	private void limpiarListasFabrica() {
		this.colaboradores = null;
	}

	public List<ConsultaRegistroCapacidad> getRegistroCapacidad() {
		return registroCapacidad;
	}

	public void setRegistroCapacidad(
			List<ConsultaRegistroCapacidad> registroCapacidad) {
		this.registroCapacidad = registroCapacidad;
	}

}
