package com.Backend.BackendCementerio.initBD;

import com.Backend.BackendCementerio.negocio.persistencia.models.EstadoServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.Servicios;
import com.Backend.BackendCementerio.negocio.persistencia.models.TipoServicio;
import com.Backend.BackendCementerio.negocio.persistencia.models.enums.EstadoServicioEnum;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.EstadoServicioRepository;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.ServicioRepository;
import com.Backend.BackendCementerio.negocio.persistencia.repositories.TipoServicioRepository;
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
    @Autowired
    private TipoServicioRepository tipoServicioRepository;

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

        // Inicializar datos de servicios
        if (servicioRepository.count() == 0) {

            Servicios misa = new Servicios();
            misa.setNombre("Misa");
            servicioRepository.save(misa);

            Servicios nicho = new Servicios();
            nicho.setNombre("Nicho");
            servicioRepository.save(nicho);

        }

        // Inicializar datos en la tabla TipoServicio
        if (tipoServicioRepository.count() == 0) {

            // Servicios - Misas
            TipoServicio misaRequiem = new TipoServicio();
            misaRequiem.setTipoServicio("Misas de Réquiem");
            misaRequiem.setCosto(350.0f); // Precio base
            tipoServicioRepository.save(misaRequiem);

            TipoServicio misaAniversario = new TipoServicio();
            misaAniversario.setTipoServicio("Misa de Aniversario");
            misaAniversario.setCosto(300.0f); // Precio base
            tipoServicioRepository.save(misaAniversario);

            TipoServicio misaCuerpoPresente = new TipoServicio();
            misaCuerpoPresente.setTipoServicio("Misa de Cuerpo Presente");
            misaCuerpoPresente.setCosto(500.0f); // Precio base
            tipoServicioRepository.save(misaCuerpoPresente);

            TipoServicio misaNovenario = new TipoServicio();
            misaNovenario.setTipoServicio("Misa de Acción De Gracias");
            misaNovenario.setCosto(2000.0f); // Precio por novenario completo
            tipoServicioRepository.save(misaNovenario);

            TipoServicio misaIntenciones = new TipoServicio();
            misaIntenciones.setTipoServicio("Misa de Intenciones Especiales");
            misaIntenciones.setCosto(250.0f); // Precio base
            tipoServicioRepository.save(misaIntenciones);

            /**
             * ***********************************************************************************************
             */
            // Servicios - Nichos
            TipoServicio nichoIndividual = new TipoServicio();
            nichoIndividual.setTipoServicio("Nicho Individual");
            nichoIndividual.setCosto(3000.0f); // Costo por el nicho individual
            tipoServicioRepository.save(nichoIndividual);

            TipoServicio nichoFamiliar = new TipoServicio();
            nichoFamiliar.setTipoServicio("Nicho Familiar");
            nichoFamiliar.setCosto(8500.0f); // Costo por el nicho familiar
            tipoServicioRepository.save(nichoFamiliar);

            TipoServicio nichoConmemorativo = new TipoServicio();
            nichoConmemorativo.setTipoServicio("Nicho Conmemorativo");
            nichoConmemorativo.setCosto(2000.0f); // Costo por el nicho conmemorativo
            tipoServicioRepository.save(nichoConmemorativo);

            TipoServicio nichoPremium = new TipoServicio();
            nichoPremium.setTipoServicio("Nicho Premium");
            nichoPremium.setCosto(12000.0f); // Costo por el nicho premium
            tipoServicioRepository.save(nichoPremium);

            TipoServicio nichoTemporal = new TipoServicio();
            nichoTemporal.setTipoServicio("Nicho Temporal");
            nichoTemporal.setCosto(1500.0f); // Costo por el nicho temporal
            tipoServicioRepository.save(nichoTemporal);
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
