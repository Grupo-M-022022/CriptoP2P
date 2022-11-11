package ar.edu.unq.criptop2p;


import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import javax.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

//Ignora tests para evitar posibles errores
@AnalyzeClasses(packages = "ar.edu.unq.criptop2p", importOptions = ImportOption.DoNotIncludeTests.class)

public class ArquitecturaTest {


    JavaClasses clasesJava = new ClassFileImporter().importPackages("ar.edu.unq.criptop2p");

    @ArchTest
    public static final ArchRule reglanombreDTO =
            classes().that().haveSimpleNameEndingWith("DTO").
                    should().
                    resideInAnyPackage("ar.edu.unq.criptop2p.model.dto");

    @ArchTest
    public static final ArchRule reglaNombreService =
            classes().that().haveSimpleNameEndingWith("Service").
                    should().
                    resideInAnyPackage("ar.edu.unq.criptop2p.service","ar.edu.unq.criptop2p.service.imp",
                                                        "ar.edu.unq.criptop2p.service.interfaces");
    @ArchTest
    public static final ArchRule reglaNombreControlador =
            classes().that().haveSimpleNameEndingWith("Controller").
                    should().
                    resideInAnyPackage("ar.edu.unq.criptop2p.webservice");



    @ArchTest
    public static final ArchRule reglaEntidades =
            classes().that().resideInAnyPackage("ar.edu.unq.criptop2p.model").
                    should().beAnnotatedWith(Entity.class).
                    orShould().haveSimpleName("CotizacionBinance"); //Todo: Ver porque no toma esta clase la unica sin @entity




    @ArchTest
    public static final ArchRule reglasParaLaCapaController = layeredArchitecture()
            .consideringOnlyDependenciesInLayers()
            .layer("webservice").definedBy("ar.edu.unq.criptop2p.webservice")
            .layer("service").definedBy("ar.edu.unq.criptop2p.service")
            .layer("persistence").definedBy("ar.edu.unq.criptop2p.persistence")


            .whereLayer("webservice").mayNotBeAccessedByAnyLayer()
            .whereLayer("service").mayOnlyBeAccessedByLayers("webservice")
            .whereLayer("persistence").mayOnlyBeAccessedByLayers("service");



}
