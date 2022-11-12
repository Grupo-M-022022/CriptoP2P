package ar.edu.unq.criptop2p;


import ar.edu.unq.criptop2p.model.entity.CotizacionBinance;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

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
    public static final ArchRule reglanombreDTO =
            classes().that().haveSimpleNameEndingWith("DTO").
                    should().
                    resideInAnyPackage(paqueteDTO);

    @ArchTest
    public static final ArchRule reglaNombreService =
            classes().that().haveSimpleNameEndingWith("Service").
                    should().
                    resideInAnyPackage(paqueteService,"ar.edu.unq.criptop2p.service.imp",
                                                        "ar.edu.unq.criptop2p.service.interfaces");
    @ArchTest
    public static final ArchRule reglaNombreControlador =
            classes().that().haveSimpleNameEndingWith("Controller").
                    should().
                    resideInAPackage(paqueteWebService);


    @ArchTest
    public static final ArchRule reglaRepository =
            classes().that().resideInAPackage("ar.edu.unq.criptop2p.persistence.Imp").
                    should().beAnnotatedWith(Repository.class);

    @ArchTest
    public static final ArchRule reglaInterfacesRepository =
            classes().that().resideInAPackage("ar.edu.unq.criptop2p.persistence.interfaces").
                    should().beInterfaces();

    @ArchTest
    public static final ArchRule reglaService =
            classes().that().resideInAPackage("ar.edu.unq.criptop2p.service.imp").
                    should().beAnnotatedWith(Service.class);

    @ArchTest
    public static final ArchRule reglaInterfacesService =
            classes().that().resideInAPackage("ar.edu.unq.criptop2p.service.interfaces").
                    should().beInterfaces();

    @ArchTest
    public static  final ArchRule reglaReturnController =
            methods().that().arePublic().and().
                    areDeclaredInClassesThat().resideInAPackage("ar.edu.unq.criptop2p.webservice").
                    should().haveRawReturnType(ResponseEntity.class);

    @ArchTest
    public static final ArchRule reglaEntidades =
            classes().that().resideInAPackage("ar.edu.unq.criptop2p.model.entity").
                    should().beAnnotatedWith(Entity.class).
                    orShould().haveSimpleName("CotizacionBinance"); //Todo: Ver porque no toma esta clase la unica sin @entity dentro de la carpeta


    @ArchTest
    public static final ArchRule reglaParaLasDiferentesCapas = layeredArchitecture().consideringOnlyDependenciesInLayers()
            .layer(model).definedBy(paqueteModel)
            .layer(webservice).definedBy(paqueteWebService)
            .layer(service).definedBy(paqueteService)
            .layer(persistence).definedBy(paquetePersistence)

            .whereLayer(webservice).mayNotBeAccessedByAnyLayer()
            .whereLayer(model).mayOnlyBeAccessedByLayers(persistence,service)
            .whereLayer(persistence).mayOnlyBeAccessedByLayers(service)
            .whereLayer(service).mayOnlyBeAccessedByLayers(webservice,service);


    //Todo: No entiendo porque no funciona siendo que cumple las reglas de las capas


}
