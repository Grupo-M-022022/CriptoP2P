package ar.edu.unq.criptop2p;


import ar.edu.unq.criptop2p.model.entity.CotizacionBinance;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

//Ignora tests para evitar posibles errores
@AnalyzeClasses(packages = "ar.edu.unq.criptop2p", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArquitecturaTest {

    public static  final String webservice = "webservice";
    public static  final String model = "model";
    public static  final String persistence = "persistence";
    public static  final String service = "service";


    public static final String paqueteDTO = "ar.edu.unq.criptop2p.model.dto";
    public static final String paqueteModel =  "ar.edu.unq.criptop2p.model";
    public static final String paqueteService =  "ar.edu.unq.criptop2p.service";
    public static final String paqueteWebService =  "ar.edu.unq.criptop2p.webservice";
    public static final String paquetePersistence=  "ar.edu.unq.criptop2p.persistence";


    @ArchTest
    ArchRule reglaPaqueteModelDTO =
            classes().that().haveSimpleNameEndingWith("DTO").
                    should().
                    resideInAnyPackage(paqueteDTO);

    @ArchTest
    ArchRule reglaSintaxisDeNombreEnPaqueteService =
            classes().that().haveSimpleNameEndingWith("Service").
                    should().
                    resideInAnyPackage(paqueteService,"ar.edu.unq.criptop2p.service.imp",
                                                        "ar.edu.unq.criptop2p.service.interfaces");
    @ArchTest
    ArchRule reglaSintaxisDeNombreEnElPaqueteWebService =
            classes().that().haveSimpleNameEndingWith("Controller").
                    should().
                    resideInAPackage(paqueteWebService);


    @ArchTest
    ArchRule reglaDeAnotacionRepositoryEnElPaquetePersistence =
            classes().that().resideInAPackage("ar.edu.unq.criptop2p.persistence.Imp").
                    should().beAnnotatedWith(Repository.class);

    @ArchTest
    ArchRule reglaDeSoloInterfacesEnElPaqueteDePersistencia =
            classes().that().resideInAPackage("ar.edu.unq.criptop2p.persistence.interfaces").
                    should().beInterfaces();

    @ArchTest
    ArchRule reglaDeAnotacionServiceEnElPaqueteService =
            classes().that().resideInAPackage("ar.edu.unq.criptop2p.service.imp").
                    should().beAnnotatedWith(Service.class);

    @ArchTest
    ArchRule reglaDeSoloInterfacesEnElPaqueteDeService =
            classes().that().resideInAPackage("ar.edu.unq.criptop2p.service.interfaces").
                    should().beInterfaces();

    @ArchTest
    ArchRule reglaDeLoQueDebeRetornarElControllerDentroDelPaqueteWebService =
            methods().that().arePublic().and().
                    areDeclaredInClassesThat().resideInAPackage("ar.edu.unq.criptop2p.webservice").
                    should().haveRawReturnType(ResponseEntity.class);

    @ArchTest
    ArchRule reglaDeAnotacionEntityEnElPaqueteModel =
            classes().that().resideInAPackage("ar.edu.unq.criptop2p.model.entity").
                    and().areNotAnonymousClasses(). // sin este metodo el archUnit realiza como una duplicacion de clases y no evalua con la regla
                    should().beAnnotatedWith(Entity.class).
                    orShould().haveSimpleName("CotizacionBinance");


    @ArchTest
    ArchRule reglaDeAccesosDeLasDiferentesCapasDelProyecto = layeredArchitecture().consideringAllDependencies()
            .optionalLayer(model).definedBy(paqueteModel)
            .optionalLayer(webservice).definedBy(paqueteWebService)
            .optionalLayer(service).definedBy(paqueteService)
            .optionalLayer(persistence).definedBy(paquetePersistence)

            .whereLayer(webservice).mayNotBeAccessedByAnyLayer()
            .whereLayer(model).mayOnlyBeAccessedByLayers(persistence,service)
            .whereLayer(persistence).mayOnlyBeAccessedByLayers(service)
            .whereLayer(service).mayOnlyBeAccessedByLayers(webservice,service);

}
