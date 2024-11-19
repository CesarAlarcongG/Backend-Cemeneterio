package com.Backend.BackendCementerio.initBD;

import com.Backend.BackendCementerio.negocio.persistencia.models.EstadoServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.Servicios;
import com.Backend.BackendCementerio.negocio.persistencia.models.enums.EstadoServicioEnum;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.EstadoServicioRepository;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.ServicioRepository;
import com.Backend.BackendCementerio.usuario.persistence.model.Enums.PermisoEnum;
import com.Backend.BackendCementerio.usuario.persistence.model.Enums.RolEnum;
import com.Backend.BackendCementerio.usuario.persistence.model.Permisos;
import com.Backend.BackendCementerio.usuario.persistence.model.Rol;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IPermisosRepository;
import com.Backend.BackendCementerio.usuario.persistence.repositoy.IRolRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales {

    @Autowired
    private IRolRepository rol;
    @Autowired
    private IPermisosRepository permisos;
    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private EstadoServicioRepository estadoServicioRepository;

    @PostConstruct
    public void initDatabase() {

        //Valores de la Tabla ROL
        if (rol.count() == 0) {
            Rol rolUsuario = new Rol();
            rolUsuario.setRol(RolEnum.USUARIO);
            rol.save(rolUsuario);

            Rol rolAdmin = new Rol();
            rolAdmin.setRol(RolEnum.ADMININISTRADOR);
            rol.save(rolAdmin);
        }

        //Valores de la tabla Permisos
        if (permisos.count() == 0) {

            //Actualizar
            Permisos permisoActualizar = new Permisos();
            permisoActualizar.setPermiso(PermisoEnum.ACTUALIZAR);
            permisos.save(permisoActualizar);

            //Crear
            Permisos permisoCrear = new Permisos();
            permisoCrear.setPermiso(PermisoEnum.CREAR);
            permisos.save(permisoCrear);

            //Leer
            Permisos permisoLeer = new Permisos();
            permisoLeer.setPermiso(PermisoEnum.LEER);
            permisos.save(permisoLeer);

            //Eliminar
            Permisos permisoEliminar = new Permisos();
            permisoEliminar.setPermiso(PermisoEnum.ELIMINAR);
            permisos.save(permisoEliminar);
        }

        // Inicializar datos en la tabla Servicios
        if (servicioRepository.count() == 0) {

            Servicios misaRequiem = new Servicios();
            misaRequiem.setNombre("Misas de Réquiem");
            misaRequiem.setCosto(350.0f); // Precio base
            servicioRepository.save(misaRequiem);

            Servicios misaAniversario = new Servicios();
            misaAniversario.setNombre("Misa de Aniversario");
            misaAniversario.setCosto(300.0f); // Precio base
            servicioRepository.save(misaAniversario);

            Servicios misaCuerpoPresente = new Servicios();
            misaCuerpoPresente.setNombre("Misa de Cuerpo Presente");
            misaCuerpoPresente.setCosto(500.0f); // Precio base
            servicioRepository.save(misaCuerpoPresente);

            Servicios misaNovenario = new Servicios();
            misaNovenario.setNombre("Misa de Novenario");
            misaNovenario.setCosto(2000.0f); // Precio por novenario completo
            servicioRepository.save(misaNovenario);

            Servicios misaIntenciones = new Servicios();
            misaIntenciones.setNombre("Misa de Intenciones Especiales");
            misaIntenciones.setCosto(250.0f); // Precio base
            servicioRepository.save(misaIntenciones);

/**
 * ***********************************************************************************************
 */
            // Servicios - Nichos
            Servicios nichoIndividual = new Servicios();
            nichoIndividual.setNombre("Nicho Individual");
            nichoIndividual.setCosto(3000.0f); // Costo por el nicho individual
            servicioRepository.save(nichoIndividual);

            Servicios nichoFamiliar = new Servicios();
            nichoFamiliar.setNombre("Nicho Familiar");
            nichoFamiliar.setCosto(8500.0f); // Costo por el nicho familiar
            servicioRepository.save(nichoFamiliar);

            Servicios nichoConmemorativo = new Servicios();
            nichoConmemorativo.setNombre("Nicho Conmemorativo");
            nichoConmemorativo.setCosto(2000.0f); // Costo por el nicho conmemorativo
            servicioRepository.save(nichoConmemorativo);

            Servicios nichoPremium = new Servicios();
            nichoPremium.setNombre("Nicho Premium");
            nichoPremium.setCosto(12000.0f); // Costo por el nicho premium
            servicioRepository.save(nichoPremium);

            Servicios nichoTemporal = new Servicios();
            nichoTemporal.setNombre("Nicho Temporal");
            nichoTemporal.setCosto(1500.0f); // Costo por el nicho temporal
            servicioRepository.save(nichoTemporal);
        }
        //Valores de la Tabla EstadoServicio
        if (estadoServicioRepository.count() == 0) {

            EstadoServicio estadoServicioProceso = new EstadoServicio();
            estadoServicioProceso.setEstado(EstadoServicioEnum.EN_PROCESO);
            estadoServicioRepository.save(estadoServicioProceso);

            EstadoServicio estadoServicioCancelado = new EstadoServicio();
            estadoServicioCancelado.setEstado(EstadoServicioEnum.CANCELADO);
            estadoServicioRepository.save(estadoServicioCancelado);

            EstadoServicio estadoServicioFinalizado = new EstadoServicio();
            estadoServicioFinalizado.setEstado(EstadoServicioEnum.FINALISADO);
            estadoServicioRepository.save(estadoServicioFinalizado);


        }
    }



}
